package org.spring.proxy.service;

public class UserServiceImpl implements UserService { // 目标对象
    @Override
    public String getUser() { // 目标方法
        System.out.println("===目标方法被调用===");
        return "###我是返回值###";
    }
}
