package SDT101.finalProject.documents.receipt;

import SDT101.finalProject.enumerations.classes.PayType;
import SDT101.finalProject.enumerations.classes.MeasurementUnit;
import SDT101.finalProject.enumerations.classes.ReceiptType;

public class ReceiptSale extends Receipt {

//  Method overriding demonstration:
    @Override
    public void printInfoBoutClass() {
        System.out.println("This class is a subclass of the Receipt class and is used to handle sales.");
    }

//  Inheritance demonstration:
    public void printReceiptInfo() {

        super.printReceipt();

        // Accessing the protected variable of the superclass
        System.out.printf("Id is: " + String.valueOf(this.id));

    }

    //  Call of superclass constructor demonstration:
    public ReceiptSale(ReceiptType receiptType, PayType payType, Boolean isRefund) {
        super(receiptType, payType);
        this.isRefund = isRefund;
    }

}
