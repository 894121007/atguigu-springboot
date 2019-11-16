package com.atguigu.crud.config.server.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @date 2019/6/29 22:23
 *
 */
public class MyServlet extends HttpServlet {

	//处理get请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello MyServlet");
		resp.getWriter().write("hello MyServlet");
	}
}
