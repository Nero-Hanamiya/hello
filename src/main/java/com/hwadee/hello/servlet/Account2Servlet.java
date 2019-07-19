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
		try {
			accountDao.delete( Integer.valueOf(accountId) );
			//resp.sendRedirect("/accounts");
			
			resp.setStatus(302);
			resp.setHeader("Location", "/accounts");
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("/NewFile.html");
		}
		
	}
	
	

}
