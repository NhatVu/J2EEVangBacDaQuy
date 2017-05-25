package com.vangbacdaquy.dbconnection;

import com.mongodb.MongoClient;
import com.vangbacdaquy.constant.Configuration;

public class MongoDBConnectionService {
	static MongoClient connection = null;

	public static MongoClient getConnection()
	{  
	    String ip = Configuration.IP_SERVER_MONGO;
	    int port = Integer.parseInt(Configuration.PORT_SERVER_MONGO);
		try {
			if(connection == null)
//				connection = new MongoClient("10.3.24.101",27017);
			    connection = new MongoClient(ip,port);
		} catch (Exception e) {
			System.out.println("Can't connect to MongoDB");
		}
		return connection;
	}
}