package com.spring.bank.service.impl;

import com.spring.bank.dao.AccountDao;
import com.spring.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("i1")
public class IsolationService1 {

    @Resource
    private AccountDao accountDao;

    // 1号
    // 负责查询
    // 当前事务可以读取到别的事务没有提交的数据
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getAccount(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息 = " + account);
    }

}
