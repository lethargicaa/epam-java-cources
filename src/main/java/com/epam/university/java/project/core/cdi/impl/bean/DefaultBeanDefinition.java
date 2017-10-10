package com.epam.university.java.project.core.cdi.impl.bean;

import com.epam.university.java.project.core.cdi.bean.BeanDefinition;
import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinition;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Meta information about bean in context environment.
 */
@XmlRootElement(name = "bean")
public class DefaultBeanDefinition implements BeanDefinition {

    private String id;
    private String className;

    private Collection<BeanPropertyDefinition> properties;

    private String postConstruct;
    private String scope;

    public DefaultBeanDefinition() {
        properties = new ArrayList<>();
    }

    /**
     * Get the bean id.
     * @return id of bean
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Set the bean id.
     * @param id id of bean
     */
    @Override
    @XmlAttribute(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get bean class name.
     * @return name of class
     */
    @Override
    public String getClassName() {
        return className;
    }

    /**
     * Set bean class name.
     * @param className name of class
     */
    @Override
    @XmlAttribute(name = "class")
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get bean properties.
     * @return collection of bean properties
     */
    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return properties;
    }

    /**
     * Set bean properties.
     * @param properties collection of bean properties
     */
    @Override
    @XmlAnyElement(lax = true)
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.properties = properties;
    }

    /**
     * Get method name which is called after bean created and dependencies injected.
     * @return method name
     */
    @Override
    public String getPostConstruct() {
        return postConstruct;
    }

    /**
     * Set post-construct method name.
     * @param methodName method name
     */
    @Override
    @XmlAttribute(name = "init")
    public void setPostConstruct(String methodName) {
        this.postConstruct = methodName;
    }

    /**
     * Get the bean scope.
     * @return bean scope
     */
    @Override
    public String getScope() {
        return scope;
    }

    /**
     * Set the bean scope.
     * @param scope bean scope
     */
    @Override
    @XmlAttribute(name = "scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

}