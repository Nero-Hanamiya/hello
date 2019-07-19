package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.AccountDao;
import com.hwadee.hello.domain.Account;

public class AccountServlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();
	
	
	

	@Override
	public void destroy() {
		
	}




	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		String test = config.getInitParameter("test");
		String test2 = config.getInitParameter("test2");
		
		///Integer.parseInt("1");
		
		System.out.println("test=" + test + "\ntest2=" + test2);
	}




	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Account> accounts = accountDao.findAll();
		System.out.println("AccountServlet===>doGet");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>            ");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Document</title>");
		out.println("</head>");
		out.println("<body>");
		
		Cookie [] cookies = req.getCookies();
		
		Cookie cookie = null;
		for(Cookie c : cookies) {
			if( c.getName().equals("sessionid") ) {
				cookie = c;
				break;
			}
		}
		if( null == cookie ) {
			cookie = new Cookie("sessionid", UUID.randomUUID().toString());
			cookie.setMaxAge( 60 * 60 * 24 );
			//cookie.setPath("");
			resp.addCookie(cookie);
		}
		
		
		
		Enumeration<String> names = req.getHeaderNames();
		out.println("<pre>");
		while( names.hasMoreElements() ) {
			String name = names.nextElement();
			out.print("<strong>");
			out.print( name );
			out.print("</strong>");
			out.print("<span>");
			out.print( req.getHeader( name ) );
			out.println("</span>");
		}
		out.println("</pre>");
		
		out.println("<table>");
		for( Account account : accounts ) {
			out.println("<tr>");
			out.print("<td>");
			out.print( account.getAccountId() );
			out.println("</td>");
			out.print("<td>");
			out.print( account.getEmail() );
			out.println("</td>");
			out.print("<td>");
			out.print( account.getPassword() );
			out.println("</td>");
			out.print("<td>");
			out.print( account.getNickName() );
			out.println("</td>");
			out.print("<td>");
			//<a href="/account?accountId=7">delete</a>
			out.print("<a href=\"/account?accountId=" + account.getAccountId() + "&sessionid=123\">delete</a>");
			out.println("</td>");
			out.print("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
	
	

}
