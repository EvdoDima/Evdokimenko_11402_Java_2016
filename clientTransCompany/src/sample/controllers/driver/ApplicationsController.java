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
import sample.models.ApplicationsEntity;
import sample.models.CarsEntity;
import sample.models.OrdersEntity;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public class ApplicationsController extends AbstractController {
    public TableView<ApplicationsEntity> applicationsTable;
    public TableColumn<ApplicationsEntity,String> idColumn;
    public TableColumn<ApplicationsEntity,String> nameColumn;
    public TableColumn<ApplicationsEntity,String> descriptionColumn;
    public TableColumn<ApplicationsEntity,String> summColumn;
    public TableColumn<ApplicationsEntity,String> getAppColumn;

    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getName()));

        descriptionColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getDescription())));

        summColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getSumm())));

        getAppColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        Callback<TableColumn<ApplicationsEntity, String>, TableCell<ApplicationsEntity, String>> cellFactory2 =
                new Callback<TableColumn<ApplicationsEntity, String>, TableCell<ApplicationsEntity, String>>() {
                    @Override
                    public TableCell call(final TableColumn<ApplicationsEntity, String> param) {
                        return new TableCell<ApplicationsEntity, String>() {
                            final Button btn =
                                    new Button("get");
                            @Override
                            public void updateItem(String item, boolean empty) {

                                if (server.getAvailableCars().size()==0){
                                    btn.setDisable(true);
                                }
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    ApplicationsEntity application = getTableView().getItems().get(getIndex());
                                    btn.setOnAction((ActionEvent event) ->{
                                        server.updateApplication(application.getId());
                                        handleMyOrders(new ActionEvent());
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                    }
                };

        getAppColumn.setCellFactory(cellFactory2);




        ObservableList<ApplicationsEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getApplications());

        applicationsTable.setItems(list);

    }



}
