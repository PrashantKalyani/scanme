package com.desapex.spacemanager.resource.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Employee_DBUtil {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        } else {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://desapexserver.mysql.database.azure.com:3306/desapexdb?useSSL=true";
            String user = "Desapex";
            String password = "scanme@123";

            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }
}
