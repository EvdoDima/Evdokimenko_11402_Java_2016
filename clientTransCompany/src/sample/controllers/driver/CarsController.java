package sample.controllers.driver;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.controllers.AbstractController;
import sample.models.CarsEntity;
import sample.models.OrdersEntity;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public class CarsController extends AbstractController {
    public TableView<CarsEntity> carsTable;
    public TableColumn<CarsEntity,String> idColumn;
    public TableColumn<CarsEntity,String> modelColumn;
    public TableColumn<CarsEntity,String> yearColumn;
    public TableColumn<CarsEntity,String> runColumn;
    public TableColumn<CarsEntity,String> stateColumn;


    @FXML
    private void initialize(){
        idColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getId())));

        modelColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getModel()));

        yearColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getYear())));

        runColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(String.valueOf(cellData.getValue().getRun())));

        stateColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty( cellData.getValue().getState()));



        ObservableList<CarsEntity> list = FXCollections.observableArrayList();
        list.addAll(server.getCars());

        carsTable.setItems(list);

    }


}
