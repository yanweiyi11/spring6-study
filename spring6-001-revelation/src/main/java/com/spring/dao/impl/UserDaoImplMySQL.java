package com.spring.dao.impl;

import com.spring.dao.UserDao;

public class UserDaoImplMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("mysql......");
    }
}
