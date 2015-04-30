package com.dowa.java.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SmartConnection {

    private static final String userName = "root";
    private static final String password = "rootlocal";
    private static final String serverName = "~";
    private static final String portNumber = "9090";
    private static final String dbName = "test";
    private static final String dbms = "h2";

    public static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(
                    "jdbc:" + SmartConnection.dbms + ":" +
                            SmartConnection.serverName +
                            "/" + SmartConnection.dbName,
                    SmartConnection.userName, SmartConnection.password);

        System.out.println("Connected to database");

        return conn;
    }
}
