package com.msy.block1112;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.msy.block1112.dao")
public class Block1112Application {

    public static void main(String[] args) {
        SpringApplication.run(Block1112Application.class, args);
    }

}
