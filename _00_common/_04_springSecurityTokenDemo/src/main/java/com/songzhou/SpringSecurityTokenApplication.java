package com.songzhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.songzhou.mapper")
public class SpringSecurityTokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTokenApplication.class,args);
    }
}