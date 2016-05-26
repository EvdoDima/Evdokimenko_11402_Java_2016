package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.connection.ServerAuth;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class LoginController extends AbstractController {


    public TextField loginTextField;
    public PasswordField passwordField;
    public Label errorField;


    public void handleSubmitAction(ActionEvent actionEvent) {
        ServerAuth auth = new ServerAuth();
        if (auth.tryAuth(loginTextField.getText(), passwordField.getText())) {
                switch (ServerAuth.role){
                    case ROLE_ADMIN:
                        app.changeScene("admin/OrdersPage");
                        break;
                    case ROLE_CUSTOMER:
                        app.changeScene("customer/NewApplicationPage");
                        break;

                    case ROLE_DRIVER:
                        app.changeScene("driver/ApplicationsPage");
                        break;
                    default:app.changeScene("LoginPage");
                }




        } else {
            errorField.setText(" Incorrect login or password");
        }
    }
}
