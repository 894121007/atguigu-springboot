package com.atguigu.starter.controller;

import com.atguigu.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/10 16:43
 *
 */
@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping("/hello")
	public String hello() {
		return helloService.sayHello();
	}
}
