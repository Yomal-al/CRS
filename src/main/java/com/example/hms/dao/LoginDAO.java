package com.example.hms.dao;

import com.example.hms.dto.LoginDTO;

import java.sql.*;


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
            statement.setString(2, user.getPassword());
            statement.setString(3,user.getRole());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;




        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public LoginDTO getUser(String setName ,String setPassword , String setRole  ){
        String sql="SELECT * FROM student_details WHERE name=? AND password=? AND role=?";

        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setString(1,setName);
            statement.setString(2,setPassword);
            statement.setString(3,setRole);

            ResultSet resultSet= statement.executeQuery();

            if(resultSet.next()){

                String srole=resultSet.getString("role");
                String sname=resultSet.getString("name");
                String spassword=resultSet.getString("password");

                return new LoginDTO(srole,sname,spassword);


            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}

