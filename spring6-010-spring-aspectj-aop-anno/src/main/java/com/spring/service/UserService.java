package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class UserService { // 目标类
    public void login() { // 目标方法
        System.out.println(">>>>系统登录中<<<<");
    }
    public void logout() {
        System.out.println(">>>>退出系统<<<<");
    }
}
