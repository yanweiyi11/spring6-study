package cn.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类，代替spring框架的配置文件
 */
@Configuration
@ComponentScan({"cn.spring.dao", "cn.spring.service"})
public class Spring6Config {
}
