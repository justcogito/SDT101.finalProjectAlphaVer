package SDT101.finalProject.registers.barcodes;

import SDT101.finalProject.registers.RegisterEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterBarcodes {

    private ArrayList<RegisterEntry> barcodes = new ArrayList<>();

    public RegisterBarcodes() {
        importBarcodes();
    }

    private void importBarcodes() {
        barcodes.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("barcodes"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int ownerId = Integer.parseInt(parts[0]);
                String barcode = parts[1];
                RegisterEntry entry = new Barcode(ownerId, barcode);
                barcodes.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RegisterEntry> getBarcodes() {
        return barcodes;
    }

}
