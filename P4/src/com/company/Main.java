package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Anwendung
        Button buttonAnwendung = new Button();
        buttonAnwendung.setText("Anwendung");

        buttonAnwendung.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent secRoot;
                try {
                    secRoot = FXMLLoader.load(getClass().getResource("anwendung.fxml"));
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    return;
                }
                Stage secStage = new Stage();
                secStage.setTitle("Benutzerverwaltung");
                secStage.setScene(new Scene(secRoot));
                secStage.show();
            }
        });

        // Login
        Button buttonLogin = new Button();
        buttonLogin.setText("Login");

        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent secRoot;
                try {
                    secRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    return;
                }
                Stage secStage = new Stage();
                secStage.setTitle("Benutzerverwaltung");
                secStage.setScene(new Scene(secRoot));
                secStage.show();
            }
        });

        Button buttonAnmeldung = new Button();
        buttonAnmeldung.setText("Anmeldung");

        buttonAnmeldung.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent secRoot;
                try {
                    secRoot = FXMLLoader.load(getClass().getResource("anmeldung.fxml"));
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    return;
                }
                Stage secStage = new Stage();
                secStage.setTitle("Benutzerverwaltung");
                secStage.setScene(new Scene(secRoot));
                secStage.show();
            }
        });
        // Some more init Stuff
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(buttonAnwendung, 0, 1);
        grid.add(buttonLogin, 1, 1);
        grid.add(buttonAnmeldung, 2, 1);
        Scene scene = new Scene(grid, 250, 100);

        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
