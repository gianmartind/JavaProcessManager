package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Item;

import java.util.Optional;

public class Main extends Application {
    HBox mainView;
    VBox root;
    Label topLabel;
    static TableView<Item> mainTable;
    AnchorPane controlTab;
    static ObservableList<Item> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //this.mainView = FXMLLoader.load(getClass().getResource("fxml/MainView.fxml"));
        this.root = FXMLLoader.load(getClass().getResource("fxml/MainContainer.fxml"));
        this.topLabel = FXMLLoader.load(getClass().getResource("fxml/TopLabel.fxml"));
        this.mainTable = FXMLLoader.load(getClass().getResource("fxml/MainTable.fxml"));
        this.controlTab = FXMLLoader.load(getClass().getResource("fxml/ControlTab.fxml"));

        dataInit();

        this.mainTable.setItems(data);

        this.mainView.getChildren().addAll(this.root);
        this.root.getChildren().addAll(this.topLabel, this.mainTable, this.controlTab);

        primaryStage.setTitle("Java Process Manager");
        //primaryStage.setMaxHeight(540);
        primaryStage.setScene(new Scene(this.root));
        primaryStage.setOnHidden(event -> Platform.exit());
        primaryStage.show();
    }

    public static void dataInit(){
        data.clear();
        ProcessHandle.allProcesses().forEach(process -> dataInsert(process));
    }

    public static void dataInsert(ProcessHandle process){
        data.add(new Item(process.pid(), text(process.info().totalCpuDuration()), text(process.info().user()), text(process.info().startInstant()), text(process.info().command())));
    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
