package com.hwadee.hello.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwadee.hello.domain.Account;
import com.hwadee.hello.utils.JdbcUtils;

public class AccountDao {
	
	private QueryRunner query = new QueryRunner(JdbcUtils.getDataSource());
	
	
	public Account findById(int id) {
		String sql = "SELECT ACCOUNT_ID ACCOUNTID, EMAIL, PASSWORD, NICK_NAME NICKNAME, PIC FROM ACCOUNT WHERE ACCOUNT_ID = ?";
		try {
			return query.query(sql, new BeanHandler<Account>(Account.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}
	
	public List<Account> findAll(){
		String sql = "SELECT ACCOUNT_ID ACCOUNTID, EMAIL, PASSWORD, NICK_NAME NICKNAME, PIC FROM ACCOUNT";
		
		try {
			return query.query(sql, new BeanListHandler<Account>(Account.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException( e );
		}
		
		
	}
	

}
