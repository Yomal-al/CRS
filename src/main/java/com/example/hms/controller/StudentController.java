package com.example.hms.controller;

import com.example.hms.dao.CourseDAO;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
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


public class StudentController {

        @FXML
        private ComboBox comboname;
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private MenuItem menuItemHome;

        //--------Panes---------------

        @FXML
        private StackPane acedemicRecordPane;

        @FXML
        private StackPane courseDetailsPane;

        @FXML
        private StackPane enrollmentManagementPane;

        @FXML
        private StackPane reportingPane;

        @FXML
        private StackPane studentDetailsPane;

        @FXML
        private AnchorPane welcomeScreen;


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
    private void acedemicRecordButtonClick(ActionEvent event) {

        acedemicRecordPane.setVisible(true);
        welcomeScreen.setVisible(false);
        studentDetailsPane.setVisible(false);
        enrollmentManagementPane.setVisible(false);
        courseDetailsPane.setVisible(false);
        reportingPane.setVisible(false);



    }

    @FXML
    private void reportingButtonClick() {

        reportingPane.setVisible(true);
        welcomeScreen.setVisible(false);
        studentDetailsPane.setVisible(false);
        enrollmentManagementPane.setVisible(false);
        courseDetailsPane.setVisible(false);
        acedemicRecordPane.setVisible(false);
    }

    @FXML
    private void courseDetailsButtonClick() {

        courseDetailsPane.setVisible(true);
        welcomeScreen.setVisible(false);
        studentDetailsPane.setVisible(false);
        enrollmentManagementPane.setVisible(false);
        reportingPane.setVisible(false);
        acedemicRecordPane.setVisible(false);

        courseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseCredits.setCellValueFactory(new PropertyValueFactory<>("courseCredits"));
        courseHours.setCellValueFactory(new PropertyValueFactory<>("courseHours"));
        maxParticipants.setCellValueFactory(new PropertyValueFactory<>("maxParticipants"));


        CourseDAO courseDAO=new CourseDAO();
        comboName

        ObservableList<CourseDTO> data = courseDAO.insertTableView();
        tableview.setItems(data);

         courseDAO.insertTableView();

        ObservableList<CourseDTO> comboName = courseDAO.insertTableView();



    }

    @FXML
    private void enrollmentManagementButtonClick() {

        enrollmentManagementPane.setVisible(true);
        welcomeScreen.setVisible(false);
        studentDetailsPane.setVisible(false);
        courseDetailsPane.setVisible(false);
        reportingPane.setVisible(false);
        acedemicRecordPane.setVisible(false);
    }

    @FXML
    private void studentDetailsButtonClick() {

        studentDetailsPane.setVisible(true);
        welcomeScreen.setVisible(false);
        enrollmentManagementPane.setVisible(false);
        courseDetailsPane.setVisible(false);
        reportingPane.setVisible(false);
        acedemicRecordPane.setVisible(false);
    }


    //------------MenuButton----------------

    @FXML
    private void menuItemHomeSelect() {

        welcomeScreen.setVisible(true);
        studentDetailsPane.setVisible(false);
        enrollmentManagementPane.setVisible(false);
        courseDetailsPane.setVisible(false);
        reportingPane.setVisible(false);
        acedemicRecordPane.setVisible(false);


    }


}
