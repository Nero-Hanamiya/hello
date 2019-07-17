package com.hwadee.hello.utils;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class JdbcUtils {
	
	private static ComboPooledDataSource dataSource;
	
	static {
		dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("123654");
		//jdbc:postgresql://localhost:5432/test
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/database");
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}

}
