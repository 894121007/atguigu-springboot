package com.atguigu.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/9 12:47
 *
 */
@MapperScan("com.atguigu.springboot.mapper")
@Configuration
public class MybatisConfig {

	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		return (configuration -> {configuration.setMapUnderscoreToCamelCase(true);});
	}
}
