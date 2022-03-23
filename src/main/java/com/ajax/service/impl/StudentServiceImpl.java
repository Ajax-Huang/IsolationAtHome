package com.ajax.service.impl;

import com.ajax.mapper.StudentMapper;
import com.ajax.model.Student;
import com.ajax.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author Ajax Huang
 * @create 2021-10-23-13:38
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectStudentById(id);
    }

    @Override
    @Transactional
    public int modifyStudentById(Student student) {
        int updateCount = studentMapper.updateByPrimaryKeySelective(student);

        System.out.println("result:"+updateCount);

//        int a = 10/0;

        return updateCount;
    }

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Long queryAllStudentCount() {
//        设置redisTemplate对象key的序列化方式
          redisTemplate.setKeySerializer(new StringRedisSerializer());

          //先从缓存中获取数据
        Long allStudentCount = (Long)redisTemplate.opsForValue().get("allStudentCount");

        if(null == allStudentCount){
            allStudentCount = studentMapper.selectAllStudentCount();

            redisTemplate.opsForValue().set("allStudentCount",allStudentCount,15, TimeUnit.SECONDS);
        }


        return allStudentCount;
    }
}
