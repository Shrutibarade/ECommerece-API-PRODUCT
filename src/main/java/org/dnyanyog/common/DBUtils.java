package org.dnyanyog.common;

import java.sql.*;

public class DBUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/product_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "shruti9160";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static ResultSet executeSelectQuery(String query) throws SQLException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        return stmt.executeQuery(query);  
    }

    public static void executeDMLQuery(String query) throws SQLException {
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
}
