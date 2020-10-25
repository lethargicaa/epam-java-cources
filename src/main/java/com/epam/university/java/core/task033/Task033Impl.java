package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) throws GreaterExceptionImpl, LessExceptionImpl {
        if (first == 0 && second == 0) {
            throw new ArithmeticException();
        }
        if (first > second) {
            var innerException = new BaseExceptionImpl();
            throw new GreaterExceptionImpl("First > Second", innerException);
        } else if (first < second) {
            var innerException = new BaseExceptionImpl();
            throw new LessExceptionImpl("Second > First", innerException);
        }
    }
}
