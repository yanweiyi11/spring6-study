package com.spring.test;

import com.spring.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class Test1 {
    @Autowired
    private User user;

    @Test
    public void t1() {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.getName());*/
        System.out.println(user.getName());
    }
}
