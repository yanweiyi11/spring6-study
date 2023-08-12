package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImplMySQL;
import com.spring.dao.impl.UserDaoImplOracle;
import com.spring.service.UserService;

public class UserServiceImpl implements UserService {
    // private UserDao userDao = new UserDaoImplMySQL();
    // private UserDao userDao = new UserDaoImplOracle();

    private UserDao userDao;
    
    @Override
    public void deleteUser() {
        // 删除用户信息的业务逻辑
        userDao.deleteById();
        // ......
    }
}
