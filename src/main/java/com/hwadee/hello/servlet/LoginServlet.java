package com.hwadee.hello.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwadee.hello.dao.AccountDao;
import com.hwadee.hello.domain.Account;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Account account = accountDao.findByEmail(email);
		if( null != account && account.getPassword().equals(password) ) {
			HttpSession session = req.getSession();
			session.setAttribute("account", account);
			
			resp.sendRedirect("/u/accounts");
		} else {
			resp.sendRedirect("/login.html");
		}
	}
	
	

}
