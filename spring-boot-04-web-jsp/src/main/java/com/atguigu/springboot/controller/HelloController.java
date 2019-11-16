package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/3 11:19
 *
 */
@Controller
public class HelloController {

	@GetMapping("/abc")
	public String hello(Model model) {
		model.addAttribute("hello","hello world");
		return "success";
	}
}
