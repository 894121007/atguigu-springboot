package com.atguigu.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/10 13:44
 *
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("MyApplicationContextInitializer...initialize..." + applicationContext);

	}
}
