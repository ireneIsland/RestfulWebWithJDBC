package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {

	private static JdbcConnector jdbcConnector = null;
	private static Connection connection = null;

	public JdbcConnector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//String url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=GMT";
			String url = "jdbc:mysql://localhost:3306/javaspring?useTimezone=true&serverTimezone=GMT";
			connection = DriverManager.getConnection(url, "root", "admin");
			System.out.println(connection.isValid(0));

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		return connection;
	}

	public static JdbcConnector getInstance() {

		if (jdbcConnector == null) {
			jdbcConnector = new JdbcConnector();
		}
		return jdbcConnector;
	}

}
