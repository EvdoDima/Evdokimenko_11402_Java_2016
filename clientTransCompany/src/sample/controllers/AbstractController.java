package sample.controllers;

import javafx.event.ActionEvent;
import sample.Main;
import sample.connection.ServerConnection;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public abstract class AbstractController {

    public void setApp(Main app) {
        this.app = app;
    }

    protected Main app;

    protected ServerConnection server = new ServerConnection();


    public void handleRegisterDriverPage(ActionEvent actionEvent) {
        app.changeScene("admin/RegisterDriverPage");
    }

    public void handleAddNewCarPage(ActionEvent actionEvent) {
        app.changeScene("admin/AddCarPage");

    }

    public void handleOrdersPage(ActionEvent actionEvent) {
        app.changeScene("admin/OrdersPage");

    }

    public void handleMyOrders(ActionEvent actionEvent) {
        app.changeScene("driver/MyOrdersPage");
    }

    public void handleCars(ActionEvent actionEvent) {
        app.changeScene("driver/CarsPage");
    }


    public void handleCustomerCars(ActionEvent actionEvent) {
        app.changeScene("customer/CarsPage");
    }



    public void handleApplications(ActionEvent actionEvent){
        app.changeScene("driver/ApplicationsPage");
    }


    public void handleNewApplication(ActionEvent actionEvent) {
        app.changeScene("customer/NewApplicationPage");
    }

}
