package SDT101.finalProject.catalogs.offers;

import SDT101.finalProject.enumerations.classes.MeasurementUnit;
import SDT101.finalProject.enumerations.classes.OfferType;

public class Item extends Offer {

    public Item(int id, String name, OfferType offerType, int articleNumber, MeasurementUnit measurementUnit, int taxGroupNumber) {
        super(
                id,
                name,
                offerType,
                articleNumber,
                measurementUnit,
                taxGroupNumber);
    }

}
