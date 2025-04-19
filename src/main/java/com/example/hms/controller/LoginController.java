package com.example.hms.controller;

import com.example.hms.dao.LoginDAO;
import com.example.hms.dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;

public class LoginController {
    @FXML
    private Label usernameError;

    @FXML
    private Label passwordError;

    @FXML
    private Label registerPasswordError;

    @FXML
    private Label registerUserNameError;

    @FXML
    private Label passwordsDoNotMatch;

    @FXML
    private Label selectUserErrorRegister;

    @FXML
    private Label selectUserError;

    @FXML
    private CheckBox showPassword;

    @FXML
    private TextField login_userName;

    @FXML
    private TextField register_userName;

    @FXML
    private AnchorPane registerForm;

    @FXML
    private AnchorPane loginForm;

    @FXML
    private PasswordField login_password;

    @FXML
    private PasswordField register_password;

    @FXML
    private PasswordField confirm_password;

    @FXML
    private ComboBox loginUser;

    @FXML
    private ComboBox registerUser;





    @FXML
    private void toggleShowPassword(ActionEvent event) {
        boolean checkBox=showPassword.isSelected();

    }

    //---------------Login Form Methods---------------

    @FXML
    private void loginButtonClick(ActionEvent event) {
        String UserName = login_userName.getText();
        usernameError.setVisible((UserName == null || UserName.trim().isEmpty()) ? true : false);
        System.out.println(UserName);

        String Password=login_password.getText();
        passwordError.setVisible((Password==null || Password.trim().isEmpty())? true: false);
        System.out.println(Password);

        String loginRole=(String) loginUser.getValue();
        selectUserError.setVisible((loginRole==null||loginRole.trim().isEmpty()? true:false));
        System.out.println(loginRole);



    }

    @FXML
    private void passwordToggle(ActionEvent event){
        login_password.setVisible(true);
    }


    @FXML
    private void switchToRegister(){
        loginForm.setVisible(false);
        registerForm.setVisible(true);
    }


    //---------------Register Form Methods----------------

    @FXML
    private void switchToLogin(){
        loginForm.setVisible(true);
        registerForm.setVisible(false);
    }

    @FXML
    private void registerButtonClick(){
        String newUserPassword=register_password.getText();
        String newUser = register_userName.getText();
        String newRole= (String) registerUser.getValue();

        boolean Uname=false,Pword=false,Role=false,MPword=false;

        try {
            registerUserNameError.setVisible((newUser==null || newUser.trim().isEmpty() )? true:false);
            Uname=((newUser==null || newUser.trim().isEmpty() )? false:true);
            System.out.println(newUser+" "+Uname);


        } catch (Exception e) {
            System.out.println("UserName Error");
        }
        try{
            passwordsDoNotMatch.setVisible(register_password.getText().equals((confirm_password.getText()))? false:true);
            MPword=(register_password.getText().equals((confirm_password.getText()))? true:false);
            try{
                registerPasswordError.setVisible((newUserPassword==null || newUserPassword.trim().isEmpty() )? true:false);

                Pword=((newUserPassword==null || newUserPassword.trim().isEmpty() )? false:true);
                System.out.println(newUserPassword+" "+Pword);

                if(confirm_password.getText()==null || confirm_password.getText().trim().isEmpty()){
                    passwordsDoNotMatch.setVisible(true);

                }else{

                    System.out.println(confirm_password.getText());
                }

            } catch (Exception e) {
                System.out.println("Password fetch error");
            }


        }catch(Exception e) {
            System.out.println("Password invalid");
        }

        try{
            register_password.textProperty().addListener((obs, oldText, newText) -> {
                if (!showPassword.isSelected()) {
                    register_password.setText(newText);
                }
            });

//            register_password.textProperty().addListener((obs, oldText, newText) -> {
//                if (showPassword.isSelected()) {
//                    register_password.setText(newText);
//                }
//            });

        }catch(Exception e){
            System.out.println("login password error");
        }

        try{
            selectUserErrorRegister.setVisible(newRole == null || newRole.trim().isEmpty()? true:false );
            Role=(newRole == null || newRole.trim().isEmpty()? false:true );
            System.out.println(newRole+" "+Role);

        } catch (Exception e) {
            System.out.println("role error");
            e.printStackTrace();
        }

        //----------------transfering from view to model--------------



        if(Uname&&Pword&&Role&&MPword) {
            LoginDTO user= new LoginDTO(newUser ,newUserPassword ,newRole);

            try {
                Connection connection = DBConnection.getConnection();
                LoginDAO loginDAO = new LoginDAO(connection);

                boolean saved = loginDAO.saveUser(user);

                if (saved) {
                    System.out.println("Saved suucesfully!");
                } else {
                    System.out.println("Not saved");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Not saved");

        }


    }



}

