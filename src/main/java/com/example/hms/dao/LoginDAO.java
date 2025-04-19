package com.example.hms.dao;

import com.example.hms.dto.LoginDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class LoginDAO {
    private final Connection connection;

    public LoginDAO(Connection connection) {
        this.connection = connection;

    }

    public boolean saveUser(LoginDTO user) {
        String sql1 = "INSERT INTO student_details(name ,password , role) VALUES (?,?,?)";

        try{
            PreparedStatement statement=connection.prepareStatement(sql1);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPasswoord());
            statement.setString(3,user.getRole());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;




        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

}

