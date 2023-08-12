package org.spring.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void saveUser() {
        System.out.println("新增用户信息...");
    }

    public void delUser() {
        System.out.println("删除用户信息...");
    }

    public void updUser() {
        System.out.println("修改用户信息...");
    }

    public void selUser() {
        System.out.println("查看用户信息...");
    }
}
