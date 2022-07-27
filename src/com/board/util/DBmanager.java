package com.board.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBmanager {

	public static Connection getConnection() {

		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			
			DataSource ds = (DataSource) envContext.lookup("jdbc/OracleDB");
			
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//Read 후 리소스 해제
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//CUD  후 리소스 해제
	public static void close(Connection conn, Statement stmt) {
		try {
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
