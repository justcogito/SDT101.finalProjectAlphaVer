package SDT101.project2.catalogs;

import SDT101.project2.classes.MeasurementUnit;
import SDT101.project2.classes.Offer;
import SDT101.project2.enumerations.OfferType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Offers {

    private static ArrayList<Offer> offers = new ArrayList<Offer>();

    public static void importOffers() {
        offers.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("offers"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                OfferType offerType = OfferType.getById(Integer.parseInt(parts[1]));
                String name = parts[2];
                int articleNumber = Integer.parseInt(parts[3]);
                MeasurementUnit measurementUnit = MeasurementUnits.getMeasurementById(Integer.parseInt(parts[4]));
                int taxGroupNumber = Integer.parseInt(parts[5]);
                float taxRate = Float.parseFloat(parts[6]);
                Offer offer = new Offer(id, name, articleNumber, measurementUnit, taxGroupNumber, taxRate);
                offers.add(offer);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Offer> getOffers() {
        return offers;
    }

}
