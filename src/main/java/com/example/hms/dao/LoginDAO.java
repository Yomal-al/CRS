package com.example.hms.dao;

import com.example.hms.dto.LoginDTO;

import java.sql.*;


public class LoginDAO {
    private final Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;

    }

    public boolean saveUserStudent(LoginDTO user) {
        String sql1 = "INSERT INTO student_details(name ,password ) VALUES (?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql1);){

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean saveUserAdmin(LoginDTO user) {
        String sql1 = "INSERT INTO admin_details(name ,password ) VALUES (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql1);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;


        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean saveUserStaff(LoginDTO user) {
        String sql1 = "INSERT INTO staff_details(name ,password ) VALUES (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql1);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;


        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }


    public LoginDTO getUser(String setName, String setPassword, String setRole) {


            String sql = "";

            switch (setRole) {
                case "Student":
                    sql = "SELECT * FROM student_details WHERE name=? AND password=?";
                    break;
                case "Admin":
                    sql = "SELECT * FROM admin_details WHERE name=? AND password=?";
                    break;
                case "Administrative Staff":
                    sql = "SELECT * FROM staff_details WHERE name=? AND password=?";
                    break;
                default:
                    return null;
            }

            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, setName);
                statement.setString(2, setPassword);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    return new LoginDTO(name, password);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }



        return null;
    }

}

