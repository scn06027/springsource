package com.study.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//여러개인 DAO 파일에서 중복되는 부분을 처리해준다

public class JdbcUtil {
	
	
public static Connection getConnection() {
		Connection con=null;
		
		try {
			
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			con=ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

public static void close(Connection con) {
	try {
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public static void close(PreparedStatement pstmt) {
	try {
		pstmt.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
}

public static void commit(Connection con) {
	try {
		con.commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void rollback(Connection con) {
	try {
		con.rollback();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
