package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/9 11:18
 *
 */
//@Mapper //使用Mapper注解，表明这是一个操作数据库的mapper
public interface DepartmentMapper {

	@Select("select * from department where id = #{id}")
	Department getDepartment(Integer id);

	@Options(useGeneratedKeys=true,keyProperty="id")
	@Insert("insert into department(departmentName) values(#{departmentName})")
	int insertDepartment(Department department);

	@Delete("delete from department where id = #{id}")
	int deleteDepratment(Integer id);

	@Update("update department set department = #{department} where id = #{id}")
	int updateDepartment(Department department);
}
