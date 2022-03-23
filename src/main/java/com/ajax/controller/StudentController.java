package com.ajax.controller;

import com.ajax.model.Student;
import com.ajax.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ajax Huang
 * @create 2021-10-23-11:45
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/springBoot/student")
    public @ResponseBody Object student(){

        Student student = studentService.queryStudentById(2);
        return student;
    }

    @RequestMapping(value = "springBoot/modify")
    public @ResponseBody Object modifyStudent(){

        int count = 0;

        Student student = new Student();
        student.setId(2);
        student.setAge(22);
        student.setName("Jack");
        count = studentService.modifyStudentById(student);

        return count;
    }
}
