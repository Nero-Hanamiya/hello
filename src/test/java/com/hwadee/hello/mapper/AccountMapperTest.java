package com.hwadee.hello.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hwadee.hello.domain.Account;

public class AccountMapperTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void before()  {
		String resource = "mybatis-config.xml";
		Reader inputStream;
		try {
			inputStream = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Test
	public void testFindById() {
		SqlSession session = sqlSessionFactory.openSession();
		AccountMapper accountMapper = session.getMapper(AccountMapper.class);
		
		Account account = accountMapper.findById(7);
		
		System.out.println( account );
	}

}
