package com.atguigu.crud.config.webMvc.common;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/6/19 9:53
 *
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object loginUser = request.getSession().getAttribute("loginUser");
		if(loginUser == null) {  //如果session中没有这个值，就拦截
			request.setAttribute("msg","没有权限访问，请登录后访问");  //添加错误消息 -- 这个不是最重要的，下面才是最重要的
			request.getRequestDispatcher("/login")  //获取请求的Dispatcher，“/” 请求，因为我们配置了视图映射，这个请求会被映射到登陆页
					.forward(request,response); //然后转发过去
			return false;
		} else {
			return true;     //否则就不拦截
		}
	}
}