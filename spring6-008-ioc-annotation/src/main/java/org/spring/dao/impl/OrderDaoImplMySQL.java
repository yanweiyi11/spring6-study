package org.spring.dao.impl;

import org.spring.dao.OrderDao;
import org.springframework.stereotype.Repository;

// @Repository("orderDaoImplMySQL")
public class OrderDaoImplMySQL implements OrderDao {
    @Override
    public void inset() {
        System.out.println("Mysql insert...");
    }
}
