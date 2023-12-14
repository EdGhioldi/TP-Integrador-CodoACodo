package com.CodoACodoBackEnd.Servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConection  {
	
	static String driver="com.mysql.cj.jdbc.Driver";
	static String bDD="integrador_cac";
	
	public static Connection getConnection() throws ClassNotFoundException
	{
		Connection conexion=null;
		try {
			Class.forName(driver);
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bDD,"root","root");
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return conexion;
	}
	
	
}
