package com.spring.test;

import com.spring.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

    @Test
    public void t1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 1000.0);
            System.out.println("成功");
        } catch (Exception e) {
            System.out.println("失败");
        }
    }
}
