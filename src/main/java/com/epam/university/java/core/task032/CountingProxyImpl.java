package com.epam.university.java.core.task032;

import java.lang.reflect.Method;

public class CountingProxyImpl implements CountingProxy {

    public CountingProxyImpl proxy = new CountingProxyImpl();
    public ClassLoader proxyClassLoader = proxy.getClass().getClassLoader();
    Class[] interfaces = proxy.getClass().getInterfaces();


    @Override
    public int getInvocationsCount(String methodName) {
        return 0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
//Get amount of method call.
//     * @param methodName method name
//     * @return amount of call