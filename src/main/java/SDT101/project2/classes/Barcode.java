package SDT101.project2.classes;

public class Barcode {

    public int ownerId;
    public String barcode;

    public Barcode(int ownerId, String barcode) {
        this.ownerId = ownerId;
        this.barcode = barcode;
    }

    public String printFullInfo() {
        return "Owner ID: " + ownerId + ", barcode: " + barcode;
    }



}
