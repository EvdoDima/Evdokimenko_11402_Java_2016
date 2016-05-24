package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class AddCarController {
    public TextField carModel;
    public TextField year;
    public TextField run;

    public void setApp(Main app) {
        this.app = app;
    }

    private Main app;

    public void handleCarAddAction(ActionEvent actionEvent) {

    }

    public void handleRegisterDriverPage(ActionEvent actionEvent) {
        app.initRegisterDriverPage();
    }
}
