package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Collection;


public class SaxHandlerImpl extends SaxHandler {
    private PersonImpl person;
    private PhoneNumberImpl phone;

    boolean fName = false;
    boolean lName = false;
//    boolean pPhone = false;

    Collection<PhoneNumberImpl> phoneNumbers = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        if ("person".equalsIgnoreCase(qName)) {
            person = new PersonImpl();
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }

        switch (qName) {
            case "first-name":
                fName = true;
                break;
            case "last-name":
                lName = true;
                break;
//            case "person-phone":
//                pPhone = true;
//                break;
            }
        }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (fName) {
            person.setFirstName(new String(ch, start, length));
            fName = false;
        }
        if (lName) {
            person.setLastName(new String(ch, start, length));
            lName = false;
        }
    }
}
//end-element start-element characters