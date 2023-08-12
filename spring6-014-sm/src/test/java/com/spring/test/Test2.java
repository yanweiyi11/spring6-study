package com.spring.test;

import com.spring.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-config.xml")
public class Test2 {

    @Autowired
    private User user;

    @Test
    public void t1() {
        System.out.println(user.getName());
    }
}
