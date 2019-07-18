package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.AccountDao;
import com.hwadee.hello.domain.Account;

public class AccountServlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Account> accounts = accountDao.findAll();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>            ");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Document</title>");
		out.println("</head>");
		out.println("<body>");
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
			out.print("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
	
	

}
