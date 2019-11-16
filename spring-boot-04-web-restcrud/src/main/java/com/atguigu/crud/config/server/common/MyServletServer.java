package com.atguigu.crud.config.server.common;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;

/**
 * 不在application.properties中也可以配置servlet容器的属性
 * 2019/7/2 14:11
 *
 */
//@Configuration  暂时不在这里配置，感觉比较麻烦
public class MyServletServer extends ServletWebServerFactoryCustomizer {

	public MyServletServer(ServerProperties serverProperties) {
		super(serverProperties);
	}

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		super.customize(factory);
		factory.setPort(8086);
	}
}
