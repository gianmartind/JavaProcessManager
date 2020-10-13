package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlTabController {

    public void newProcess(ActionEvent actionEvent) {
        try {
            VBox newWindow = FXMLLoader.load(getClass().getResource("fxml/AddNewProcess.fxml"));
            Scene scene = new Scene(newWindow);
            Stage stage = new Stage();
            stage.setTitle("Add New");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

    public void refresh(ActionEvent actionEvent) {
        Main.dataInit();
    }

    /*
    public void removeSelected(ActionEvent actionEvent) {
        Main.mainTable.getItems().removeAll(Main.mainTable.getSelectionModel().getSelectedItem());
    }
     */
}
