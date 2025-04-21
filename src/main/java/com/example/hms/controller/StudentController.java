package com.example.hms.controller;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.hms.dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.MenuItem;

import javax.swing.table.TableColumn;


public class StudentController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private MenuItem menuItemHome;

        @FXML
        private TableView tableView;

        //--------Panes---------------

        @FXML
        private AnchorPane acedemicRecordPane;

        @FXML
        private AnchorPane courseDetailsPane;

        @FXML
        private AnchorPane enrollmentManagementPane;

        @FXML
        private AnchorPane reportingPane;

        @FXML
        private AnchorPane studentDetailsPane;

        @FXML
        private AnchorPane welcomeScreen;

    //------------Table---------------


    @FXML
    private TableView<StudentDTO> tableview;

    @FXML
    private TableColumn<StudentDTO,Boolean > courseCredits;

    @FXML
    private TableColumn<StudentDTO, > courseHours;

    @FXML
    private TableColumn<?, ?> courseId;

    @FXML
    private TableColumn<?, ?> courseName;

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
