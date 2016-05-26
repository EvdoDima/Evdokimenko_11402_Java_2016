package sample.controllers.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.Main;
import sample.controllers.AbstractController;
import sample.controllers.Validation;
import sample.models.DriversEntity;
import sample.models.UserRoleEntity;
import sample.models.UsersEntity;
import sample.models.enums.UserRole;

/**
 * Created by evdodima on 24/05/16.
 * 11-402
 */
public class RegisterDriverController extends AbstractController {


    public PasswordField password;
    public TextField firstname;
    public TextField lastname;
    public TextField drivingexp;
    public TextField salaryrate;
    public TextField login;
    public TextField telnumber;
    public Label errorField;


    public void handleDriverRegister(ActionEvent actionEvent) {

        if (Validation.validateNumber(telnumber.getText())&&
                Validation.validateNumber(drivingexp.getText())&&
                Validation.validateDouble(salaryrate.getText())) {

            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setLogin(login.getText());
            usersEntity.setPassword(password.getText());

            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUser_role(UserRole.ROLE_DRIVER);
            //  userRoleEntity.setUser(usersEntity);

            DriversEntity driversEntity = new DriversEntity();
            driversEntity.setFirstName(firstname.getText());
            driversEntity.setLastName(lastname.getText());
            driversEntity.setDrivingExp(Integer.parseInt(drivingexp.getText()));
            driversEntity.setSalaryRate(Double.parseDouble(salaryrate.getText()));
            driversEntity.setTelNumber(telnumber.getText());
            //  driversEntity.setUser(usersEntity);


            usersEntity.setRole(userRoleEntity);
            usersEntity.setDriver(driversEntity);


            server.postNewUser(usersEntity);
            app.changeScene("admin/RegisterDriverPage");
        }else{
            errorField.setText("Wrong number format");
        }
    }


}
