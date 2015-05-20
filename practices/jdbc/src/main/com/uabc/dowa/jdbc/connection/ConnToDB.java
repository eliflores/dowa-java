package com.uabc.dowa.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnToDB {
    private static String dbURL = "jdbc:h2:~/test";
    private static String user = "sa";
    private static String pass = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL, user, pass);
    }
}
