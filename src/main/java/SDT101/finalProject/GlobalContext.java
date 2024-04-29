package SDT101.finalProject;

import SDT101.finalProject.catalogs.offers.Offer;
import SDT101.finalProject.catalogs.offers.Offers;
import SDT101.finalProject.enumerations.classes.Enumeration;
import SDT101.finalProject.enumerations.Enumerations;
import SDT101.finalProject.registers.RegisterEntry;
import SDT101.finalProject.registers.barcodes.RegisterBarcodes;
import SDT101.finalProject.registers.prices.RegisterPrices;

import java.util.ArrayList;

public class GlobalContext {

    private static GlobalContext instance = null;

    public static final Enumerations enumerations = new Enumerations();
    public static final ArrayList<Enumeration> enumOfferTypes = enumerations.getOfferTypes();
    public static final ArrayList<Enumeration> enumPayTypes = enumerations.getPayTypesTypes();
    public static final ArrayList<Enumeration> enumMeasurementUnits = enumerations.getMeasurementUnits();

    public static ArrayList<RegisterEntry> registerBarcodes = new RegisterBarcodes().getBarcodes();
    public static ArrayList<RegisterEntry> registerPrices = new RegisterPrices().getPrices();
    public static ArrayList<Offer> offers = new Offers().getOffers();


    private GlobalContext() {
        // private constructor to restrict new instances
    }

    public static ArrayList<?> getListByName(String listName) {
        if (listName.equals("RegisterBarcodes")) {
            return registerBarcodes;
        } else if (listName.equals("RegisterPrices")) {
            return registerPrices;
        } else if (listName.equals("Offers")) {
            return offers;
        } else if (listName.equals("EnumOfferTypes")) {
            return enumOfferTypes;
        } else if (listName.equals("EnumPayTypes")) {
            return enumPayTypes;
        } else if (listName.equals("EnumMeasurementUnits")) {
            return enumMeasurementUnits;
        } else {
            return null;
        }
    }


}
