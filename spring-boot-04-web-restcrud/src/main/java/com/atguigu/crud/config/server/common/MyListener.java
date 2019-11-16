package com.atguigu.crud.config.server.common;

import com.atguigu.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Administrator
 * @date 2019/6/30 11:21
 *
 */
@Configuration
public class MyListener implements ServletContextListener {

	@Autowired
	private EmployeeDao employeeDao;

	/*
	 * 启动监听
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(employeeDao);
		System.out.println("application...init...");
	}

	/*
	 * 销毁监听
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println(employeeDao);
		System.out.println("application...destroy...");
	}
}
