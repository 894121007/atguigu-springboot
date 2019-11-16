package com.atguigu.springboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/10 13:53
 *
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyCommandLineRunner...run..." + args);
	}
}
