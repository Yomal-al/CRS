module com.example.hms {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;

    opens com.example.hms to javafx.fxml;
    exports com.example.hms;
    exports com.example.hms.controller;
    opens com.example.hms.controller to javafx.fxml;
    exports com.example.hms.dto;
    opens com.example.hms.dto to javafx.fxml;
    exports com.example.hms.dao;
    opens com.example.hms.dao to javafx.fxml;
}