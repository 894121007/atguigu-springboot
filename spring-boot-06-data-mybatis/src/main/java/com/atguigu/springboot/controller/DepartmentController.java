package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/9 11:27
 *
 */
@RestController
public class DepartmentController {

	@Autowired
	DepartmentMapper departmentMapper;

	@GetMapping("/dept/{id}")
	public Department getDepartment(@PathVariable Integer id) {
		Department department = departmentMapper.getDepartment(id);
		return department;
	}

	@GetMapping("/dept")
	public Department insertDepartment(@RequestParam("departmentName") String departmentName) {
		Department department = new Department();
		department.setDepartmentName(departmentName);
		departmentMapper.insertDepartment(department);
		return department;
	}
}
