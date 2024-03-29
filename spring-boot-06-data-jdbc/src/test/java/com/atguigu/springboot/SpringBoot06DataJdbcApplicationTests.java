package com.atguigu.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06DataJdbcApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() {
		System.out.println("dependency : " + dataSource);
		System.out.println("dependency : " + dataSource.getClass());
	}

}
