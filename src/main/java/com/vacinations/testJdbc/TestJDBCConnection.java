package com.vacinations.testJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBCConnection {

	public TestJDBCConnection() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String connectionUrl="jdbc:mysql://127.0.0.1:3306/patients_vacinations?useSSL=false&serverTimezone=UTC";
			try {
				Connection connection = DriverManager.getConnection(connectionUrl, "patients","patients");
				System.out.println("Connection is good");
			}
			catch(SQLException sql)
			{
				sql.printStackTrace();
			}
	}

}
