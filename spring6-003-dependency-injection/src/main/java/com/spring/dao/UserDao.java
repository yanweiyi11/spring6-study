package com.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    public void insert() {
        LOGGER.info("正在保存User信息!!!!");
    }
}
