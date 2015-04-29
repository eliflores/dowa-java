package com.dowa.java.web.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Andres on 4/16/2015.
 */
public class ConnectionFactory {

    private static final String _dbURL = "jdbc:h2:~/test";
    private String _dbUser = "sa";
    private String _dbPwd = "1234";
    private static ConnectionFactory instance = new ConnectionFactory();

    private ConnectionFactory(){}

    private Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(_dbURL, _dbUser, _dbPwd);
        } catch (SQLException e) {
            System.err.println("SQL Exception " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.err.println("Runtime Exception " + e.getMessage());
        }
        return connection;
    }
    public static Connection getConnection(){
        return instance.createConnection();
    }
}
