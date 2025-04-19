package com.example.hms.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    private static Connection connection;

    // Initialize and create DB/tables
    public static void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "Yomal-2003");

            if (connection != null) {
                Statement statement = connection.createStatement();

                String sql1 = "CREATE DATABASE IF NOT EXISTS CRS";
                String sql2 = "USE CRS";
                String sql3 = "CREATE TABLE IF NOT EXISTS student_details (" +
                        "student_id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(50), " +
                        "password VARCHAR(255), " +  // for hashing
                        "role VARCHAR(50))";

                statement.executeUpdate(sql1);
                statement.executeUpdate(sql2);
                statement.executeUpdate(sql3);

                statement.close();
                System.out.println("Database and table setup complete.");
            } else {
                System.out.println("Failed to connect to MySQL.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/CRS", "root", "Yomal-2003");
        }
        return connection;
    }

    public static void main(String args[]){
        initialize();
    }
}

