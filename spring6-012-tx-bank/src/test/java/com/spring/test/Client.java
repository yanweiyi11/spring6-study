package com.spring.test;

import com.spring.bank.Spring6Config;
import com.spring.bank.pojo.Account;
import com.spring.bank.service.AccountService;
import com.spring.bank.service.impl.IsolationService1;
import com.spring.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Client {
    @Test
    public void t5() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("act-001", "act-002", 1000.00);
    }

    @Test
    public void t4() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        i2.save(new Account("act-003", 10000.0));
    }

    @Test
    public void t3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getAccount("act-003");
    }

    @Test
    public void t2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.save(new Account("act-003", 5000.0));
    }

    @Test
    public void t1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("act-001", "act-002", 500.00);
    }
}
