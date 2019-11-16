package com.atguigu.springboot02config;

import com.atguigu.springboot02config.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Base64Utils;

import java.util.Arrays;

/**
 * 因为这里 RunWith 的是 SpringRunner，所以我们在这里可以像编写代码一样，注入spring的bean
 * @param
 * @return  
 * @throws
 * @author zhanglong
 * @date 2019/5/25 14:47 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	@Test
	public void testBase64() {
		String name = new String(
				Base64Utils.decodeFromString("bm9ybWFsOi8vaW1hZ2UtZmxvdy1mYWNlLzIwMTkwNTE1L2kwbDl4c1BRTzR4Y2QyZVloMDE2a2c9PUAx"));
		System.out.println(name);
	}

}
