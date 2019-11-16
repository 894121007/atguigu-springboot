package com.atguigu.crud.controller;

import com.atguigu.crud.dao.DepartmentDao;
import com.atguigu.crud.dao.EmployeeDao;
import com.atguigu.crud.entities.Department;
import com.atguigu.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/20 10:50
 *
 */
@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	/**
	 * @description: 查询列表
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/24 18:14
	 */
	@GetMapping("emps")
	public String list(Model model) {
		Collection<Employee> employees = employeeDao.getAll();
		//封装model对象返回给前端
		model.addAttribute("emps",employees);
		//ThymeleafAutoConfiguration会根据defaultTemplateResolver配置 加上前缀，classpath:/templates/
		//和后缀 .html就能直接访问到页面了
		return "emp/list";
	}

	/**
	 * @description: 到达新增页面
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/24 18:15
	 */
	@GetMapping("emp")
	public String toAddPage(Model model) {
		//进入员工添加的列表，因为要选择部门，所以要把部门的列表返回，在页面进行显示
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts",departments);
		return "emp/add";
	}

	/**
	 * @description: 新增员工
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/24 18:15
	 */
	@PostMapping("emp")
	public String save(Employee employee) {
		employeeDao.save(employee);
		//这里要转发，或者重定向到/emps请求地址，如果返回值写"emp/list"这样是不行的
		//直接写成"/emps"会被thmeleaf解析，去寻找页面，而不是调用请求
//		return "forward:/emps";
		return "redirect:/emps";
	}

	/**
	 * @description: 来到修改页面，并且回显employee的属性
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @date 2019/6/25 12:33
	 */
	@GetMapping("emp/{id}")
	public String toEditPage(@PathVariable(value = "id") Integer id,
							 Model model) {
		Employee employee = employeeDao.get(id);
		Collection<Department> departments = departmentDao.getDepartments();
		//页面要显示所有的部门列表
		model.addAttribute("depts",departments);
		//页面也回显employee的信息
		model.addAttribute("emp",employee);
		return "emp/add";
	}

	/**
	 * 编辑员工
	 * @param employee
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @since 2019/6/25 22:07
	 */
	@PutMapping("emp")
	public String edit(Employee employee) {
		employeeDao.save(employee);

		//重定向到列表页面
		return "redirect:/emps";
	}

	/**
	 * 删除员工
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @since 2019/6/25 22:36 
	 */
	@DeleteMapping("emp/{id}")
	public String delete(@PathVariable(value = "id") Integer id) {
		employeeDao.delete(id);

		//重定向到列表页面
		return "redirect:/emps";
	}
}
