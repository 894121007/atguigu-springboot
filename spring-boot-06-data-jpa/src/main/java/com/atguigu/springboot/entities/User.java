package com.atguigu.springboot.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/9 16:23
 *
 */
@Data
//使用JPA注解配置映射关系
@Entity  //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "T_USER")  //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
public class User {

	@Id //这是一个主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
	private Integer id;
	@Column(name = "LAST_NAME",length = 50) //这是和数据表对应的一个列
	private String lastName;
	@Column //省略默认列名就是属性名
	private Integer gender;
}
