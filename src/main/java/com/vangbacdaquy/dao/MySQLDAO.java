package com.vangbacdaquy.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.vangbacdaquy.dbconnection.MySQLDBConnectionService;


public class MySQLDAO {
	private Connection dbConnection;

	public MySQLDAO() {
		try {
			dbConnection = MySQLDBConnectionService.getConnection();
		} catch (Exception e) {
			System.out.println("Can't connect to MySQL");
		}
	}

	public MySQLDAO(Connection connection) {
		dbConnection = connection;
	}
	
	public Connection getConnection() {
		return dbConnection;
	}
	
	public void closeConnection() throws SQLException {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
