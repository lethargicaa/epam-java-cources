package com.epam.university.java.core.task034;


import org.xml.sax.helpers.DefaultHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;


public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("src/main/resources" + filepath), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ((SaxHandlerImpl) handler).getPerson();
    }

    @Override
    public Person readWithJaxbParser(String filepath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return (PersonImpl) unmarshaller.unmarshal(new File("src/main/resources" + filepath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) throws XMLStreamException {
        Person person = new PersonImpl();
        PhoneNumber phoneNumber = new PhoneNumberImpl();
        Collection<PhoneNumber> phoneNumbers = null;
        while (streamReader.hasNext()) {
            streamReader.next();

            if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
                if (streamReader.getLocalName().equalsIgnoreCase("person")) {

                    if (streamReader.getAttributeCount() > 0) {
                        String id = streamReader.getAttributeValue(null, "id");
                        person.setId(Integer.parseInt(id));
                    }
                }
                if (streamReader.getLocalName().equalsIgnoreCase("first-name")) {
                    person.setFirstName(streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("last-name")) {
                    person.setLastName(streamReader.getElementText());
                }
                if (streamReader.getLocalName().equalsIgnoreCase("person-phones")) {
                    phoneNumbers = new ArrayList<>();
                    person.setPhoneNumbers(phoneNumbers);
                }
                if (streamReader.getLocalName().equalsIgnoreCase("person-phone")) {
                    phoneNumbers.add(new PhoneNumberImpl(streamReader.getElementText()));
                }
            }
        }
        return person;
    }
}