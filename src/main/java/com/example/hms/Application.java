package com.example.hms;

import com.example.hms.controller.DBConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        DBConnection.initialize();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/hms/view/loginportal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 750);stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        stage.setResizable(false);

        stage.setMaxWidth(450);
        stage.setMaxHeight(1150);

        stage.setTitle("Course Registration System");
        stage.show();




    }

    public static void main(String[] args) {

        launch();
    }



}