package com.hwadee.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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

		try {
			long accountId =  accountDao.insert(account);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/accounts");
			dispatcher.forward(req, resp);
			//resp.sendRedirect("/accounts?code=200");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("key", "fail");
			resp.sendRedirect("/view");
		}

	}
	
	

}
