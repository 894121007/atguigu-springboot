package com.atguigu.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author zhanglong
 * @description:
 * @date 2019/7/10 13:49
 *
 */
public class MyApplicationListener implements SpringApplicationRunListener {

	public MyApplicationListener(SpringApplication application, String[] args) {

	}

	@Override
	public void starting() {
		System.out.println("MyApplicationListener...starting");
	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		System.out.println("MyApplicationListener...environmentPrepared");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
		System.out.println("MyApplicationListener...contextPrepared");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		System.out.println("MyApplicationListener...contextLoaded");
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		System.out.println("MyApplicationListener...started");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {
		System.out.println("MyApplicationListener...running");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		System.out.println("MyApplicationListener...failed");
	}
}
