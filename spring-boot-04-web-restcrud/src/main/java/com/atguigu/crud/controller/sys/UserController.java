package com.atguigu.crud.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/18 14:56
 *
 */
@Controller
@RequestMapping("/sysUser/")
public class UserController {

	@PostMapping("login")
	public String Login(@RequestParam(required = true) String username,
						@RequestParam(required = true) String password,
						Map<String,Object> map,
						HttpSession session) {
		if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
			session.setAttribute("loginUser",username);
			//为了防止表单重复提交，可以重定向到主页
			return "redirect:/main.html";
		}
		else {
			map.put("msg","用户名密码错误");

			//返回值是要被视图解析器解析的
			return "login";
		}

	}
}
