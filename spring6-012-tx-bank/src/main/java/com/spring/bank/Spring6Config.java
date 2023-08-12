package com.spring.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration // 代替spring-config.xml配置文件，在类当中完成配置
@ComponentScan(basePackages = "com.spring.bank") // 组件扫描
@EnableTransactionManagement // 开启事务注解
public class Spring6Config {

    // spring框架看到这个@Bean注解后，会调用这个被标注的方法，这个方法的返回值是一个java对象，这个java对象会自动纳入IoC容器管理
    // 返回的对象就是spring容器当中的一个bean了
    @Bean(name = "dataSource")
    public DruidDataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring6");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) { // spring在调用这个方法的时候，会自动给我们传递过来一个dataSource对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean(name = "txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }
}
