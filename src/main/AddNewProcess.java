package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewProcess {
    public TextField command;
    public Button addButton;

    @FXML
    public void addNew(ActionEvent actionEvent) throws IOException {
        //Main.data.add(new Item(this.inputName.getText(), this.inputCPU.getText(), this.inputMemory.getText(), this.inputNetwork.getText()));
        
        ProcessBuilder builder = new ProcessBuilder(this.command.getText());
        builder.start();

        Main.dataInit();
        command.clear();

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }
}
