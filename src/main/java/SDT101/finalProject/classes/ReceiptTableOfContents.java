package SDT101.finalProject.classes;

import java.util.ArrayList;

public class ReceiptTableOfContents {

    public ArrayList<TableOfContentsRow> tableOfContents = new ArrayList<TableOfContentsRow>();

    public float total;
    public float tax;

    public void addRow(TableOfContentsRow row) {
        tableOfContents.add(row);
        reCalculateFields();
    }



    private void reCalculateFields() {

        total = 0;
        tax = 0;

        for (TableOfContentsRow row : tableOfContents) {
            total += row.total;
            tax += row.tax;
        }
    }

    public void printTableOfContents() {
        for (TableOfContentsRow row : tableOfContents) {
//            System.out.println("Offer: " + row.offer.getName());
            System.out.println("Quantity: " + row.quantity);
            System.out.println("Price: " + row.price);
            System.out.println("Total: " + row.total);
            System.out.println("Tax: " + row.tax);
        }
    }

}
