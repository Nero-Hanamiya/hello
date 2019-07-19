package com.hwadee.hello.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String test = filterConfig.getInitParameter("test");
		System.out.println( test );
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		System.out.println( "URI=" + req.getRequestURI() );
		
		System.out.println("doFilter===>before");
		
		
		chain.doFilter(req, response);
		//response.setCharacterEncoding("UTF-8");
		System.out.println("doFilter===>after");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
