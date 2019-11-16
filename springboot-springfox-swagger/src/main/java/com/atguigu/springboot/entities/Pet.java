package com.atguigu.springboot.entities;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/30 15:04
 *
 */
public class Pet {

	private String name;
	private Double weight;

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
