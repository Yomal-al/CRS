package com.example.hms.controller;

import com.example.hms.dao.CourseDAO;
import com.example.hms.dao.EnrollCourseDAO; // Import the new DAO
import com.example.hms.dto.CourseDTO;
import com.example.hms.dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;

public class StudentController {

    @FXML private ComboBox<String> comboname;
    @FXML private TextField studentDetailsID;

    private ObservableList<CourseDTO> courseList;

    @FXML private TableView<CourseDTO> tableview;
    @FXML private TableColumn<CourseDTO, String> courseId;
    @FXML private TableColumn<CourseDTO, String> courseName;
    @FXML private Label userNameLabel;

    public void initialize(){

        if(UserSession.getInstance()!= null || UserSession.getInstance().getUser()!=null) {

            String userName=UserSession.getInstance().getUser().getName();
            int userId= UserSession.getInstance().getUser().getId();


            userNameLabel.setText(userName);

        }else {

        }

        courseDetails();

    }

    @FXML
    public void setEnrollCourse(ActionEvent event) {
        try {
            String selectedCourseName = comboname.getValue();
            String rawStudentId = studentDetailsID.getText();

            if (selectedCourseName == null || rawStudentId.isEmpty()) {
                showAlert("Error", "Please select a course and enter a Student ID.");
                return;
            }

            // 2. Find the Course ID associated with the selected Name
            String selectedCourseId = getCourseIdByName(selectedCourseName);
            if (selectedCourseId == null) {
                showAlert("Error", "Invalid Course Selection.");
                return;
            }

            // 3. Parse Student ID
            int sId = Integer.parseInt(rawStudentId);

            // 4. Create DTO
            // Use the constructor you made: StudentDTO(String courseid, int studentid)
            StudentDTO enrollment = new StudentDTO(selectedCourseId, sId);

            // 5. Instantiate DAO and Save
            Connection connection = DBConnection.getConnection();
            EnrollCourseDAO enrollDAO = new EnrollCourseDAO(connection);

            if (enrollDAO.setStudentEnrollmentDetails(enrollment)) {
                showAlert("Success", "Student Enrolled Successfully!");
            } else {
                showAlert("Error", "Enrollment Failed. Student might already be enrolled.");
            }

        } catch (NumberFormatException e) {
            showAlert("Error", "Student ID must be a number.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Database Connection Failed.");
        }
    }

    /**
     * Helper Method: Looks through our list to find the ID for a given name.
     */
    private String getCourseIdByName(String name) {
        if (courseList == null) return null;

        for (CourseDTO course : courseList) {
            if (course.getCourseName().equals(name)) {
                return course.getCourseId();
            }
        }
        return null;
    }

    // ... (Your existing courseDetails method needs a small fix too) ...

    @FXML
    private void courseDetails() {
        // Setup Columns
        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        // ... set other columns ...

        CourseDAO courseDAO = new CourseDAO();

        // FIX: Fetch data ONLY ONCE and store it in the class-level variable
        this.courseList = courseDAO.getAllCourses();

        // Populate Table
        tableview.setItems(this.courseList);

        // Populate ComboBox
        ObservableList<String> courseNames = FXCollections.observableArrayList();
        for (CourseDTO course : this.courseList) {
            courseNames.add(course.getCourseName());
        }
        comboname.setItems(courseNames);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}