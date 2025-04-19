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


    //-------getters----------
    public String getUsername() {
        return name;

    }

    public String getPasswoord(){
        return passwoord;

    }

    public String getRole(){
        return role;
    }



    //--------setters----------

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
