package com.hwadee.hello.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwadee.hello.domain.Account;

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
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//req.getRequestURI()
		
		HttpSession session = req.getSession();
		Account account = (Account)session.getAttribute("account");
		if( null != account ) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect("/login.html");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
