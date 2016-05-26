package sample.controllers.customer;

import javafx.beans.binding.IntegerBinding;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.controllers.AbstractController;
import sample.controllers.Validation;
import sample.models.ApplicationsEntity;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class NewApplicationController extends AbstractController {
    public TextField name;
    public TextField summ;
    public TextArea description;
    public Label errorField;

    public void handleSendApplication(ActionEvent actionEvent) {
        if (Validation.validateNumber(summ.getText())) {
            ApplicationsEntity applicationsEntity = new ApplicationsEntity();
            applicationsEntity.setDescription(description.getText());
            applicationsEntity.setName(name.getText());
            applicationsEntity.setSumm(Integer.parseInt(summ.getText()));

            server.postNewApplication(applicationsEntity);
            app.changeScene("customer/NewApplicationPage");
        } else {
            errorField.setText("Wrong number format");
        }
    }
}
