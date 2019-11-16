package com.atguigu.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/10 16:21
 *
 */
@ConfigurationProperties(prefix = "atguigu.hello")
public class HelloProperties {

	String prefix;
	String suffix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
