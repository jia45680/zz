package com.lan.zz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lan.zz.dao")
@EnableTransactionManagement
@EnableAsync
public class ZzApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzApplication.class, args);
    }

}
