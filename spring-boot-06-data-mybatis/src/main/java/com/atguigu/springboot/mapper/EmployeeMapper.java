package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;

/**
 * @author zhanglong
 * @description:
 * @date 2019/7/9 14:05
 *
 */
//@Mapper和@MapperScan两个注解，必须使用一个。将接口装配到 Bean容器当中
public interface EmployeeMapper {

	Employee getEmployee(Integer id);

	int insertEmployee(Employee employee);
}
