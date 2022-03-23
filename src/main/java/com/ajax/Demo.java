package com.ajax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ajax Huang
 * @create 2021-10-18-16:38
 */
@SpringBootApplication
@RestController
@EnableTransactionManagement
//@MapperScan("com.ajax.mapper")
public class Demo {
    public static void main(String[] args) {
        SpringApplication.run(Demo.class,args);
    }

    @RequestMapping(value = "/springBoot/say")
    public String say(){
        System.out.println("keeps getting better");
        return "keeps getting better";
    }
}
