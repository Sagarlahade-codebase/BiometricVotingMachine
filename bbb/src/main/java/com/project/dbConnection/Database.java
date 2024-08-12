package com.project.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Database {

	public static String DriverString="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/evoting";
	public static String username="root";
	public static String password="root";
	public static Connection conn;
	
	public static Connection getConnection()
	{
		try{
		Class.forName(DriverString);
		conn=DriverManager.getConnection(url, username, password);
		System.out.println("connection established");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return conn;
	}
	
	
	
	
	
	public static void main(String[] args) {
		getConnection();
	}
	
}
