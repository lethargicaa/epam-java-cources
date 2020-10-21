package com.epam.university.java.core.task033;

public class LessExceptionImpl extends Exception implements LessException {
    LessExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
}
