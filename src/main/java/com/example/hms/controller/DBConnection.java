package com.example.hms.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL="jdbc:mysql://localhost:3306/CRS";
    private static final String USER="root";
    private static final String PASSWORD="Yomal-2003";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
