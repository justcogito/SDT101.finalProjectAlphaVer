package SDT101.project2.documents;

import SDT101.project2.classes.MeasurementUnit;
import SDT101.project2.classes.Receipt;

import java.util.ArrayList;

public class Receipts {

    private static ArrayList<Receipt> receipts = new ArrayList<Receipt>();

    public static ArrayList<Receipt> getReceipts() {
        return receipts;
    }

    public static Receipt getReceiptsById(int id) {
        for (Receipt receipt : receipts) {
            if (receipt.getId() == id) {
                return receipt;
            }
        }
        return null;
    }

    public static void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

}
