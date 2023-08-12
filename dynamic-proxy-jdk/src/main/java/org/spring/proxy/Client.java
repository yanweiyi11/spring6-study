package org.spring.proxy;

import org.spring.proxy.service.UserService;
import org.spring.proxy.service.UserServiceImpl;
import org.spring.proxy.util.EnhanceInvocationHandler;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        // 目标对象
        UserService target = new UserServiceImpl();

        // 代理对象
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new EnhanceInvocationHandler(target)
        );

        // 调用代理对象的代理方法
        String result = proxyInstance.getUser();
        System.out.println(result);
    }
}
