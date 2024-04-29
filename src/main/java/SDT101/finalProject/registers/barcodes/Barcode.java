package SDT101.finalProject.registers.barcodes;

import SDT101.finalProject.registers.RegisterEntry;

public class Barcode extends RegisterEntry {

    public String barcode;

    public Barcode(int ownerId, String barcode) {
        super(ownerId);
        this.barcode = barcode;
    }

    private static String getOwnerRepresentation(int ownerId) {
        return "Barcode";
    }

    public String getBarcode() {

        return barcode;

    }

}
