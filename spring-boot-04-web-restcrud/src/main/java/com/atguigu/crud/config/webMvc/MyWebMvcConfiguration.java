package com.atguigu.crud.config.webMvc;

import com.atguigu.crud.config.webMvc.common.LoginHandlerInterceptor;
import com.atguigu.crud.config.webMvc.common.MyLocaleResolve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/4 11:37
 *
 */
@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//浏览器发送的/，跳转到/login.html
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");

		//这行的配置 等效于 写一个方法 @requestMapping("/login.html"),返回值是 "login"，上面的也类似
		registry.addViewController("/login.html").setViewName("login");


		//登陆之后的重定向
		registry.addViewController("/main.html").setViewName("home");
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolve();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerInterceptor())
				.addPathPatterns("/**") //过滤所有的路径层的所有请求，这里也可以写多个地址，为了简单就全部过滤
				.excludePathPatterns("/","/login","/login.html","/sysUser/login"); //需要排除不需要过滤的地址
	}
}
