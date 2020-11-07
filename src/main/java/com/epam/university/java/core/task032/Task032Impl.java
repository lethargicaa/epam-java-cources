package com.epam.university.java.core.task032;

import java.lang.reflect.Proxy;

public class Task032Impl implements Task032 {
    @Override
    public CountingProxy createProxyWrapper() {

//        CountingProxyImpl proxyInstance = (CountingProxyImpl) Proxy.newProxyInstance(
//                DynamicProxyTest.class.getClassLoader(),
 //               new Class[] {CountingProxyImpl.class},
 //               new DynamicInvocationHandler()
 //       );
 //    * Create proxy wrapper.
 //               * @return proxy instance
//                */
    return null;
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {

//        /**
//         * Create action executor with given proxy instance.
//         * @param proxy proxy instance
//         * @return action executor instance
//         */

        return null;
    }
}
