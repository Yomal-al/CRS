package com.example.hms.dao;

import com.example.hms.controller.DBConnection;
import com.example.hms.dto.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollCourseDAO {
    private final Connection  connection;

    public EnrollCourseDAO(Connection connection){
        this.connection=connection;
    }

    public boolean setStudentEnrollmentDetails(StudentDTO enrollment){

        String sql="INSERT INTO student_academicdetails(student_id,course_id) VALUES (?,?);";


        try(PreparedStatement statement = connection.prepareStatement(sql);){


            statement.setString(2,enrollment.getCourseid());
            statement.setInt(1,enrollment.getStudentid());

            int rowseffected = statement.executeUpdate();
            return rowseffected>0;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }}
