package SDT101.finalProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import SDT101.finalProject.catalogs.forms.OffersFormList;
import SDT101.finalProject.catalogs.offers.Offer;
import SDT101.finalProject.classes.*;
import SDT101.finalProject.documents.Receipts;
import SDT101.finalProject.documents.receipt.Receipt;
import SDT101.finalProject.documents.receipt.ReceiptSale;
import SDT101.finalProject.enumerations.classes.Enumeration;
import SDT101.finalProject.forms.EnumFormOfList;
import SDT101.finalProject.registers.RegisterEntry;
import SDT101.finalProject.registers.barcodes.Barcode;
import SDT101.finalProject.registers.forms.RegisterFormOfList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static SDT101.finalProject.GlobalContext.*;

public class MainApplication extends Application {

    private HashMap<String, Stage> openedForms = new HashMap<>();

    VBox root = new VBox();
    TextField textFieldSearch = new TextField();
    TableView<TableOfContentsRow> tableOfContents = new TableView<>();

    @Override
    public void start(Stage stage) throws IOException {

        setOnCloseRequest(stage);

        addAllElementsOfForm();

        Scene scene = new Scene(root, 1024, 500);

        stage.setTitle("Cashier workstation");
        stage.setScene(scene);
        stage.show();
    }

    private void setOnCloseRequest(Stage stage) {

        stage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Close Application");
            alert.setContentText("Are you sure you want to close the application?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                List<Stage> stagesToClose = new ArrayList<>(openedForms.values());
                for (Stage s : stagesToClose) {
                    s.close();
                }
            } else {
                event.consume();
            }
        });
    }

    private void addAllElementsOfForm() {

        addFieldLabelSearch();
        addFieldSearch();

        addTableOfContents();

        addButtonFinalize();

        addButtonOpenReceiptList();

        addButtonWriteReceiptsToFile();

        addButtonsToOpenForms();

    }

    private void addFieldLabelSearch() {

        Label labelSearch = new Label("Search");
        textFieldSearch.setOnAction(e -> {
            search(textFieldSearch.getText());
        });
        root.getChildren().add(labelSearch);

    }

    private void addFieldSearch() {

        root.getChildren().add(textFieldSearch);

    }

    private void addTableOfContents() {

        tableOfContents.setPlaceholder(new Label(""));

        TableColumn<TableOfContentsRow, String> columnOffers = new TableColumn<>("Offer");
        columnOffers.setCellValueFactory(new PropertyValueFactory<>("offerName"));

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

        root.getChildren().add(tableOfContents);

    }

    private void addButtonFinalize() {

        Button buttonFinalize = new Button("Finalize");
        buttonFinalize.setOnAction(e -> {
            finalizeReceipt();
        });

    }

    private void addButtonOpenReceiptList() {

        Button openReceiptList = new Button("Open Receipt List");
        openReceiptList.setOnAction(e -> {
            ReceiptListForm receiptListForm = new ReceiptListForm();
            receiptListForm.start(new Stage());
        });

    }

    private void addButtonWriteReceiptsToFile() {

        Button buttonWriteReceiptsToFile = new Button("Write receipts to a file");
        buttonWriteReceiptsToFile.setOnAction(e -> {
            Receipts.writeReceiptsToFile();
        });

    }

    private void addButtonsToOpenForms() {

        addButtonToOpenRegisterFormOfList("Open register of Barcodes",
                "Register of Barcodes", "RegisterBarcodes");
        addButtonToOpenRegisterFormOfList("Open register of Prices",
                "Register of Prices", "RegisterPrices");
        addButtonToOpenCatalogFormOfList("Open catalog of Offers",
                "Catalog of Offers", "CatalogOffers");
        addButtonToOpenEumFormOfList("Open enumeration of Offer Types",
                "Enumeration of Offer Types", "EnumOfferTypes");
        addButtonToOpenEumFormOfList("Open enumeration of Measurement Unit",
                "Enumeration of Pay Types", "EnumPayTypes");
        addButtonToOpenEumFormOfList("Open enumeration of Measurement Unit",
                "Enumeration of Measurement Units", "EnumMeasurementUnits");

    }

    private void addButtonToOpenCatalogFormOfList(String buttonName, String title, String catalogName) {

        Button buttonOpenForm = new Button(buttonName);
        buttonOpenForm.setOnAction(e -> {
            if (!openedForms.containsKey(title)) {
                OffersFormList form = new OffersFormList();
                Stage newStage = new Stage();
                newStage.setTitle(title);
                form.start(newStage);
                openedForms.put(title, newStage);
                newStage.setOnHidden(event -> openedForms.remove(title));
            } else {
                openedForms.get(title).toFront();
            }
        });

        root.getChildren().add(buttonOpenForm);

    }

    private void addButtonToOpenRegisterFormOfList(String buttonName, String title, String registerName) {

        Button buttonOpenForm = new Button(buttonName);
        buttonOpenForm.setOnAction(e -> {
            if (!openedForms.containsKey(title)) {
                RegisterFormOfList form = new RegisterFormOfList(registerName);
                Stage newStage = new Stage();
                newStage.setTitle(title);
                form.start(newStage);
                openedForms.put(title, newStage);
                newStage.setOnHidden(event -> openedForms.remove(title));
            } else {
                openedForms.get(title).toFront();
            }

        });

        root.getChildren().add(buttonOpenForm);

    }

    private void addButtonToOpenEumFormOfList(String buttonName, String title, String enumName) {

        Button buttonOpenForm = new Button(buttonName);
        buttonOpenForm.setOnAction(e -> {
            if (!openedForms.containsKey(title)) {
                EnumFormOfList offerTypesList = new EnumFormOfList((ArrayList<Enumeration>) GlobalContext.getListByName(enumName));
                Stage newStage = new Stage();
                newStage.setTitle(title);
                offerTypesList.start(newStage);
                openedForms.put(title, newStage);
                newStage.setOnHidden(event -> openedForms.remove(title));
            } else {
                openedForms.get(title).toFront();
            }
        });

        root.getChildren().add(buttonOpenForm);

    }

    private void finalizeReceipt() {

        Receipt receipt = new ReceiptSale(
                enumerations.getReceiptTypeById(1),
                enumerations.getPayTypeById(1),
                false);
        receipt.setDateClose();

        ReceiptTableOfContents receiptTableOfContents = new ReceiptTableOfContents();
        for (TableOfContentsRow row : tableOfContents.getItems()) {
            receiptTableOfContents.addRow(row);
        }

        receipt.setTableOfContents(receiptTableOfContents);

        receipt.setPayTotal(1500f);
        receipt.calculateTotals();

//        receipt.printReceipt();
        receipt.printInfoBoutClass();
        //      receipt.printReceiptInfo();

        Receipts.addReceipt(receipt);

        tableOfContents.getItems().clear();
        textFieldSearch.clear();

    }

    private void search(String text) {

//        offer = searchByArticleNumber(text);
        Offer offer = searchByBarcode(text);
        if (offer != null) {
//            ObservableList<TableOfContentsRow> data = tableOfContents.getItems();
//            if (data == null) {
//                data = FXCollections.observableArrayList();
//                tableOfContents.setItems(data);
//            }
//            data.add(new TableOfContentsRow(offer, 3, 100.50f));
        } else {
            showAlert("Nothing found!");
        }
    }

    private Offer searchByBarcode(String text) {

        for (RegisterEntry entry : registerBarcodes) {
            if (entry instanceof Barcode) {
                Barcode barcodeEntry = (Barcode) entry;
                if (barcodeEntry.getBarcode().equals(text)) {
                    Offer offer = getOfferById(barcodeEntry.getOwnerId());
                    return offer;
                }
            }
        }
        return null;

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


    public void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Attention!");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
