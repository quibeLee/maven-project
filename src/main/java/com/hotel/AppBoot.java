package com.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot启动入口
 * 
 * @author liheng
 *
 */
@EnableAutoConfiguration // 自动注入bean
@ComponentScan(basePackages = { "com.hotel" }) // 扫描包注解实现自动配置
@MapperScan("com.hotel.dao") // 扫描dao进行mapper映射
public class AppBoot {
	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}
}
