package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.entities.UsersEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by evdodima on 25/05/16.
 * 11-402
 */
public class TableController extends AbstractController {


    public TableView<UsersEntity> sampleTable;
    public TableColumn<UsersEntity,String> column1;
    public TableColumn<UsersEntity,String> column2;
    public TableColumn<UsersEntity,String> column3;

    @FXML
    private void initialize(){
        column1.setCellValueFactory(cellData -> cellData.getValue().getLogin());
        column2.setCellValueFactory(cellData -> cellData.getValue().getLogin());
        column3.setCellValueFactory(cellData -> cellData.getValue().getLogin());

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin("GHGEG");

        ObservableList<UsersEntity> list = FXCollections.observableArrayList();

        list.add(usersEntity);



        sampleTable.setItems(list);

    }
}
