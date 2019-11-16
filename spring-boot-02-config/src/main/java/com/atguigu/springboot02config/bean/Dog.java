package com.atguigu.springboot02config.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/5/25 14:43
 *
 */
@Data
@Component
public class Dog {

	private String name;
	private String age;
}
