package com.example.hms.dao;

import com.example.hms.dto.CourseDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class SaveCourseDAO {

    private final Connection connection;

    public SaveCourseDAO(Connection connection) {
        this.connection = connection;
    }

    public void SaveCourse(CourseDTO course) {

        String sql1 = "INSERT INTO course_details (course_id,course_name,course_credits,course_hours,max_participants ) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql1);

            statement.setString(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setDouble(3, course.getCourseCredits());
            statement.setInt(4, course.getCourseHours());
            statement.setInt(5, course.getMaxParticipants());


            int rowsAffected = statement.executeUpdate();



        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
