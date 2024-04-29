package SDT101.finalProject.catalogs.forms;

import SDT101.finalProject.GlobalContext;

import SDT101.finalProject.catalogs.offers.Offer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Field;

public class OffersFormList {

    private ObservableList<Offer> data;
    private String catalogName;

    public OffersFormList() {
        this.catalogName = catalogName;
        this.data = FXCollections.observableArrayList(GlobalContext.offers);

    }

    public void start(Stage stage) {
        TableView<Offer> table = new TableView<>();

        Field[] fields = Offer.class.getDeclaredFields();
        for (Field field : fields) {
            TableColumn<Offer, ?> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            table.getColumns().add(column);
        }

        table.setItems(data);

        VBox root = new VBox(table);
        Scene scene = new Scene(root, 300, 200);

        stage.setScene(scene);
        stage.show();
    }
}