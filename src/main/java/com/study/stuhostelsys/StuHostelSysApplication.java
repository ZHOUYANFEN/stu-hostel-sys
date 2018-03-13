package com.study.stuhostelsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目启动类
 */
//exclude = {DataSourceAutoConfiguration.class}
@SpringBootApplication()
@ComponentScan("com.study.stuhostelsys")
public class StuHostelSysApplication{

	public static void main(String[] args) {

		SpringApplication.run(StuHostelSysApplication.class, args);
	}
}



