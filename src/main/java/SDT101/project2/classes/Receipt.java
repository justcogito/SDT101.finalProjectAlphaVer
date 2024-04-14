package SDT101.project2.classes;

import SDT101.project2.catalogs.Constants;
import SDT101.project2.enumerations.PayType;
import SDT101.project2.enumerations.ReceiptType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;


// Abstract class
public abstract class Receipt {

    private static int lastId = 0;

    protected int id;
    protected String dateOpen;
    protected String dateClose;
    protected ReceiptType receiptType;
    protected int storeId;
    protected int cashDeskId;
    protected PayType payType;
    protected float total;
    protected float tax;
    protected float payTotal;
    protected float change;
    protected ReceiptTableOfContents tableOfContents;

    public Receipt(ReceiptType receiptType, PayType payType) {
        this.id = ++lastId;
        this.dateOpen = getCurrentDateTime();
        this.storeId = Constants.storeId;
        this.cashDeskId = Constants.cashDeskId;
        this.tableOfContents = new ReceiptTableOfContents();
        this.receiptType = receiptType;
        this.payType = payType;
    }

    public void setDateClose() {
        this.dateClose = getCurrentDateTime();
    }

    public void setReceiptType(ReceiptType receiptType) {
        this.receiptType = receiptType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public void setTableOfContents(ReceiptTableOfContents tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public void printReceipt() {

        System.out.println("Receipt ID: " + id);
        System.out.println("Date Open: " + dateOpen);
        System.out.println("Date Close: " + dateClose);
        System.out.println("Receipt Type: " + receiptType);
        System.out.println("Store ID: " + storeId);
        System.out.println("Cash Desk ID: " + cashDeskId);
        System.out.println("Pay Type: " + payType);
        System.out.println("Total: " + total);
        System.out.println("Tax: " + tax);
        System.out.println("Pay Total: " + payTotal);
        System.out.println("Change: " + change);

        tableOfContents.printTableOfContents();

    }

    private String getCurrentDateTime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return LocalDateTime.now().format(dtf);

    }

    public void calculateTotals() {

        total = tableOfContents.total;
        tax = tableOfContents.tax;
        change = payTotal - total - tax;

    }

    public float getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(float payTotal) {
        this.payTotal = payTotal;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public int getId() {
        return id;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public String getDateClose() {
        return dateClose;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public int getStoreId() {
        return storeId;
    }

    public int getCashDeskId() {
        return cashDeskId;
    }

    public PayType getPayType() {
        return payType;
    }

    public float getTotal() {
        return total;
    }

    public float getTax() {
        return tax;
    }

    public float getChange() {
        return change;
    }

    public abstract void printInfoBoutClass();

    public abstract void printReceiptInfo();
}


