package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beans")
public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    @Override
    public void addBeanDefinition(BeanDefinition definition) {

    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return null;
    }
}
