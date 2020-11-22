package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "property")
@XmlAccessorType(XmlAccessType.FIELD)

public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {

    public BeanPropertyDefinitionImpl() {
    }

    /**
     * BeanPropertyDefinitionImpl.
     */
    public BeanPropertyDefinitionImpl(String name,
                                      String value,
                                      String ref,
                                      StructureDefinition data) {
        this.name = name;
        this.value = value;
        this.ref = ref;
        this.data = data;
    }

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String value;
    @XmlAttribute
    private String ref;
    @XmlElements({
            @XmlElement(type = ListDefinitionImpl.class, name = "list"),
            @XmlElement(type = MapDefinitionImpl.class, name = "map")
    })
    private StructureDefinition data;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getRef() {
        return this.ref;
    }

    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public StructureDefinition getData() {
        return this.data;
    }

    @Override
    public void setData(StructureDefinition data) {
        this.data = data;
    }
}
