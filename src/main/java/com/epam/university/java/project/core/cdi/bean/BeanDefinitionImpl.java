package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.*;
import java.util.Collection;

@XmlRootElement(name = "bean")
@XmlAccessorType(XmlAccessType.FIELD)

public class BeanDefinitionImpl implements BeanDefinition{

    @XmlAttribute
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlElement(name = "property")
    private Collection<BeanPropertyDefinition> properties;
    @XmlAttribute(name = "init")
    private String methodName;
    @XmlAttribute
    private String scope;

    public BeanDefinitionImpl(String id, String className, Collection<BeanPropertyDefinition> properties, String methodName, String scope) {
        this.id = id;
        this.className = className;
        this.properties = properties;
        this.methodName = methodName;
        this.scope = scope;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getClassName() {
        return this.className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return this.properties;
    }

    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.properties = properties;
    }

    @Override
    public String getPostConstruct() {
        return this.methodName;
    }

    @Override
    public void setPostConstruct(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }
}
