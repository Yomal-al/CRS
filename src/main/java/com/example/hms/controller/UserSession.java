package com.example.hms.controller;

import com.example.hms.dto.LoginDTO;

public class UserSession {

    private static UserSession instance;

    private LoginDTO currentUser;

    private UserSession(LoginDTO currentUser){
        this.currentUser=currentUser;
    }

    public static void setSession(LoginDTO currentUser){
        if(instance==null){
            instance=new UserSession(currentUser);
        }
    }

    public static UserSession getInstance() {
        return instance;
    }

    public LoginDTO getUser(){
        return currentUser;
    }

    public static void cleanUserSession(){
        instance=null;
    }
}

