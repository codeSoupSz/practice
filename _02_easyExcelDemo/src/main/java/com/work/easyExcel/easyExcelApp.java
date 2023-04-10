package com.work.easyExcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.work.easyExcel.mapper")
public class easyExcelApp {
    public static void main(String[] args) {
        SpringApplication.run(easyExcelApp.class,args);
    }
}
