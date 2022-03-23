package com.ajax.mapper;

import com.ajax.model.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ajax Huang
 * @create 2021-10-23-13:33
 */
@Mapper
public interface StudentMapper {

    Student selectStudentById(int id);

    int updateByPrimaryKeySelective(Student student);

    Long selectAllStudentCount();
}
