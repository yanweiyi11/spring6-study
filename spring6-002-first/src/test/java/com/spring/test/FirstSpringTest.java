package com.spring.test;

import com.spring.bean.User;
import com.spring.dao.UserDaoImplMySQL;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;


public class FirstSpringTest {
    @Test
    public void testBeanFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("userBean = " + userBean);

        // 获取类的日志记录器对象，也就是说只要是类中的代码执行记录日志的话，就输出相关的日志信息.
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
        logger.info("msg..info");
        logger.debug("msg...debug");
        logger.error("error");
    }

    @Test
    public void testFileXmlPath() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "D:\\Workshop\\Java\\JavaLearningProject\\spring6\\spring6-002\\src\\main\\resources\\spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println("userBean = " + userBean);

    }

    @Test
    public void testFirstSpringCode() {
        // 获取Spring容器对象
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "beans.xml", "xml/beans.xml");

        // 根据bean的id从Spring容器中获取对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println("userBean = " + userBean);

        // Object userDaoBean = applicationContext.getBean("userDaoBean");
        UserDaoImplMySQL userDaoBean = applicationContext.getBean("userDaoBean", UserDaoImplMySQL.class);
        System.out.println("userDaoBean = " + userDaoBean);
        userDaoBean.insert();

        Object vipBean = applicationContext.getBean("vipBean");
        System.out.println("vipBean = " + vipBean);

        Object userBean2 = applicationContext.getBean("userBean2");
        System.out.println("userBean2 = " + userBean2);

        // Object nowTime = applicationContext.getBean("nowTime"); // 当bean的id不存在，不会返回null，而是出现异常
        // Date nowTime = (Date) applicationContext.getBean("nowTime");
        Date nowTime = applicationContext.getBean("nowTime", Date.class); // 不想强转
        System.out.println("nowTime = " + nowTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String strNowTime = sdf.format(nowTime);
        System.out.println("strNowTime = " + strNowTime);
    }
}
