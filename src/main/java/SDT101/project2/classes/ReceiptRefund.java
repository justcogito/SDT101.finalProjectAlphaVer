package SDT101.project2.classes;

import SDT101.project2.enumerations.PayType;
import SDT101.project2.enumerations.ReceiptType;

public class ReceiptRefund extends Receipt {

    boolean isRefund;

//  Method overriding demonstration:
    @Override
    public void printInfoBoutClass() {
        System.out.println("This class is a subclass of the Receipt class and is used to handle refunds.");
    }

//  Inheritance demonstration:
    public void printReceiptInfo() {

        super.printReceipt();

        // Accessing the protected variable of the superclass
        System.out.printf("Id is: " + String.valueOf(this.id));

    }

    //  Call of superclass constructor demonstration:
    public ReceiptRefund(ReceiptType receiptType, PayType payType, Boolean isRefund) {
        super(receiptType, payType);
        this.isRefund = isRefund;
    }

}
