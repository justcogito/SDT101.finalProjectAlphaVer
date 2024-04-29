package SDT101.finalProject.registers.prices;

import SDT101.finalProject.registers.RegisterEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RegisterPrices  {

    private ArrayList<RegisterEntry> prices = new ArrayList<>();

    public RegisterPrices() {
        importPrices();
    }

    private void importPrices() {
        prices.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("prices"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int ownerId = Integer.parseInt(parts[0]);
                float price = Float.parseFloat(parts[1]);
                RegisterEntry entry = new Price(ownerId, price);
                prices.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RegisterEntry> getPrices() {
        return prices;
    }

}
