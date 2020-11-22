package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)

public class MapDefinitionImpl extends StructureDefinitionImpl implements MapDefinition {


    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    private Collection<MapEntryDefinition> values;

    public MapDefinitionImpl() {
    }

    public MapDefinitionImpl(Collection<MapEntryDefinition> values) {
        this.values = values;
    }

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
    }

    @XmlRootElement(name = "entry")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class MapEntryDefinitionImpl implements MapEntryDefinition {
        @XmlElement
        private String key;
        @XmlElement
        private String value;
        @XmlElement
        private String ref;

        public MapEntryDefinitionImpl() {
        }

        /**
         * MapEntryDefinitionImpl.
         */
        public MapEntryDefinitionImpl(String key, String value, String ref) {
            this.key = key;
            this.value = value;
            this.ref = ref;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String getRef() {
            return ref;
        }

        @Override
        public void setRef(String reference) {
            this.ref = reference;
        }

    }

}