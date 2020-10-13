package main;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import model.Item;

public class MainTableController {

    @FXML
    public TableColumn colPid;
    public TableColumn colCPU;
    public TableColumn colUser;
    public TableColumn colStartInstant;
    public TableColumn colCmd;

    @FXML
    private void initialize(){
        this.colPid.setCellValueFactory(new PropertyValueFactory<Item, Long>("Pid"));

        this.colCPU.setCellValueFactory(new PropertyValueFactory<Item, String>("CPU"));
        this.colCPU.setCellFactory(TextFieldTableCell.forTableColumn());

        this.colUser.setCellValueFactory(new PropertyValueFactory<Item, String>("User"));
        this.colUser.setCellFactory(TextFieldTableCell.forTableColumn());

        this.colStartInstant.setCellValueFactory(new PropertyValueFactory<Item, String>("StartInstant"));
        this.colStartInstant.setCellFactory(TextFieldTableCell.forTableColumn());

        this.colCmd.setCellValueFactory(new PropertyValueFactory<Item, String>("Cmd"));
        this.colCmd.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void refresh(MouseEvent mouseEvent) {
        Main.dataInit();
    }
}
