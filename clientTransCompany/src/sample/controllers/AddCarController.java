package sample.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import sample.Main;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class AddCarController extends AbstractController{
    public TextField carModel;
    public TextField year;
    public TextField run;



    public void handleCarAddAction(ActionEvent actionEvent) {

    }

    public void handleRegisterDriverPage(ActionEvent actionEvent) {
        app.changeScene("admin/RegisterDriverPage");
    }
}
