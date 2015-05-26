package com.uabc.dowa.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




//we did this because we want to keep a MVC style.
public class ConnectionFactory {

    private String dbURL = "jdbc:h2:~/test";
    private String dbUser = "sa";
    private String dbPwd = "1234";
    private static ConnectionFactory instance = new ConnectionFactory();

    private ConnectionFactory(){}

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPwd);
        } catch (SQLException e) {
            System.err.println("SQL Exception " + e.getMessage());
        }
        return connection;
    }
    public static Connection getConnection(){
        return instance.createConnection();
    }
}