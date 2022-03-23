package com.ajax.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Ajax Huang
 * @create 2021-10-23-15:47
 */
@RestController
public class MVCController {

    @GetMapping(value = "/query")
    public String get(){
        return "@GetMapping注解，通常查询时使用";
    }

    @PostMapping(value = "/add")
    public String add(){
        return "@PostMapping注解，通常新增时使用";
    }

    @PutMapping(value = "/put_modify")
    public String modify(){
        return "@PutingMapping注解，通常更新数据时使用";
    }

    @DeleteMapping(value = "/remove")
    public String remove(){
        return "@DeleteMapping注解，通常删除数据时使用";
    }

}
