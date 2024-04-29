package SDT101.finalProject.catalogs.offers;

import SDT101.finalProject.GlobalContext;
import SDT101.finalProject.enumerations.classes.MeasurementUnit;
import SDT101.finalProject.enumerations.classes.OfferType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Offers {

    private ArrayList<Offer> offers = new ArrayList<>();

    public Offers() {
        importOffers();
    }

    public void importOffers() {
        offers.clear();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("offers"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s*;\\s*");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int offerTypeId = Integer.parseInt(parts[2]);
                OfferType offerType = GlobalContext.enumerations.getOfferTypeById(offerTypeId);
                int articleNumber = Integer.parseInt(parts[3]);
                MeasurementUnit measurementUnit = GlobalContext.enumerations.getMeasurementUnitById(Integer.parseInt(parts[4]));
                int taxGroupNumber = Integer.parseInt(parts[5]);

                Offer offer = null;

                if (offerTypeId == 1) {
                    offer = new Item(
                            id,
                            name,
                            offerType,
                            articleNumber,
                            measurementUnit,
                            taxGroupNumber);

                } else if (offerTypeId == 2) {
                    offer = new Service(
                            id,
                            name,
                            offerType,
                            articleNumber,
                            measurementUnit,
                            taxGroupNumber);
                }

                offers.add(offer);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

}
