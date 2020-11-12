package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.*;


import javax.xml.bind.annotation.*;
import java.util.Collection;

@JsonRootName("person")
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({ @JsonSubTypes.Type(value = PhoneNumberImpl.class, name = "phones") })

public class PersonImpl implements Person {

    @XmlAttribute
    private int id;

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElementWrapper(name = "person-phones")
    @XmlElements({@XmlElement(type = PhoneNumberImpl.class, name = "person-phone")})

    private Collection<PhoneNumber> phoneNumbers;

    public PersonImpl() {
    }

    public PersonImpl(@JsonProperty("id") int id, @JsonProperty("firstName") String firstName,
                      @JsonProperty("lastName") String lastName,
                      @JsonProperty("phones")
                      Collection<PhoneNumber> phoneNumbers) {


        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public Collection<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public void setPhoneNumbers(Collection<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
/*
   @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
      include = As.PROPERTY, property = "type") @JsonSubTypes({

      @JsonSubTypes.Type(value = Square.class, name = "square"),
      @JsonSubTypes.Type(value = Circle.class, name = "circle")
   })

 */