package com.spring.bank.service.impl;

import com.spring.bank.dao.AccountDao;
import com.spring.bank.pojo.Account;
import com.spring.bank.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, Double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account account) {
        accountDao.insert(account);
        // 模拟异常
        System.out.println(1/0);
        // 剩下的代码无法执行，已经卡死
    }
}
