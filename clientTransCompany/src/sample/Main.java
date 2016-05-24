package sample;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


import javafx.stage.Stage;
import sample.controllers.AddCarController;
import sample.controllers.LoginController;
import sample.controllers.RegisterDriverController;

import java.io.IOException;
import java.io.Reader;


public class Main extends Application {

   // private Scene mainScene;
    private Stage currentStage;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        currentStage = primaryStage;
        currentStage.setTitle("TransCompany");
        initLoginPage();
    }


    public void initLoginPage()  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/LoginPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginController controller = loader.getController();
        controller.setApp(this);

        changeScene(root);

    }


    public void changeToAddCarPage()  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/admin/AddCarPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddCarController controller = loader.getController();
        controller.setApp(this);

        changeScene(root);

    }

    public void changeToRegisterDriverPage()  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/admin/RegisterDriverPage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RegisterDriverController controller = loader.getController();
        controller.setApp(this);

        changeScene(root);

    }


    public void changeScene(Parent root){
        currentStage.setScene(new Scene(root));
        currentStage.show();
    }


}