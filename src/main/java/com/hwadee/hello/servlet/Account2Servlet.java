package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.AccountDao;
import com.hwadee.hello.domain.Account;

@WebServlet("/u/accounts")
public class Account2Servlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  List<Account> accounts = accountDao.findAll();
		  
		  req.setAttribute("accounts", accounts);
		  
		  req.getRequestDispatcher("/WEB-INF/views/account/list.jsp").forward(req,
		  resp);
		 
		
	}
	
	

}
