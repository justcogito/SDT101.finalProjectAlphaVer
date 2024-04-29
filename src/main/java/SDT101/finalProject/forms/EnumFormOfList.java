package SDT101.finalProject.forms;

import SDT101.finalProject.enumerations.classes.Enumeration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EnumFormOfList {
    private ArrayList<Enumeration> enumerations;

    public EnumFormOfList(ArrayList<Enumeration> enumerations) {
        this.enumerations = enumerations;
    }

    public void start(Stage stage) {
        ObservableList<Enumeration> observableList = FXCollections.observableArrayList(enumerations);
        ListView<Enumeration> listView = new ListView<>(observableList);

        Scene scene = new Scene(listView, 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}