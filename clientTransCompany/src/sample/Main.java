package sample;


import javafx.animation.PathTransition;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;


public class Main extends Application {

    Scene mainScene;
    Stage currentStage;



    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        currentStage = primaryStage;
        currentStage.setTitle("TransCompany");

        Parent root = initLoginPage();

        currentStage.setScene(new Scene(root));
        currentStage.show();
    }


    public Parent initLoginPage() throws IOException {
        return FXMLLoader.load(getClass().getResource("scenes/LoginPage.fxml"));
    }





}