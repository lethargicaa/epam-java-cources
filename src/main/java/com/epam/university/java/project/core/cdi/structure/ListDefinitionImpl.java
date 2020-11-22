package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;


public class ListDefinitionImpl extends StructureDefinitionImpl implements ListDefinition {

    @XmlElement(name = "value", type = ListItemDefinitionImpl.class)
    private Collection<ListItemDefinition> items;

    public ListDefinitionImpl() {
    }

    public ListDefinitionImpl(Collection<ListItemDefinition> items) {
        this.items = items;
    }

    @Override
    public Collection<ListItemDefinition> getItems() {
        return items;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.items = items;
    }

    @XmlRootElement(name = "value")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ListItemDefinitionImpl implements ListItemDefinition {

        public ListItemDefinitionImpl() {
        }

        public ListItemDefinitionImpl(String value) {
            this.value = value;
        }

        @XmlValue
        private String value;

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

    }
}
