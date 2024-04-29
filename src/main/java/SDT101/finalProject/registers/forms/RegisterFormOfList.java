package SDT101.finalProject.registers.forms;

import SDT101.finalProject.GlobalContext;
import SDT101.finalProject.registers.barcodes.Barcode;
import SDT101.finalProject.registers.prices.Price;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class RegisterFormOfList {

    private ObservableList<?> data;
    private String registerName;

    public RegisterFormOfList(String registerName) {
        this.registerName = registerName;
        switch (registerName) {
            case "RegisterBarcodes":
                this.data = FXCollections.observableArrayList(GlobalContext.registerBarcodes);
                break;
            case "RegisterPrices":
                this.data = FXCollections.observableArrayList(GlobalContext.registerPrices);
                break;
            default:
                throw new IllegalArgumentException("Invalid register name: " + registerName);
        }
    }

    public void start(Stage stage) {
        TableView<Object> table = new TableView<>();

        Field[] fields = data.get(0).getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("reference")) {
                TableColumn<Object, ?> column = new TableColumn<>(field.getName());
                column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
                table.getColumns().add(column);
            }
        }

//        // Add reference column if the data is of type Barcode or Price
//        if (data.get(0) instanceof Barcode || data.get(0) instanceof Price) {
//            TableColumn<Object, String> referenceColumn = getObjectStringTableColumn();
//            table.getColumns().add(referenceColumn);
//        }

        table.setItems((ObservableList<Object>) data);

        VBox root = new VBox(table);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private static TableColumn<Object, String> getObjectStringTableColumn() {
        TableColumn<Object, String> referenceColumn = new TableColumn<>("Reference");
        referenceColumn.setCellValueFactory(cellData -> {
            if (cellData.getValue() instanceof Barcode) {
                Barcode barcode = (Barcode) cellData.getValue();
                Barcode reference = (Barcode) barcode.getReference(barcode.getOwnerId());
                return new SimpleStringProperty(reference.toString());
            } else if (cellData.getValue() instanceof Price) {
                Price price = (Price) cellData.getValue();
                Price reference = (Price) price.getReference(price.getOwnerId());
                return new SimpleStringProperty(reference.toString());
            }
            return null;
        });
        return referenceColumn;
    }

}

