package com.ajax.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author Ajax Huang
 * @create 2021-10-23-16:01
 */
@RestController
public class RESTfulController {
    @PostMapping(value = "springboot/student/{name}/{age}")
    public Object addStudent(@PathVariable("name") String name,
                             @PathVariable("age") Integer age) {

        HashMap<String, Object> retMap = new HashMap<String,Object>();

        retMap.put("name",name);
        retMap.put("age",age);

        return retMap;
    }

    @DeleteMapping(value = "/springboot/student/{id}")
    public Object removeStudent(@PathVariable("id") Integer id) {
        return "删除学生的ID为："+id;
    }

    @GetMapping(value = "springboot/student/{id}")
    public Object queryStudent(@PathVariable("id") Integer id) {
        return "查询学生的id为："+id;
    }
}
