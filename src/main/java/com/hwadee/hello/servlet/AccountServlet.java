package com.hwadee.hello.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwadee.hello.dao.AccountDao;
import com.hwadee.hello.domain.Account;

public class AccountServlet extends HttpServlet {
	
	private AccountDao accountDao = new AccountDao();

	/**
	 * 获取
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Account account = accountDao.findById(Integer.parseInt(id));
		req.setAttribute("account", account);
		
		req.getRequestDispatcher("/WEB-INF/views/account/update.jsp").forward(req,resp);
		/*
		 * List<Account> accounts = accountDao.findAll();
		 * 
		 * req.setAttribute("accounts", accounts);
		 * 
		 * req.getRequestDispatcher("/WEB-INF/views/account/list.jsp").forward(req,
		 * resp);
		 */
	}

	/**
	 * 删除
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		try {
			int rows = accountDao.delete(Integer.parseInt(id));
			
			resp.sendRedirect("/u/accounts");
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountId = req.getParameter("accountId");
		String email = req.getParameter("email");
		String nickName = req.getParameter("nickName");
		try {
			Account account = new Account(email, null, nickName);
			account.setAccountId(Integer.parseInt(accountId));
			int rows = accountDao.update(account);
			
			resp.sendRedirect("/u/accounts");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
