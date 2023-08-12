package com.spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OtherDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OtherDao.class);

    public void insert() {
        LOGGER.info("订单正在生成...");
    }
}
