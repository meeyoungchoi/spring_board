package com.spring.review2.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class DbConnectionTest {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring2?serverTimezone=Asia/Seoul";
	private String uid = "root";
	private String upw = "mysql";
	
	
	//DB ���� �׽�Ʈ
	@Test
	public void connectTest() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			
			conn  = DriverManager.getConnection(url, uid, upw);
			System.out.println("DBĿ�ؼ� ����");
			System.out.println("conn: " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
}
