package SDT101.finalProject.documents;

import SDT101.finalProject.documents.receipt.Receipt;

import java.io.FileWriter;
import java.io.IOException;
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

    public static void writeReceiptsToFile() {
        try (FileWriter writer = new FileWriter("receipts.txt")) {
            for (Receipt receipt : receipts) {
                StringBuilder sb = new StringBuilder();
                sb.append("id: ").append(receipt.getId()).append("; ");
                sb.append("type: ").append(receipt.getReceiptType()).append("; ");
                sb.append("payType: ").append(receipt.getPayType()).append("; ");
                sb.append("isRefund: ").append(receipt.isRefund()).append("; ");
                sb.append("dateClose: ").append(receipt.getDateClose()).append("; ");
                sb.append("payTotal: ").append(receipt.getPayTotal()).append("; ");
    //            sb.append("totals: ").append(receipt.getTotals()).append("; ");
                writer.write(sb.toString().trim() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

}
