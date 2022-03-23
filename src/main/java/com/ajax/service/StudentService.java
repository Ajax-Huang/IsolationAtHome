package com.ajax.service;

import com.ajax.model.Student;

/**
 * @author Ajax Huang
 * @create 2021-10-23-11:49
 */
public interface StudentService {

    Student queryStudentById(Integer id);

    int modifyStudentById(Student student);

    Long queryAllStudentCount();
}
