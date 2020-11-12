package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.core.task034.PersonImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionImpl;
import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {
    @Override
    public int loadBeanDefinitions(Resource resource) {
//        JAXBContext jaxbContext = JAXBContext.newInstance(BeanDefinitionImpl.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//
//         (PersonImpl) unmarshaller.unmarshal());
        return 0;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return 0;
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return null;
    }

    @Override
    public Object getBean(String beanName) {
        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return null;
    }
}
