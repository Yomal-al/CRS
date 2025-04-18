package com.example.hms.dto;

public class LoginDTO {
    private String name;
    private String passwoord;
    private String role;

    public LoginDTO(String name, String passwoord, String role){
        this.name=name;
        this.passwoord=passwoord;
        this.role=role;

    }


}
