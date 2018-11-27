package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Parent root = FXMLLoader.load(getClass().getResource("anwendung.fxml"));
        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/

        /*
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/

        Parent root = FXMLLoader.load(getClass().getResource("anmeldung.fxml"));
        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
