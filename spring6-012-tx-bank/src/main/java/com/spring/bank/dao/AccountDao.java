package com.spring.bank.dao;

import com.spring.bank.pojo.Account;

public interface AccountDao {
    Account selectByActno(String actno);

    int update(Account account);

    int insert(Account account);
}
