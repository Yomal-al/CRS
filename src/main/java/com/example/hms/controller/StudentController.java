package com.example.hms.controller;

import com.example.hms.dao.CourseDAO;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.hms.dto.CourseDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


public class StudentController{

    @FXML
    private ComboBox<String> comboname;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem menuItemHome;

    @FXML
    private TextArea studentDetailsCourses;

    @FXML
    private TextField studentDetailsGPA;

    @FXML
    private TextField studentDetailsID;

    @FXML
    private TextField studentDetailsName;


    //------------Table---------------


    @FXML
    private TableView<CourseDTO> tableview;

    @FXML
    private TableColumn courseCredits;

    @FXML
    private TableColumn courseHours;

    @FXML
    private TableColumn courseId;

    @FXML
    private TableColumn courseName;

    @FXML
    private TableColumn maxParticipants;


    //-----------ButtonMethods------------

    public void setValueCourse(){
        courseCredits.setCellValueFactory(new PropertyValueFactory<>("courseCredits"));
        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId") );
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseHours.setCellValueFactory(new PropertyValueFactory<>("courseHours"));
        maxParticipants.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));

    }


    @FXML
    private void courseDetails() {

        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseCredits.setCellValueFactory(new PropertyValueFactory<>("courseCredits"));
        courseHours.setCellValueFactory(new PropertyValueFactory<>("courseHours"));
        maxParticipants.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));


        CourseDAO courseDAO = new CourseDAO();

        ObservableList<CourseDTO> data = courseDAO.insertTableView();
        tableview.setItems(data);
        courseDAO.insertTableView();

        ObservableList<CourseDTO> courseList = courseDAO.insertTableView();
        ObservableList<String> courseNames = FXCollections.observableArrayList();

        for (CourseDTO course : courseList) {
            courseNames.add(course.getCourseName());
        }

        comboname.setItems(courseNames);


    }

}
