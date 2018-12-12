package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.type.TrueFalseType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/1/17.
 */
@ApiModel(description = "用户请求表单")
@Entity
public class User {
    @Id
    @GeneratedValue
    @ApiModelProperty(value = "id", example = "7",position = 1, required = false )
    private Integer id;

    
    @Column(nullable = false)
    @ApiModelProperty(value = "姓名", example = "张三",position = 2, required = true )
    private String name;

    
    @Column(nullable = false)
    @ApiModelProperty(value = "年龄", example = "28",position = 3, required = true)
    private String age;

    public User() {
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
