package com.icerno;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//springBoot提供了一种以编码的方式初始化Web配置。通过继承SpringBootServletInitializer类
//Spring Boot应用能够使用嵌入的Spring上下文来注册配置，这个Spring上下文是在容器初始化的时候创建的。
public class StudentManagementApplication extends SpringBootServletInitializer{
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentManagementApplication.class);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
}
