package com.spring.test;

import com.spring.bean.*;
import com.spring.jdbc.MyDataSource;
import com.spring.jdbc.MyDataSource1;
import com.spring.jdbc.MyDataSource2;
import com.spring.service.CustomerService;
import com.spring.service.OtherService;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DITest {
    @Test
    public void test10() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-pro.xml");
        MyDataSource dataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }
    @Test
    public void test9() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        // OtherService otherService = applicationContext.getBean("otherService", OtherService.class);
        // otherService.generate();
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();
    }

    @Test
    public void test8() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 dataSource1 = applicationContext.getBean("dataSource1", MyDataSource1.class);
        MyDataSource2 dataSource2 = applicationContext.getBean("dataSource2", MyDataSource2.class);
        System.out.println(dataSource1);
        System.out.println(dataSource2);
    }

    @Test
    public void test7() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people);
    }

    @Test
    public void test6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dog = applicationContext.getBean("dog", Dog.class);
        System.out.println(dog);
    }

    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println("mathBean = " + mathBean);
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat cat = applicationContext.getBean("cat", Cat.class);
        System.out.println("cat = " + cat);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-coll.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe qianDaye = applicationContext.getBean("qianDaYe", QianDaYe.class);
        System.out.println(qianDaye);
    }

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Student student = applicationContext.getBean("student", Student.class);
        Clazz clazz = applicationContext.getBean("clazz", Clazz.class);
        System.out.println(student);
        System.out.println(clazz);
    }

    @Test
    public void testSetDI5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testSetDI4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType simpleValueType = applicationContext.getBean("simpleValueType", SimpleValueType.class);
        System.out.println("simpleValueType = " + simpleValueType);
    }

    @Test
    public void testSetDI3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user = " + user);
    }

    @Test
    public void testSetDI2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OtherService otherService = applicationContext.getBean("otherService2", OtherService.class);
        otherService.generate();
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("customerService3", CustomerService.class);
        customerService.save();
    }

    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.save();
    }
}