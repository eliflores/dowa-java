package com.uabc.dowa.jdbc.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by nexuz 05/31/15
 */
public class Connection {

    private String _dbURL = "jdbc:h2:~/test";
    private String _dbUser = "root";
    private String _dbPwd = "Dirge.1";
    private static ConnectionFactory instance = new ConnectionFactory();

    private ConnectionFactory(){}

    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(_dbURL, _dbUser, _dbPwd);
        } catch (SQLException e) {
            System.err.println("SQL Exception " + e.getMessage());
        }
        return connection;
    }
    public static Connection getConnection(){
        return instance.createConnection();
    }
}