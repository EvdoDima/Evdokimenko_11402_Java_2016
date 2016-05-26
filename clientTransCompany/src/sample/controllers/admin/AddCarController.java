package sample.controllers.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.controllers.AbstractController;
import sample.controllers.Validation;
import sample.models.CarsEntity;

import java.util.regex.Pattern;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class AddCarController extends AbstractController {
    public TextField carModel;
    public TextField year;
    public TextField run;
    public Label errorField;


    public void handleCarAddAction(ActionEvent actionEvent) {
        if (Validation.validateNumber(run.getText())&&Validation.validateNumber(year.getText())) {
            CarsEntity carsEntity = new CarsEntity();
            carsEntity.setModel(carModel.getText());
            carsEntity.setYear(Integer.parseInt(year.getText()));
            carsEntity.setRun(Integer.parseInt(run.getText()));
            carsEntity.setState("free");
            server.postNewCar(carsEntity);

            app.changeScene("admin/AddCarPage");
        }
        else    {
            errorField.setText("Wrong number format");
        }

    }




}
