package com.ajax.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ajax Huang
 * @create 2021-11-01-9:07
 */
@SpringBootApplication(scanBasePackages = "com.ajax.*")
@MapperScan(value = "com.ajax.plus.mapper")
public class PlusPrimaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlusPrimaryApplication.class,args);
    }
}
