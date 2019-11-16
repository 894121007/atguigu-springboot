package com.atguigu.crud.config.server.common;

import javax.servlet.*;  //注意Filter也是javax.servlet下的
import java.io.IOException;

/**
 *
 */
public class MyFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter process....");
		//注意，拦截执行完成之后，注意放行
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}
