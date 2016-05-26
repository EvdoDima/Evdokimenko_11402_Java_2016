package sample.controllers.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import sample.Main;
import sample.controllers.AbstractController;
import sample.models.CarsEntity;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class AddCarController extends AbstractController {
    public TextField carModel;
    public TextField year;
    public TextField run;



    public void handleCarAddAction(ActionEvent actionEvent) {
        CarsEntity carsEntity = new CarsEntity();
        carsEntity.setModel(carModel.getText());
        carsEntity.setYear(Integer.parseInt(year.getText()));
        carsEntity.setRun(Integer.parseInt(run.getText()));
        carsEntity.setState("free");
        server.postNewCar(carsEntity);

        app.changeScene("admin/AddCarPage");

    }




}
