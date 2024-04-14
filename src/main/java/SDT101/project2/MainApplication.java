package SDT101.project2;

import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

import SDT101.project2.catalogs.Offers;
import SDT101.project2.classes.*;
import SDT101.project2.catalogs.MeasurementUnits;
import SDT101.project2.catalogs.Barcodes;
import SDT101.project2.documents.Receipts;
import SDT101.project2.enumerations.PayType;
import SDT101.project2.enumerations.ReceiptType;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

    boolean demo = false;

    ArrayList<MeasurementUnit> measurementUnits;
    ArrayList<Barcode> barcodes;
    ArrayList<Offer> offers;

    TableView<TableOfContentsRow> tableOfContents = new TableView<>();

    @Override
    public void start(Stage stage) throws IOException {

        updateCatalogs();

        if (demo) {
            demo();
        }

        VBox root = new VBox();

        Label labelSearch = new Label("Search");

        TextField textFieldSearch = new TextField();
        textFieldSearch.setOnAction(e -> {
            search(textFieldSearch.getText());
        });

        TableColumn<TableOfContentsRow, Offer> columnOffers = new TableColumn<>("Offer");
        columnOffers.setCellValueFactory(new PropertyValueFactory<>("offer"));

        TableColumn<TableOfContentsRow, Float> columnQuantity = new TableColumn<>("Quantity");
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<TableOfContentsRow, Float> columnPrice = new TableColumn<>("Price");
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<TableOfContentsRow, Float> columnTax = new TableColumn<>("Tax");
        columnTax.setCellValueFactory(new PropertyValueFactory<>("tax"));

        TableColumn<TableOfContentsRow, Float> columnTotal = new TableColumn<>("Total");
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        tableOfContents.getColumns().add(columnOffers);
        tableOfContents.getColumns().add(columnQuantity);
        tableOfContents.getColumns().add(columnPrice);
        tableOfContents.getColumns().add(columnTax);
        tableOfContents.getColumns().add(columnTotal);

        Button buttonFinalize = new Button("Finalize");
        buttonFinalize.setOnAction(e -> {
            finalizeReceipt();
        });

        TableView<Receipt> receiptTable = new TableView<>();


        Button buttonShowReceipts = new Button("Show receipts");
        buttonShowReceipts.setOnAction(e -> {
            System.out.printf(String.valueOf(Receipts.getReceipts().size()));
            showReceipts(receiptTable);
        });

        root.getChildren().addAll(labelSearch, textFieldSearch, tableOfContents, buttonFinalize, buttonShowReceipts, receiptTable);

        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void showReceipts(TableView<Receipt> receiptTable) {
        // Define columns
        TableColumn<Receipt, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Receipt, String> dateOpenColumn = new TableColumn<>("Date Open");
        dateOpenColumn.setCellValueFactory(new PropertyValueFactory<>("dateOpen"));

        TableColumn<Receipt, String> dateCloseColumn = new TableColumn<>("Date Close");
        dateCloseColumn.setCellValueFactory(new PropertyValueFactory<>("dateClose"));

        TableColumn<Receipt, ReceiptType> receiptTypeColumn = new TableColumn<>("Receipt Type");
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
    }

    private void finalizeReceipt() {

        Receipt receipt = new ReceiptSale(ReceiptType.SALE, PayType.CASH, false);
        receipt.setDateClose();

        ReceiptTableOfContents receiptTableOfContents = new ReceiptTableOfContents();
        for (TableOfContentsRow row : tableOfContents.getItems()) {
            receiptTableOfContents.addRow(row);
        }

        receipt.setTableOfContents(receiptTableOfContents);

        receipt.setPayTotal(1500f);
        receipt.calculateTotals();

        receipt.printReceipt();
        receipt.printInfoBoutClass();
        receipt.printReceiptInfo();

        Receipts.addReceipt(receipt);

    }

    private void search(String text) {

//        offer = searchByArticleNumber(text);
        Offer offer = searchByBarcode(text);
        if (offer != null) {
            ObservableList<TableOfContentsRow> data = tableOfContents.getItems();
            if (data == null) {
                data = FXCollections.observableArrayList();
                tableOfContents.setItems(data);
            }
            data.add(new TableOfContentsRow(offer, 3, 100.50f));
        } else {
            showAlert("Nothing found!");
        }
    }

    private Offer searchByBarcode(String text) {
        Offer offer = null;
        for (Barcode element : barcodes) {
            if (element.barcode.equals(text)) {
                offer = getOfferById(element.ownerId);
                break;
            }
        }
        return offer;
    }

    private Offer getOfferById(int ownerId) {
        Offer offer = null;
        for (Offer element : offers) {
            if (element.getId() == ownerId) {
                offer = element;
                break;
            }
        }
        return offer;
    }

    private void demo() {

        Offer item1 = new Item();
        item1.setTaxRate(20);
//        Offer item2 = new Item();
//        Offer item3 = new Service();

        item1.setId(1);
        item1.setName("Item 1");
        item1.setArticleNumber(123456);
        item1.setMeasurementUnit(measurementUnits.get(1));
//        item1.setPrice(100.50f);
        item1.setTaxGroupNumber(2);
        item1.setTaxRate(20);


//      Creating an instance of the ReceiptSale subclass as the extention on Receipt superclass

        Receipt receipt = new ReceiptSale(ReceiptType.SALE, PayType.CASH, false);
        System.out.printf("Receipt class is: " + receipt.getClass());

        receipt.setDateClose();

        ReceiptTableOfContents tableOfContents = new ReceiptTableOfContents();

        TableOfContentsRow row1 = new TableOfContentsRow(item1, 4f, 125.50f);
        TableOfContentsRow row2 = new TableOfContentsRow(item1, 1f, 64.25f);
        TableOfContentsRow row3 = new TableOfContentsRow(item1, 12.5f, 19.20f);

        receipt.setTableOfContents(tableOfContents);

        tableOfContents.addRow(row1);
        tableOfContents.addRow(row2);
        tableOfContents.addRow(row3);

        receipt.setPayTotal(1500f);
        receipt.calculateTotals();

//        receipt.printReceipt();
        receipt.printInfoBoutClass();
        receipt.printReceiptInfo();

//        String receiptJson = receipt.toJson();
//        try (FileWriter file = new FileWriter("receipt.json")) {
//            file.write(receiptJson);
//            System.out.println("Successfully Copied JSON Object to File...");
//            System.out.println("\nJSON Object: " + receiptJson);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    private void updateCatalogs() {

        updateMeasurementUnits();
        updateBarcodes();
        updateOffers();

    }

    private void updateOffers() {

        Offers.importOffers();
        offers = Offers.getOffers();
    }

    private void updateBarcodes() {

        MeasurementUnits.importMeasurementUnits();
        measurementUnits = MeasurementUnits.getMeasurementUnits();

    }

    private void updateMeasurementUnits() {

        Barcodes.importBarcodes();
        barcodes = Barcodes.getBarcodes();

    }


    public static void main(String[] args) {
        launch();
    }

    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attention!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


//
//        if (!measurementUnits.isEmpty()) {
//        for (MeasurementUnit measurementUnit : measurementUnits) {
//        System.out.println(measurementUnit.printFullInfo());
//        }
//        }
//
//        if (!barcodes.isEmpty()) {
//        for (Barcode barcode : barcodes) {
//        System.out.println(barcode.printFullInfo());
//        }
//        }