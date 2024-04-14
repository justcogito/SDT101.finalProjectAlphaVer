package SDT101.project2.catalogs;

import SDT101.project2.classes.Barcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Barcodes {

    private static ArrayList<Barcode> barcodes = new ArrayList<Barcode>();

    {
//        importBarcodes();
    }

    public static void importBarcodes() {
        barcodes.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("barcodes"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int ownerId = Integer.parseInt(parts[0]);
                String barcode = parts[1];
                Barcode Barcode = new Barcode(ownerId, barcode);
                barcodes.add(Barcode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Barcode> getBarcodes() {
        return barcodes;
    }

}
