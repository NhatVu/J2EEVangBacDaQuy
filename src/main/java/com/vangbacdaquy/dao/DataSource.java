package com.vangbacdaquy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.vangbacdaquy.constant.Configuration;

//dung connecton poolling
public class DataSource {

    
    private static DataSource dataSource = null;

    public static DataSource getInstance() throws SQLException {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    public Connection getConnection() {
        Connection connect = null;
        if (connect == null) {
            loadJDBCDriver();
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
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }
    
    protected static void loadJDBCDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
