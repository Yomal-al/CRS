package com.example.hms.controller;

import com.example.hms.dao.SaveCourseDAO;
import com.example.hms.dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StaffController {

    @FXML
    private TextField txtAddCourseId;

    @FXML
    private TextField txtAddCourseName;

    @FXML
    private TextField txtAddCredits;

    @FXML
    private TextField txtAddHours;

    @FXML
    private TextField txtAddCapacity;

    @FXML
    private Button btnAddCourseAction;

    @FXML
    private Label lblWelcomeName;

    @FXML
    private Label lblDate;

    @FXML
    private VBox paneAddCourse;

    @FXML
    private VBox paneDeleteCourse;

    @FXML
    private VBox paneEditCourse;

    @FXML
    private StackPane contentArea;

    @FXML
    private ToggleButton btnSideAdd;

    @FXML
    private ToggleButton btnSideDelete;

    @FXML
    private ToggleButton btnSideEdit;


    @FXML
    private void initialize() {
        contentArea.getChildren().setAll(paneAddCourse);
        btnAddCourseAction.setOnAction(event -> addCourse());

    }

    private void addCourse() {
        try {

            String courseId = txtAddCourseId.getText();
            String courseName = txtAddCourseName.getText();
            double courseCredits = Double.parseDouble(txtAddCredits.getText());
            int courseHours = Integer.parseInt(txtAddHours.getText());
            int maxParticipants = Integer.parseInt(txtAddCapacity.getText());


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
    @FXML
    private void switchForm(ActionEvent event){
        Object source= event.getSource();

        contentArea.getChildren().clear();

        if(source == btnSideAdd){
            contentArea.getChildren().add(paneAddCourse);
        }else if(source == btnSideDelete){
            contentArea.getChildren().add(paneDeleteCourse);
        } else if(source == btnSideEdit) {
            contentArea.getChildren().add(paneEditCourse);
        }

    }


    public void courseDetails(Event event) {

    }
}
