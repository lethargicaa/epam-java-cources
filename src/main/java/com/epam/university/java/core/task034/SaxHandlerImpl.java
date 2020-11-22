package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import java.util.ArrayList;
import java.util.Collection;


public class SaxHandlerImpl extends SaxHandler {
    public PersonImpl getPerson() {
        return person;
    }

    private Collection<PhoneNumber> phoneNumbers;
    private PersonImpl person;
    private String firstName;
    private String lastName;
    private int id;
    private String lastElementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastElementName = qName;
        if (lastElementName.equals("person")) {
            id = Integer.parseInt(attributes.getValue("id"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();

        if (!information.equals("") && lastElementName.equals("first-name")) {
            firstName = information;
        }
        if (!information.equals("") && lastElementName.equals("last-name")) {
            lastName = information;
        }

        if (!information.equals("") && lastElementName.equals("person-phone")) {
            if (phoneNumbers == null) {
                phoneNumbers = new ArrayList<>();
            }
            phoneNumbers.add(new PhoneNumberImpl(information));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ((firstName != null && !firstName.isEmpty())
                && (lastName != null && !lastName.isEmpty())
                && (id != 0)) {
            person = new PersonImpl(id, firstName, lastName, phoneNumbers);
        }
    }
}
