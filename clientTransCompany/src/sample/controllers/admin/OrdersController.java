package sample.controllers.admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controllers.AbstractController;
import sample.models.OrdersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public class OrdersController extends AbstractController {


    public TableView<OrdersEntity> ordersTable;
    public TableColumn<OrdersEntity,String> idColumn;
    public TableColumn<OrdersEntity,String> statusColumn;
    public TableColumn<OrdersEntity,String> summColumn;
    public TableColumn<OrdersEntity,String> descriptionColumn;
    public TableColumn<OrdersEntity,String> driverTelColumn;
    public TableColumn<OrdersEntity,String> customerTelColumn;
    public TableColumn<OrdersEntity,String> carModelColumn;

    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        statusColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getStatus()));

        summColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getCost())));

        descriptionColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDescription()));

        driverTelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getDriver().getTelNumber()));

        customerTelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getCustomer().getTelNumber()));

        carModelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getCar().getModel()));



        ObservableList<OrdersEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getOrders());

        ordersTable.setItems(list);

    }
}
