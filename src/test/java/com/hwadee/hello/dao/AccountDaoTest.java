package com.hwadee.hello.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
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
	@Test
	public void testInsert() throws SQLException {
		Account account = new Account();
		account.setEmail("wangwu1@163.com");
		account.setPassword("123456");
		account.setNickName("wangwu");
		
		long accountId = accountDao.insert(account);
		
		System.out.println( accountId );
	}

}
