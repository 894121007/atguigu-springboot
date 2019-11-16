package com.atguigu.springboot.repository;

import com.atguigu.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhanglong
 * @date 2019/7/9 16:28
 *
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
