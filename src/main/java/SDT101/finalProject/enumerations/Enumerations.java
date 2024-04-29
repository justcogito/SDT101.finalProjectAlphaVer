package SDT101.finalProject.enumerations;

import SDT101.finalProject.enumerations.classes.*;

import java.util.AbstractList;
import java.util.ArrayList;

public class Enumerations {

    private final ArrayList<Enumeration> receiptTypes = new ArrayList<>();
    private final ArrayList<Enumeration> enumOfferTypes = new ArrayList<>();
    private final ArrayList<Enumeration> enumPayTypes = new ArrayList<>();
    private final ArrayList<Enumeration> enumMeasurementUnits = new ArrayList<>();

    public Enumerations() {
        addNumerations();
    }

    private void addNumerations() {

        receiptTypes.add(new OfferType(1, "Sell", "Sell"));
        receiptTypes.add(new OfferType(2, "Refund", "Refund"));

        enumOfferTypes.add(new OfferType(1, "Item", "Item"));
        enumOfferTypes.add(new OfferType(2, "Service", "Service"));

        enumPayTypes.add(new PayType(1, "Cash", "Cash"));
        enumPayTypes.add(new PayType(2, "Card", "Credit Card"));

        enumMeasurementUnits.add(new MeasurementUnit(1, "EA", "Each"));
        enumMeasurementUnits.add(new MeasurementUnit(2, "LB", "Pound"));
        enumMeasurementUnits.add(new MeasurementUnit(3, "OZ", "Ounce"));
        enumMeasurementUnits.add(new MeasurementUnit(4, "DOZ", "Dozen"));
        enumMeasurementUnits.add(new MeasurementUnit(5, "GAL", "Gallon"));
        enumMeasurementUnits.add(new MeasurementUnit(6, "PKG", "Package"));

    }

    public ArrayList<Enumeration> getOfferTypes() {
        return enumOfferTypes;
    }

    public ArrayList<Enumeration> getPayTypesTypes() {
        return enumPayTypes;
    }

    public ArrayList<Enumeration> getMeasurementUnits() {
        return enumMeasurementUnits;
    }

    public ReceiptType getReceiptTypeById(int id) {

        for (Enumeration enumeration : receiptTypes) {
            if (enumeration.getId() == id) {
                return (ReceiptType) enumeration;
            }
        }
        return null;

    }

    public OfferType getOfferTypeById(int id) {

        for (Enumeration enumeration : enumOfferTypes) {
            if (enumeration.getId() == id) {
                return (OfferType) enumeration;
            }
        }
        return null;

    }

    public PayType getPayTypeById(int id) {

        for (Enumeration enumeration : enumPayTypes) {
            if (enumeration.getId() == id) {
                return (PayType) enumeration;
            }
        }
        return null;

    }

    public MeasurementUnit getMeasurementUnitById(int id) {

        for (Enumeration enumeration : enumMeasurementUnits) {
            if (enumeration.getId() == id) {
                return (MeasurementUnit) enumeration;
            }
        }
        return null;
    }

}
