package com.example.hms.controller;

import com.example.hms.dao.SaveCourseDAO;
import com.example.hms.dto.CourseDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;

public class StaffController {

    @FXML
    private TextField txtCourseId;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCredits;

    @FXML
    private TextField txtHours;

    @FXML
    private TextField txtMaxParticipants;

    @FXML
    private Button btnAddCourse;

    @FXML
    private void initialize() {
        btnAddCourse.setOnAction(event -> addCourse());
    }

    private void addCourse() {
        try {

            String courseId = txtCourseId.getText();
            String courseName = txtCourseName.getText();
            double courseCredits = Double.parseDouble(txtCredits.getText());
            int courseHours = Integer.parseInt(txtHours.getText());
            int maxParticipants = Integer.parseInt(txtMaxParticipants.getText());


            CourseDTO newCourse = new CourseDTO(courseId, courseName, courseCredits, courseHours, maxParticipants);

            Connection connection = DBConnection.getConnection();


            SaveCourseDAO saveCourseDAO = new SaveCourseDAO(connection);
            saveCourseDAO.SaveCourse(newCourse);


            System.out.println("Course added successfully!");




        } catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numbers for Credits, Hours, and Max Participants.");
            alert.showAndWait();

        } catch (Exception e) {

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to add course. Check console for errors.");
            alert.showAndWait();
        }
    }


}
