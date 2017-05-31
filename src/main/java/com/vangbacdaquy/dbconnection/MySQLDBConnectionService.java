package com.vangbacdaquy.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.vangbacdaquy.constant.Configuration;

public class MySQLDBConnectionService {
	protected static void loadJDBCDriver() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception ex) {
			throw new Exception("SQL JDBC Driver is not found");
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection connect = null;
        if (connect == null) {
            loadJDBCDriver();
//            String url = "jdbc:mysql://" + "192.168.23.43"
//                    + ":" + "3306"
//                    + "/" + "EDSDB_MYSQL?useUnicode=true&characterEncoding=UTF-8"
//                    + "&user=" + "cuongnt"
//                    + "&password=" + "Oy3LagWaRok3TB9"
//                    + "&autoReconnect=true"
//                    + "&connectTimeout=300";
            
            String url = "jdbc:mysql://" + Configuration.IP_SERVER_MYSQL
                    + ":" + Configuration.PORT_SERVER_MYSQL
                    + "/" + Configuration.DB_NAME_MYSQL + "?useUnicode=true&characterEncoding=UTF-8"
                    + "&user=" + Configuration.USERNAME_MYSQL
                    + "&password=" + Configuration.PASSWORD_MYSQL
                    + "&autoReconnect=true"
                    + "&connectTimeout=300";

            try {
                connect = DriverManager.getConnection(url);
            } catch (java.sql.SQLException e) {
                throw new Exception("Can not access to Database Server ..." + url + e.getMessage());
            }
        }
        return connect;
		
	}
}
