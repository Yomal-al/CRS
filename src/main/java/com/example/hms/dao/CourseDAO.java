package com.example.hms.dao;

import com.example.hms.controller.DBConnection;
import com.example.hms.dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseDAO {

    public ObservableList<CourseDTO> comboName() {
        ObservableList<CourseDTO> comboName = FXCollections.observableArrayList();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet comboname=statement.executeQuery("SELECT course_name FROM course_details");


            while (comboname.next()){
                comboName.add(new CourseDTO(
                        comboname.getString("course_name")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return comboName;
    }


    public ObservableList<CourseDTO> insertTableView() {
        ObservableList<CourseDTO> list= FXCollections.observableArrayList();


        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM course_details");



            while (resultSet.next()) {
                list.add(new CourseDTO(
                        resultSet.getString("course_id"),
                        resultSet.getString("course_name"),
                        resultSet.getDouble("course_credits"),
                        resultSet.getInt("course_hours"),
                        resultSet.getInt("max_participants")

                ));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return list;


    }


}
