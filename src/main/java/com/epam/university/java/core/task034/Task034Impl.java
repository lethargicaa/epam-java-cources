package com.epam.university.java.core.task034;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;

public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) throws ParserConfigurationException,
            SAXException, IOException {
//        File file = new File(filepath);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
//        XMLReader xmlReader = saxParser.getXMLReader();

        SaxHandlerImpl saxHandlerImpl = new SaxHandlerImpl();
        parser.parse(new File(filepath), saxHandlerImpl);

        return new PersonImpl();
    }

    @Override
    public Person readWithJaxbParser(String filepath) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(PersonImpl.class, PhoneNumberImpl.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PersonImpl person = (PersonImpl) jaxbUnmarshaller.unmarshal(new File(filepath));
        return person;

    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        return null;
    }
}


///Users/antonbanov/Documents/epam-java-cources/src/main/resources/task034/data.xml

//SAXparser vs XMLparser
//The parse methods of SAXParser just delegate to an internal instanceof XMLReader and are usually more convenient.
// For some more advanced usecases you have to use XMLReader. Some examples would be
//
//Setting non-standard features of the implementation
//Setting different classes as ContentHandler, EntityResolver or ErrorHandler
//Switching handlers while parsing