package com.example.hms.dao;

import com.example.hms.controller.DBConnection;
import com.example.hms.dto.StudentDTO;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class StudentDAO {

    private final Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public void getStudentData(){

    }


}
