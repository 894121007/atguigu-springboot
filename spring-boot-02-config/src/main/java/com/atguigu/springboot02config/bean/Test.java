package com.atguigu.springboot02config.bean;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.JavaVersion;
/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/5/25 16:25
 *
 */
@Data
@ConfigurationProperties(prefix = "test")
public class Test {

	private String name;

	@ConditionalOnJava(range = ConditionalOnJava.Range.EQUAL_OR_NEWER,value = JavaVersion.EIGHT)
	public void test() {

	}
}
