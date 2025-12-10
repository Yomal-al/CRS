package com.example.hms.dto;

import com.example.hms.dao.LoginDAO;

public class LoginDTO {
    private String name;
    private String password;
    private String role;

    public LoginDTO(String name, String password, String role){
        this.name=name;
        this.password=password;
        this.role=role;

    }

    public LoginDTO(String name, String password){
        this.name=name;
        this.password=password;
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
