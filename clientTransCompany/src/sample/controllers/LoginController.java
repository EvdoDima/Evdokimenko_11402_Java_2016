package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class LoginController extends AbstractController {


    public TextField loginTextField;
    public PasswordField passwordField;



    public void handleSubmitAction(ActionEvent actionEvent) {
        System.out.println("HUI " + loginTextField.getText() + " " + passwordField.getText());
        app.changeScene("admin/RegisterDriverPage");
    }
}
