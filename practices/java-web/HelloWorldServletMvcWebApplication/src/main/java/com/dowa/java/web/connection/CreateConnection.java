package com.dowa.java.web.connection;

/**
 * Created by Tonoid on 5/20/2015.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CreateConnection {

    private static final String dbURL = "jdbc:h2:~/test";
    private String dbUser = "sa"; //user of the h2 data base.
    private String dbPwd = ""; //password of h2.
    private static CreateConnection instance = new CreateConnection();

    //constructor
    private CreateConnection() {}

    private Connection createConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPwd);
        } catch (SQLException e) {

            System.err.println("SQL Exception didnt reach a connection  " + e.getMessage());
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
