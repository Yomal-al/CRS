package com.example.hms.dto;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CourseDTO {

    private final SimpleStringProperty courseId;
    private final SimpleStringProperty courseName;
    private final SimpleDoubleProperty courseCredits;
    private final SimpleIntegerProperty courseHours;;
    private final SimpleIntegerProperty maxParticipants;

    public CourseDTO(String courseId , String courseName , Double courseCredits , Integer courseHours , Integer maxParticipants) {

        this.courseId=new SimpleStringProperty(courseId);
        this.courseCredits=new SimpleDoubleProperty(courseCredits);
        this.courseName=new SimpleStringProperty(courseName);
        this.courseHours=new SimpleIntegerProperty(courseHours);
        this.maxParticipants=new SimpleIntegerProperty(maxParticipants);

    }

//    public CourseDTO(String courseName) {
//        this.courseName = new SimpleStringProperty(courseName);
//    }


    public String getCourseId() {
        return courseId.get();
    }

    public String getCourseName() {
        return courseName.get();
    }

    public double getCourseCredits() {
        return courseCredits.get();
    }

    public int getCourseHours() {
        return courseHours.get();
    }

    public int getMaxParticipants() {
        return maxParticipants.get();
    }

    public CourseDTO(SimpleStringProperty courseId, String courseName, SimpleDoubleProperty courseCredits, SimpleIntegerProperty courseHours, SimpleIntegerProperty maxParticipants) {
        this.courseId = courseId;
        this.courseName = new SimpleStringProperty(courseName);
        this.courseCredits = courseCredits;
        this.courseHours = courseHours;
        this.maxParticipants = maxParticipants;
    }



    public StringProperty courseNameProperty() {
        return courseName;
    }


}

