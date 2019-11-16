package com.atguigu.crud.config.server;

import com.atguigu.crud.config.server.common.MyFilter;
import com.atguigu.crud.config.server.common.MyListener;
import com.atguigu.crud.config.server.common.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Administrator
 * @description:
 * @date 2019/6/29 22:21
 *
 */
@Configuration
public class MyServerConfig {

	/*
	 *  注册Servlet
	 */
	@Bean
	public ServletRegistrationBean<MyServlet> servletServletRegistrationBean() {
		//拦截/myServlet请求到 我们指定的这个Servlet --》new MyServlet()
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
		servletRegistrationBean.setLoadOnStartup(2);
		return servletRegistrationBean;
	}

	/*
	 * 注册Filter
	 */
	@Bean
	public FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean() {
		FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
		myFilterFilterRegistrationBean.setFilter(new MyFilter());
		myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
		return myFilterFilterRegistrationBean;
	}

	/*
	 * 注册Listener
	 */
	@Bean
	public ServletListenerRegistrationBean myListenerServletListenerRegistrationBean() {
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
		return servletListenerRegistrationBean;
	}

}
