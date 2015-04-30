package com.uabc.dowa.jdbc.connection;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

public class SmartConnection {

    private static final String userName = "root";
    private static final String password = "rootlocal";
    private static final String serverName = "localhost";
    private static final String portNumber = "9090";
    private static final String dbName = "Students";
    private static final String dbms = "mysql";

    public static Connection getConnection() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", SmartConnection.userName);
        connectionProps.put("password", SmartConnection.password);

        Connection conn = DriverManager.getConnection(
                    "jdbc:" + SmartConnection.dbms + "://" +
                            SmartConnection.serverName +
                            "/" + SmartConnection.dbName,
                    connectionProps);

        System.out.println("Connected to database");

        return conn;
    }
}
