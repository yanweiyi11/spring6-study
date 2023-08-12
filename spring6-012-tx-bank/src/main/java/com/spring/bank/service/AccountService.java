package com.spring.bank.service;

import com.spring.bank.pojo.Account;

public interface AccountService {
    void transfer(String fromActno, String toActno, Double money);
    void save(Account account);
}
