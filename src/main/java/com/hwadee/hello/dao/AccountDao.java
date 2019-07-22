package com.hwadee.hello.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
	
	public Account findByEmail(String email) {
		String sql = "SELECT ACCOUNT_ID ACCOUNTID, EMAIL, PASSWORD, NICK_NAME NICKNAME, PIC FROM ACCOUNT WHERE EMAIL = ?";
		try {
			return query.query(sql, new BeanHandler<Account>(Account.class), email);
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
	
	public long insert( Account account ) throws SQLException {
		String sql = "INSERT INTO ACCOUNT(EMAIL, PASSWORD, NICK_NAME) VALUES(?,?,?)";
		
		try {
			return query.insert(sql, new ScalarHandler<Long>(1), account.getEmail(), account.getPassword(), account.getNickName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public int delete( int accountId ) throws SQLException {
		String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
		try {
			return query.execute(sql, accountId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public int update( Account account ) throws SQLException {
		String sql = "UPDATE ACCOUNT SET EMAIL = ?, NICK_NAME = ? WHERE ACCOUNT_ID = ?";
		try {
			return query.update(sql, account.getEmail(), account.getNickName(), account.getAccountId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	

}
