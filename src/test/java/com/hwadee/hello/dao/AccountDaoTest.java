package com.hwadee.hello.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.hwadee.hello.domain.Account;

public class AccountDaoTest {
	
	private AccountDao accountDao = new AccountDao();

	@Test
	public void testFindById() {
		Account account = accountDao.findById(2);
		System.out.println( account );
	}
	@Test
	public void testFindAll() {
		
		List<Account> accounts = accountDao.findAll();
		
		System.out.println( accounts );
		
	}

}
