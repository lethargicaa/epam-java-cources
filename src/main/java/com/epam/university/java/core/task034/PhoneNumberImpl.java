package com.epam.university.java.core.task034;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)

@JsonRootName("phones")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumberImpl implements PhoneNumber {

    @XmlValue
    private String phoneNumber;

    public PhoneNumberImpl() {
    }
    @JsonCreator
    public PhoneNumberImpl(@JsonProperty("phone") String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
