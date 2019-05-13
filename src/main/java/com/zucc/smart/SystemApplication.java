package com.zucc.smart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan("com.zucc.smart.mapper")
public class SystemApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
