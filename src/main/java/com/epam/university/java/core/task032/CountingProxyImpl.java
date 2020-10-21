package com.epam.university.java.core.task032;

import java.lang.reflect.Method;

public class CountingProxyImpl implements CountingProxy {
    @Override
    public int getInvocationsCount(String methodName) {
        return 0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
