package com.spring.bank.service.impl;

import com.spring.bank.dao.AccountDao;
import com.spring.bank.pojo.Account;
import com.spring.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, Double money) {
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
        Account toAct = accountDao.selectByActno(toActno);

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountDao.update(fromAct);
        // System.out.println(1/0);
        count += accountDao.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败");
        } else {
            System.out.println("count = " + count);
        }
    }
}
