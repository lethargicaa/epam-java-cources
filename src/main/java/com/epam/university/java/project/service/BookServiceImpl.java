package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private StateMachineManager stateMachineManager;
    private Resource stateMachineDefinitionXml;
    private StateMachineDefinition<BookStatus, BookEvent> definition;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public StateMachineManager getStateMachineManager() {
        return stateMachineManager;
    }

    public void setStateMachineManager(StateMachineManager stateMachineManager) {
        this.stateMachineManager = stateMachineManager;
    }

    public Resource getStateMachineDefinitionXml() {
        return stateMachineDefinitionXml;
    }

    public void setStateMachineDefinitionXml(Resource stateMachineDefinitionXml) {
        this.stateMachineDefinitionXml = stateMachineDefinitionXml;
    }

    public StateMachineDefinition<BookStatus, BookEvent> getDefinition() {
        return definition;
    }

    public void setDefinition(StateMachineDefinition<BookStatus, BookEvent> definition) {
        this.definition = definition;
    }

    /**
     * Public default constructor for initializing stateMachine.
     */
    @SuppressWarnings("unchecked")
    public BookServiceImpl() {
        final String contextPath = getClass()
                .getResource("/project/DefaultBookStateMachineDefinition.xml")
                .getFile();
        stateMachineDefinitionXml = new XmlResource(contextPath);
        bookDao = new BookDaoXmlImpl();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Book createBook() {
        definition = (StateMachineDefinition<BookStatus, BookEvent>) stateMachineManager
                .loadDefinition(stateMachineDefinitionXml);
        Book book = bookDao.createBook();
        stateMachineManager.handleEvent(stateMachineManager.initStateMachine(book, definition),
                BookEvent.CREATE);
        return book;
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }

    @Override
    public Collection<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public void remove(Book book) {
        bookDao.remove(book);
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book accept(Book book, String number) {
        book.setSerialNumber(number);
        stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
        return book;
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        stateMachineManager.handleEvent(book, BookEvent.ISSUE);
        return book;
    }

    @Override
    public Book returnFromIssue(Book book) {
        stateMachineManager.handleEvent(book, BookEvent.RETURN);
        return book;
    }
}
