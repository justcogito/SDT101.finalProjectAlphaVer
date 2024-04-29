package SDT101.finalProject.catalogs.offers;

import SDT101.finalProject.enumerations.classes.MeasurementUnit;
import SDT101.finalProject.enumerations.classes.OfferType;

public abstract class Offer {

    private final int id;
    private final String name;
    private final String representation;
    private final OfferType offerType;
    private final int articleNumber;
    private final MeasurementUnit measurementUnit;
    private final int taxGroupNumber;

    public Offer(int id, String name, OfferType offerType, int articleNumber, MeasurementUnit measurementUnit, int taxGroupNumber) {
        this.id = id;
        this.name = name;
        this.representation = name;
        this.offerType = offerType;
        this.articleNumber = articleNumber;
        this.measurementUnit = measurementUnit;
        this.taxGroupNumber = taxGroupNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return representation;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public int getTaxGroupNumber() {
        return taxGroupNumber;
    }
}