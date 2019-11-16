package com.atguigu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/5/24 16:56
 *
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping("hello")
	public String hello() {
		return "Hello world";
	}
}
