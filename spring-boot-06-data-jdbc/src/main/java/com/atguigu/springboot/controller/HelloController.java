package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/5 14:26
 *
 */
@RestController
public class HelloController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/hello/{id}")
	public List<Map<String, Object>> hello(@PathVariable(value = "id") Integer id) {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM T_USER");
		return list;
	}
}
