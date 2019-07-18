package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.AccountDao;

public class Account2Servlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountId = req.getParameter("accountId");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>            ");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Document</title>");
		out.println("</head>");
		out.println("<body>");
		try {
			accountDao.delete( Integer.valueOf(accountId) );
			out.println( "<h1>success</h1>" );
			out.println("<a href=\"/accounts\">/accounts</a>");
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println( "<h1 style=\"color:red\">error</h1>" );
			out.println("<a href=\"/accounts\">/accounts</a>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
	

}
