package com.ajax.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author Ajax Huang
 * @create 2021-11-01-9:25
 */
public class Cust{

    //设置主键，值为自增长的形式
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private int age;

    public Cust(){};
    public Cust(String name,String email,int age) {
        this.name=name;
        this.email=email;
        this.age=age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cust{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
