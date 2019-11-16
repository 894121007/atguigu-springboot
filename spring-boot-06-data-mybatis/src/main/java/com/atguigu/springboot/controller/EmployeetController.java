package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import com.atguigu.springboot.mapper.EmployeeMapper;
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
public class EmployeetController {

	@Autowired
	EmployeeMapper employeeMapper;

	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		Employee employee = employeeMapper.getEmployee(id);
		return employee;
	}

	@GetMapping("/emp")
	public Employee insertEmployee(@RequestParam String lastName,
								   @RequestParam Integer gender,
								   @RequestParam String email,
								   @RequestParam Integer departmentId) {
		Employee employee = new Employee();
		employee.setLastName(lastName);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setDepartmentId(departmentId);
		employeeMapper.insertEmployee(employee);
		return employee;
	}
}
