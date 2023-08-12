package org.spring.dao.impl;

import org.spring.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository("orderDaoImplOracle")
public class OrderDaoImplOracle implements OrderDao {
    @Override
    public void inset() {
        System.out.println("Oracle insert...");
    }
}
