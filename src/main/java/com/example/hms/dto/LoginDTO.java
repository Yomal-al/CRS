package com.example.hms.dto;

import com.example.hms.dao.LoginDAO;

public class LoginDTO {
    private String name;
    private String password;
    private String role;
    private int id;

    public LoginDTO(String name, String password, String role){
        this.name=name;
        this.password=password;
        this.role=role;

    }

    public LoginDTO(String name, String password){
        this.name=name;
        this.password=password;
    }

    public LoginDTO(String name,int id){
        this.name=name;
        this.id=id;
    }



    //-------getters----------
    public String getUsername() {
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    public int getId(){ return id;}
    public String getName(){return name;}




    //--------setters----------

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }




}
