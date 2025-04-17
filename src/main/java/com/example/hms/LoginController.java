package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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

    }
//    @FXML
//    private void loginButtonEnter(){
//        loginButton.setStyle("-fx-background-color:  A6A39E;");
//    }
//
//    @FXML
//    private void loginButtonExit(){
//        loginButton.setStyle("-fx-background-color: BAB6B2;");
//    }

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


        try {
            registerUserNameError.setVisible((newUser==null || newUser.trim().isEmpty() )? true:false);
            System.out.println(newUser);

        } catch (Exception e) {
            System.out.println("UserName Error");
        }

        try{
            passwordsDoNotMatch.setVisible(register_password.getText().equals((confirm_password.getText()))? false:true);

            try{
                registerPasswordError.setVisible((newUserPassword==null || newUserPassword.trim().isEmpty() )? true:false);
                System.out.println(newUserPassword);

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
    }


}

