package com.vangbacdaquy.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class SuperDAO {
	protected CallableStatement call = null;
	protected Connection connection = null;
    
    public SuperDAO(){
    	
    }

	public CallableStatement getCall() {
		return call;
	}

	public void setCall(CallableStatement call) {
		this.call = call;
	}

	public Connection getConnection() {
		try {
			connection = DataSource.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}    
}
