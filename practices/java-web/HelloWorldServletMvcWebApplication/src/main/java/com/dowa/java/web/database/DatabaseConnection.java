package com.dowa.java.web.database;

import java.sql.*;

public final class DatabaseConnection {
    private static  String host = "jdbc:h2:~/test";
    private static  String uName = "sa";
    private static  String uPass = "dbpass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                host,
                uName,
                uPass);
    }

}
