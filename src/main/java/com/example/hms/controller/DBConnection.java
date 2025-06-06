package com.example.hms.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

    private static Connection connection;

    // ------------------Initialize and create DB/tables----------------------

    public static void initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "Yomal-2003");

            if (connection != null) {
                Statement statement = connection.createStatement();

               String sql1 = "CREATE DATABASE IF NOT EXISTS CRS";
                String sql2 = "USE CRS";
                String student_details = "CREATE TABLE IF NOT EXISTS student_details (" +
                        "student_id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "name VARCHAR(50), " +
                        "password VARCHAR(255));";

                String course_details = "CREATE TABLE IF NOT EXISTS course_details(course_id VARCHAR(50) PRIMARY KEY , course_name VARCHAR(50) ,course_credits INT ,course_hours INT,max_participants INT)";
                String student_acedemicTable= "CREATE TABLE IF NOT EXISTS student_academicDetails (\n" +
                        "    student_id INT,\n" +
                        "    course_id VARCHAR(50),\n" +
                        "    PRIMARY KEY (student_id, course_id),\n" +
                        "    FOREIGN KEY (student_id) REFERENCES student_details(student_id),\n" +
                        "    FOREIGN KEY (course_id) REFERENCES course_details(course_id)\n" +
                        ");";

                String admin_details="CREATE TABLE IF NOT EXISTS admin_details(admin_id INT AUTO_INCREMENT PRIMARY KEY , name VARCHAR(50),password VARCHAR(50))";
                String staff_details="CREATE TABLE IF NOT EXISTS staff_details(staff_id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50),password VARCHAR(50))";


                statement.executeUpdate(sql1);
                statement.executeUpdate(sql2);
                statement.executeUpdate(student_details);
                statement.executeUpdate(course_details);
                statement.executeUpdate(student_acedemicTable);
                statement.executeUpdate(admin_details);
                statement.executeUpdate(staff_details);

                //statement.executeUpdate(tempData1);


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

