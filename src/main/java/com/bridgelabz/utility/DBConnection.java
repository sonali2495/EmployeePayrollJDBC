package com.bridgelabz.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection connection;

	public static Connection createConnection() {
		try {
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establish connection
			String url = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
			String user = "root";
			String password = "sonaligadge24@";
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
