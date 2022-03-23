package com.ajax.controller;

import com.ajax.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ajax Huang
 * @create 2021-10-23-16:55
 */
@RestController
public class RedisController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "springboot/allStudentCount")
    public Object allStudentCount(HttpServletRequest request) {

        Long allStudentCount = studentService.queryAllStudentCount();

        return "学生总人数："+allStudentCount;
    }
}
