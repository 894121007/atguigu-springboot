package com.atguigu.springboot02config.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/5/25 14:27
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
	private String lastName;
	private Integer age;
	private Boolean boss;
	private Date birth;
	private Map<String,Object> maps;
	private List<Object> lists;
	private Dog dog;
	private String test;
}
