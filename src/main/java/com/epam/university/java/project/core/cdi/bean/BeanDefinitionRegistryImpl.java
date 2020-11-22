package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;


public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        beanDefinitions.put(definition.getId(), definition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitions.get(prepareBeanId(beanId));
    }

    private static String prepareBeanId(String beanId) {
        beanId = firstLowerCase(beanId);
        if (beanId.endsWith("Interface")) {
            return getRidOfInterfaceWord(beanId);
        }
        return beanId;
    }

    private static String firstLowerCase(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }

    private static String getRidOfInterfaceWord(String word) {
        return word.replace("Interface", "");
    }
}
