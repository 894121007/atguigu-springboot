package com.atguigu.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/10 16:23
 *
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {

	@Autowired
	private HelloProperties helloProperties;

	@Bean
	public HelloService helloService() {
		HelloService helloService = new HelloService();
		helloService.setHelloProperties(helloProperties);
		return helloService;
	}
}
