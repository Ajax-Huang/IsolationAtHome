package com.ajax.plus.mapper;

import com.ajax.plus.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ajax Huang
 * @create 2021-11-01-10:32
 */
public interface DeptMapper extends BaseMapper<Dept> {

    @Select("Select * from cust where name = #{name}")
    List<Dept> selectByName(@Param("name") String name);
}
