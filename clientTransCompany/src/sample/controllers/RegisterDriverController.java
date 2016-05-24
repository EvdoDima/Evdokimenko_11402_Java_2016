package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class RegisterDriverController {


    public PasswordField password;
    public TextField firstname;
    public TextField lastname;
    public TextField drivingexp;
    public TextField salaryrate;
    public TextField login;

    public void setApp(Main app) {
        this.app = app;
    }

    private Main app;

    public void handleAddNewCarPage(ActionEvent actionEvent) {
        app.initAddCarPage();

    }

    public void handleDriverRegister(ActionEvent actionEvent) {

    }
}
