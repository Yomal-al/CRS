package com.example.hms.controller;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.ResourceBundle;

import com.example.hms.dto.CourseDTO;
import com.example.hms.dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

import javafx.scene.control.TableColumn;


public class StudentController {


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
    private TableView<StudentDTO> tableview;

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

        ObservableList<CourseDTO> list= FXCollections.observableArrayList();

        try{
            Connection connection =DBConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM course_details");

            while(resultSet.next()){
                    list.add(new CourseDTO(
                            resultSet.getString()
                    ))
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
