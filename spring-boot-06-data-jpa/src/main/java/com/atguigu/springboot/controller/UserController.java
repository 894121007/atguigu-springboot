package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.User;
import com.atguigu.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author zhanglong
 * @date 2019/7/9 16:31
 *
 */
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/user/{id}")
	public Optional getUser(@PathVariable Integer id) {
		Optional<User> byId = userRepository.findById(id);
		return byId;
	}
}
