package sample.controllers.driver;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.controllers.AbstractController;
import sample.models.OrdersEntity;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public class MyOrdersController extends AbstractController {

    public TableView<OrdersEntity> ordersTable;
    public TableColumn<OrdersEntity, String> idColumn;
    public TableColumn<OrdersEntity, String> statusColumn;
    public TableColumn<OrdersEntity, String> summColumn;
    public TableColumn<OrdersEntity, String> driverTelColumn;
    public TableColumn<OrdersEntity, String> customerTelColumn;
    public TableColumn<OrdersEntity, String> carModelColumn;

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        statusColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getStatus()));

        summColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getCost())));


        driverTelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDriver().getTelNumber()));

        customerTelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCustomer().getTelNumber()));

        carModelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCar().getModel()));

        statusColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<OrdersEntity, String>, TableCell<OrdersEntity, String>> cellFactory =
                new Callback<TableColumn<OrdersEntity, String>, TableCell<OrdersEntity, String>>() {
                    @Override
                    public TableCell call(final TableColumn<OrdersEntity, String> param) {
                        return new TableCell<OrdersEntity, String>() {

                            final Button btn = new Button("Complete");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    OrdersEntity order = getTableView().getItems().get(getIndex());
                                    btn.setOnAction((ActionEvent event) ->{
                                            server.updateOrderStatus(order.getId());
                                            handleMyOrders(new ActionEvent());
                                    });
                                    if (!order.getStatus().equals("Completed"))
                                    setGraphic(btn);
                                    else    setGraphic(new Label("Completed"));
                                    setText(null);
                                }
                            }
                        };
                    }
                };

        statusColumn.setCellFactory(cellFactory);


        ObservableList<OrdersEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getOrders());

        ordersTable.setItems(list);

    }
}
