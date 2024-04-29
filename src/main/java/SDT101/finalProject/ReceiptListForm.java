package SDT101.finalProject;

import SDT101.finalProject.documents.receipt.Receipt;
import SDT101.finalProject.documents.Receipts;
import SDT101.finalProject.enumerations.classes.PayType;
import SDT101.finalProject.enumerations.classes.MeasurementUnit;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReceiptListForm extends Application {

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        TableView<Receipt> receiptTable = new TableView<>();

        // Define columns
        TableColumn<Receipt, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Receipt, String> dateOpenColumn = new TableColumn<>("Date Open");
        dateOpenColumn.setCellValueFactory(new PropertyValueFactory<>("dateOpen"));

        TableColumn<Receipt, String> dateCloseColumn = new TableColumn<>("Date Close");
        dateCloseColumn.setCellValueFactory(new PropertyValueFactory<>("dateClose"));

        TableColumn<Receipt, MeasurementUnit> receiptTypeColumn = new TableColumn<>("Receipt Type");
        receiptTypeColumn.setCellValueFactory(new PropertyValueFactory<>("receiptType"));

        TableColumn<Receipt, PayType> payTypeColumn = new TableColumn<>("Pay Type");
        payTypeColumn.setCellValueFactory(new PropertyValueFactory<>("payType"));

        TableColumn<Receipt, Float> totalColumn = new TableColumn<>("Total");
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        TableColumn<Receipt, Float> taxColumn = new TableColumn<>("Tax");
        taxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));

        TableColumn<Receipt, Float> payTotalColumn = new TableColumn<>("Pay Total");
        payTotalColumn.setCellValueFactory(new PropertyValueFactory<>("payTotal"));

        TableColumn<Receipt, Float> changeColumn = new TableColumn<>("Change");
        changeColumn.setCellValueFactory(new PropertyValueFactory<>("change"));

        // Add columns to table
        receiptTable.getColumns().setAll(idColumn, dateOpenColumn, dateCloseColumn, receiptTypeColumn, payTypeColumn, totalColumn, taxColumn, payTotalColumn, changeColumn);

        // Get Receipt objects and add them to the table
        ObservableList<Receipt> data = FXCollections.observableArrayList(Receipts.getReceipts());
        receiptTable.setItems(data);

        root.getChildren().add(receiptTable);

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Receipt Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}