package com.spring.test;

import com.spring.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test09() {

    }
    @Test
    public void test08() {

    }
    @Test
    public void test07() {

    }
    @Test
    public void test06() {

    }
    @Test
    public void test05() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }
    @Test
    public void test04() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test03() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Start start = applicationContext.getBean("start", Start.class);
        System.out.println(start);
    }

    @Test
    public void test01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }
}
