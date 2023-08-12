package com.spring.proxy.util;

import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target)
        );
    }

}
