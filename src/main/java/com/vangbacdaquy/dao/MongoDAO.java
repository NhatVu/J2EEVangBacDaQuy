package com.vangbacdaquy.dao;

import com.mongodb.MongoClient;
import com.vangbacdaquy.dbconnection.MongoDBConnectionService;

public class MongoDAO {
	private MongoClient mongoConnection;

	public MongoDAO() {
		try {
			mongoConnection = MongoDBConnectionService.getConnection();
		} catch (Exception e) {
			System.out.println("Can't connect to MongoDB");
		}
	}

	public MongoDAO(MongoClient connection) {
		mongoConnection = connection;
	}
	
	public MongoClient getConnection() {
		return mongoConnection;
	}
	
	public void closeConnection() {
		mongoConnection.close();
	}
}
