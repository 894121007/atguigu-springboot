package com.atguigu.springboot.bean;

import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer departmentId;
}
