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
// @Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDaoImpl")
    private AccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transfer(String fromActno, String toActno, Double money) {
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足");
        }
        Account toAct = accountDao.selectByActno(toActno);

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);
        if (count != 2) {
            throw new RuntimeException("转账失败");
        } else {
            System.out.println("count = " + count);
        }
        // withdraw();
    }

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void save(Account account) {
        // 调用dao的insert方法
        accountDao.insert(account); // act-003

        // 创建账户对象
        Account account2 = new Account("act-004", 10000.0);
        try {
            accountService.save(account2); // act-004
        } catch (Exception e) {

        }
    }

}
