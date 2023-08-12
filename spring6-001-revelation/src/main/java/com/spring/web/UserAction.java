package com.spring.web;

import com.spring.service.UserService;
import com.spring.service.impl.UserServiceImpl;

/**
 * 表示层
 */
public class UserAction {
    // private UserService userService = new UserServiceImpl();
    private UserService userService;

    public void deleteRequest() {
        userService.deleteUser();
    }
}
