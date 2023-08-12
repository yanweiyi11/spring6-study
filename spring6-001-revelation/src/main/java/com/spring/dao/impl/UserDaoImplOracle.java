package com.spring.dao.impl;

import com.spring.dao.UserDao;

public class UserDaoImplOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("oracle......");
    }
}
