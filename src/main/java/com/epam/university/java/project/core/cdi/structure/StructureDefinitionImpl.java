package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
public class StructureDefinitionImpl {
    @XmlElement(name = "map", type = MapDefinitionImpl.class)
    private Collection<MapDefinition> mapDefinitions;
    @XmlElement(name = "list", type = ListDefinitionImpl.class)
    private Collection<ListDefinition> listDefinitions;

    public StructureDefinitionImpl() {
    }

    public StructureDefinitionImpl(Collection<MapDefinition> mapDefinitions,
                                   Collection<ListDefinition> listDefinitions) {
        this.mapDefinitions = mapDefinitions;
        this.listDefinitions = listDefinitions;
    }

    public Collection<MapDefinition> getMapDefinitions() {
        return mapDefinitions;
    }

    public void setMapDefinitions(Collection<MapDefinition> mapDefinitions) {
        this.mapDefinitions = mapDefinitions;
    }

    public Collection<ListDefinition> getListDefinitions() {
        return listDefinitions;
    }

    public void setListDefinitions(Collection<ListDefinition> listDefinitions) {
        this.listDefinitions = listDefinitions;
    }

}
