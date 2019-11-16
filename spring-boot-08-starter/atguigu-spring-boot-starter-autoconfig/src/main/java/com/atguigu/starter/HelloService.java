package com.atguigu.starter;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/10 16:21
 *
 */
public class HelloService {

	private HelloProperties helloProperties;

	public String sayHello() {
		return helloProperties.getPrefix() + "-hello-" + helloProperties.getSuffix();
	}

	public HelloProperties getHelloProperties() {
		return helloProperties;
	}

	public void setHelloProperties(HelloProperties helloProperties) {
		this.helloProperties = helloProperties;
	}
}
