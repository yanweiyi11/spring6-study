package com.spring.test;

import com.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
    @Test
    public void t11() {
        // 如果想写JDBC代码，可以使用callbac回调函数
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 准备SQL语句
        String sql = "select * from t_user where id = ?";
        // 注册回调函数，当execute方法执行的时候，回调函数中的doInPreparedStatement方法会被调用
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1, 2);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String realName = rs.getString("real_name");
                    int age = rs.getInt("age");
                    user = new User(id, realName, age);
                }
                return user;
            }
        });
        System.out.println(user);
    }
    @Test
    public void t10() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        // 准备数据
        Object[] obj1 = {21};
        Object[] obj2 = {22};
        Object[] obj3 = {23};
        Object[] obj4 = {24};

        // 添加到list
        List<Object[]> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        // 执行sql
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }
    @Test
    public void t9() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ?, age = ? where id = ?";
        // 准备数据
        Object[] obj1 = {"EEE", 1000, 26};
        Object[] obj2 = {"FFF", 2000, 27};
        Object[] obj3 = {"GGG", 3000, 28};
        Object[] obj4= {"HHH", 4000, 29};

        // 添加到list
        List<Object[]> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        // 执行SQL
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }
    @Test
    public void t8() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user(real_name, age) values(?,?)";

        // 准备数据
        Object[] obj1 = {"AAA", 300};
        Object[] obj2 = {"BBB", 400};
        Object[] obj3 = {"CCC", 500};
        Object[] obj4 = {"DDD", 600};

        // 添加到list
        List<Object[]> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);

        // 执行SQL
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }
    @Test
    public void t7() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(*) from t_user"; // return int
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println(count);
    }

    @Test
    public void t6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    @Test
    public void t5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    public void t4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        int count = jdbcTemplate.update(sql, 21);
        System.out.println(count);
    }

    @Test
    public void t3() {
        // 根据id修改某一条记录
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ?, age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "阿giao", 500, 21);
        System.out.println(count);
    }

    @Test
    public void t2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // insert语句
        String sql = "insert into t_user(real_name,age) values(?,?)";
        // 在jdbcTemplate当中，只要使用了增删改语句，都是调用update方法
        int count = jdbcTemplate.update(sql, "张三", 100);
        System.out.println(count);
    }

    @Test
    public void t1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
