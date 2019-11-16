package com.atguigu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/5 15:01
 *
 */
@Configuration
public class DruidConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druid(){
		return new DruidDataSource();
	}

	//配置Druid的监控
	//1、配置一个管理后台的Servlet
	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet() {
		ServletRegistrationBean<StatViewServlet> servlet =
				new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
		servlet.addInitParameter("loginUsername","admin");
		servlet.addInitParameter("loginPassword","123456");
		servlet.addInitParameter("allow","");//默认就是允许所有的请求访问
		return servlet;
	}

	//2、配置一个web监控的filter
	@Bean
	public FilterRegistrationBean<WebStatFilter> webStatFilter() {
		FilterRegistrationBean<WebStatFilter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new WebStatFilter());

		filter.addInitParameter("exclusions","*.js,*.css,/druid/*");
		filter.addUrlPatterns("/*");
		return filter;
	}
}
