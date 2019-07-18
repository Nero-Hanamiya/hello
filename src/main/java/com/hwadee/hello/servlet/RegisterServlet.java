package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.AccountDao;
import com.hwadee.hello.domain.Account;

public class RegisterServlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String nickName = req.getParameter("nickName");
		
		Account account = new Account(email, password, nickName);
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
			long accountId =  accountDao.insert(account);
			
			out.println( "<h1>注册成功,您的id是:"+ accountId +"</h1>" );
			out.println("<a href=\"/accounts\">转至列表页面</a>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println( "<h1 style=\"color:red\">注册失败</h1>" );
			out.println("<a href=\"/register.html\">转至注册页面</a>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
	

}
