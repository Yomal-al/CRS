package com.example.hms.dto;

public class StudentDTO{

    private final String courseid;
    private final int studentid;
    private  double gpa;
    private  String history;

    public StudentDTO(String courseid, int studentid, double gpa, String history){
        this.courseid = courseid;
        this.studentid = studentid;
        this.gpa = gpa;
        this.history = history;
    }

    public StudentDTO(String courseid,int studentid){
        this.courseid=courseid;
        this.studentid=studentid;
    }

    public int getStudentid() {
        return studentid;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getCourseid() {
        return courseid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "courseid='" + courseid + '\'' +
                ", studentid=" + studentid +
                ", gpa=" + gpa +
                ", history='" + history + '\'' +
                '}';
    }

}
