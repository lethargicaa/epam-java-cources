package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinitionImpl;
import com.epam.university.java.project.core.cdi.bean.BeansList;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinitionImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationContextImpl implements ApplicationContext {

    private BeanDefinitionRegistryImpl beanDefinitionRegistry = new BeanDefinitionRegistryImpl();
    private final Map<String, Object> singletones = new HashMap<>();
    Map<Class, String> beanClassesRegistry = new HashMap<>();

    @Override
    public int loadBeanDefinitions(Resource resource) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    //             BeanDefinitionRegistryImpl.class,
                    BeanDefinitionImpl.class,
                    BeanPropertyDefinitionImpl.class,
                    BeansList.class,
                    ListDefinitionImpl.class,
                    MapDefinitionImpl.class,
                    StructureDefinitionImpl.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            BeansList beans = (BeansList) unmarshaller.unmarshal(resource.getFile());
            beans.getBeans().forEach(bean -> {
                beanDefinitionRegistry.addBeanDefinition(bean);
                try {
                    beanClassesRegistry.put(Class.forName(bean.getClassName()), bean.getId());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {

        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }

        return 0;
    }

    @Override
    public Object getBean(String beanName) {
        return getBean(beanName, Object.class);
    }


    @Override
    public <T> T getBean(Class<T> beanClass) {
        return getBean(beanClass.getSimpleName(), beanClass);
    }


    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        BeanDefinition def = beanDefinitionRegistry.getBeanDefinition(beanName);

        if ("singleton".equals(def.getScope()) && this.singletones.containsKey(beanName)) {
            return (T) this.singletones.get(beanName);
        }

        try {
            Class<?> clazz = Class.forName(def.getClassName());
            Constructor<?> constructor = clazz.getConstructor();
            Object bean = constructor.newInstance();

            if (def.getProperties() != null) {
                for (BeanPropertyDefinition bp : def.getProperties()) {
                    if (bp.getData() == null && bp.getValue() == null && bp.getRef() == null) {
                        throw new RuntimeException();
                    }

                    Field field = clazz.getDeclaredField(bp.getName());
                    Class<?> fieldType = field.getType();
                    Method nameMethod = clazz.getMethod("set"
                                    + firstUpperCase(bp.getName()),
                            fieldType);
                    Object fieldValue;

                    if (bp.getRef() != null) {
                        nameMethod.invoke(bean, getBean(bp.getRef()));
                        continue;
                    }

                    fieldValue = getAndParseFieldValue(bp, field, fieldType);
                    nameMethod.invoke(bean, fieldValue);
                }
            }

            if ("singleton".equals(def.getScope())) {
                this.singletones.put(beanName, bean);
            }

            return (T) bean;

        } catch (NoSuchFieldException
                | ClassNotFoundException
                | NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException
                | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object getAndParseFieldValue(BeanPropertyDefinition bp,
                                         Field field,
                                         Class<?> fieldType) throws NoSuchFieldException {
        Object fieldValue;
        if (fieldType == String.class) {
            fieldValue = bp.getValue();
        } else if (fieldType == Integer.class || fieldType == int.class) {
            fieldValue = Integer.parseInt(bp.getValue());
        } else if (fieldType == Collection.class) {
            fieldValue = null;
            Type genericFieldType = field.getGenericType();
            if (genericFieldType instanceof ParameterizedType) {
                Type[] declaredGenericTypes =
                        ((ParameterizedType) genericFieldType).getActualTypeArguments();
                Collection<?> collection = getGenericCollection(declaredGenericTypes[0].getClass(),
                        bp.getData());
                fieldValue = collection;
            }
        } else if (fieldType == Map.class) {
            fieldValue = null;
            Type genericFieldType = field.getGenericType();
            if (genericFieldType instanceof ParameterizedType) {
                Type[] declaredGenericTypes =
                        ((ParameterizedType) genericFieldType).getActualTypeArguments();
                Map<?, ?> map = getGenericMap(declaredGenericTypes[0].getClass(),
                        declaredGenericTypes[1].getClass(), bp.getData());
                fieldValue = map;
            }
        } else {
            throw new NoSuchFieldException("Don't know how to set a " + field.getType().getName());
        }
        return fieldValue;
    }

    //метод, меняющий первую букву в слове на заглавную
    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private <T> Collection<T> getGenericCollection(Class<T> type, StructureDefinition params) {
        if (params instanceof ListDefinition) {
            List<T> list = new ArrayList<>();
            for (ListDefinition.ListItemDefinition listItemDefinition :
                    ((ListDefinition) params).getItems()) {
                //TODO generify it!
                list.add((T) listItemDefinition.getValue());
            }
            return list;
        } else {
            return null;
        }
    }

    private <K, V> Map<K, V> getGenericMap(Class<K> keyType,
                                           Class<V> valueType,
                                           StructureDefinition params) {
        if (params instanceof MapDefinition) {
            Map<K, V> map = new HashMap<>();
            for (MapDefinition.MapEntryDefinition mapEntryDefinition :
                    ((MapDefinition) params).getValues()) {
                //TODO generify it!
                V value = null;
                if (mapEntryDefinition.getRef() != null
                        && mapEntryDefinition.getValue() != null) {
                    throw new RuntimeException();
                }

                if (mapEntryDefinition.getRef() != null) {
                    value = (V) getBean(mapEntryDefinition.getRef());
                } else {
                    value = (V) mapEntryDefinition.getValue();
                }
                map.put((K) mapEntryDefinition.getKey(), value);
            }
            return map;
        } else {
            return null;
        }
    }
}
