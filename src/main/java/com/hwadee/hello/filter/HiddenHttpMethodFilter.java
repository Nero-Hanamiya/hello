package com.hwadee.hello.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HiddenHttpMethodFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String method = req.getParameter("_method");
		if(null != method && "PUT,DELETE".contains( method.toUpperCase() ) ) {
			
			req = new MyHttpServletRequest(req, method.toUpperCase());
		}
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	

}
class MyHttpServletRequest extends HttpServletRequestWrapper {
	
	private final String method;
	
	public MyHttpServletRequest(HttpServletRequest request, String method) {
		super(request);
		this.method = method;
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return this.method;
	}
	
	
	
}