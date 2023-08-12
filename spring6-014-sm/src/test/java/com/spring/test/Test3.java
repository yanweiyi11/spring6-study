package com.spring.test;

import com.spring.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-config.xml")
public class Test3 {

    @Autowired
    private AccountService accountService;

    @Test
    public void t1() {
        try {
            accountService.transfer("act-001", "act-002", 1000);
            System.out.println("成功了");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
