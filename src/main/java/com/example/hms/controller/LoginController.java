package com.example.hms.controller;

import com.example.hms.dao.LoginDAO;
import com.example.hms.dto.LoginDTO;
import com.example.hms.dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
    private Label namePasswordNotFoundError;

    @FXML
    private CheckBox showLoginPassword;

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
    private ComboBox loginUserRole;

    @FXML
    private ComboBox registerUser;





    @FXML
    private void toggleShowPassword(ActionEvent event) {
        boolean checkBox=showLoginPassword.isSelected();



    }

    //---------------Login Form Methods---------------

    @FXML
    private String loginButtonClick(ActionEvent event) {
        String UserName = login_userName.getText();
        usernameError.setVisible((UserName == null || UserName.trim().isEmpty()) ? true : false);
        System.out.println(UserName);
        boolean checkName=((UserName == null || UserName.trim().isEmpty()) ? false : true);

        String Password=login_password.getText();
        passwordError.setVisible((Password==null || Password.trim().isEmpty())? true: false);
        System.out.println(Password);
        boolean checkPassword=((Password==null || Password.trim().isEmpty())? false : true);

        String loginRole=(String) loginUserRole.getValue();
        selectUserError.setVisible((loginRole==null||loginRole.trim().isEmpty()? true:false));
        System.out.println(loginRole);
        boolean checkRole=((loginRole==null||loginRole.trim().isEmpty()? false : true));



        if (checkName && checkPassword && checkRole) {
            try {
                Connection connection = DBConnection.getConnection();
                LoginDAO loginDAO = new LoginDAO(connection);

                LoginDTO user = loginDAO.getUser(UserName, Password, loginRole);



                if (user != null) {

                    UserSession.setSession(user);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Course Registration System");
                    alert.setHeaderText("Successfully Logged In!");
                    alert.setContentText("Welcome " + UserName);

                    alert.showAndWait();

                    System.out.println("Login successful");
                    namePasswordNotFoundError.setVisible(false);



                    try {
                        Stage curentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        curentStage.close();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hms/view/student.fxml"));

                        if (loginRole.equals("Student")) {
                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hms/view/student.fxml"));

                        } else if (loginRole.equals("Admin")) {

                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hms/view/admin.fxml"));

                        } else if (loginRole.equals("Administrative Staff")){

                            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hms/view/staff.fxml"));

                        }else{
                        }

                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Course Registration System");
                        stage.show();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                } else {
                    namePasswordNotFoundError.setVisible(true);


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
        }
        return loginRole;
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
    private void registerButtonClick(ActionEvent event){
        String newUserPassword=register_password.getText();
        String newUser = register_userName.getText();
        String newRole= (String) registerUser.getValue();
        String loginRole =loginButtonClick(event);

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
                if (!showLoginPassword.isSelected()) {
                    register_password.setText(newText);
                }
            });

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
                boolean saved=false;

                switch(newRole){
                    case "Student":
                        saved=loginDAO.saveUserStudent(user);
                        break;
                    case "Admin":
                       saved= loginDAO.saveUserAdmin(user);
                        break;
                    case "Administrative Staff":
                        saved = loginDAO.saveUserStaff(user);
                        break;
                }

                System.out.println(loginRole);

                if (saved) {
                    System.out.println("Saved sucesfully!");
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Course Registration System");
                    alert.setContentText("Successfully Registered!");

                    alert.showAndWait();
                    switchToLogin();

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

