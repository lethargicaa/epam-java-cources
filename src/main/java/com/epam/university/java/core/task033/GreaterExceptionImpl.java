package com.epam.university.java.core.task033;

public class GreaterExceptionImpl extends Exception implements GreaterException {
    GreaterExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }
}
