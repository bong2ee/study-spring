package kr.co.magic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnectionTest3 {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
		
		DataSource ds = (DataSource) ac.getBean(DataSource.class);
		
		//1.데이터베이스의 연결 얻음
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
		
	}

}
