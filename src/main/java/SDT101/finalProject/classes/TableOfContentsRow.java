package SDT101.finalProject.classes;

import SDT101.finalProject.catalogs.offers.Offer;

public class TableOfContentsRow {

    public Offer offer;
    public float quantity;
    public float price;
    public float total;
    public float tax;

    public TableOfContentsRow(Offer offer, float quantity, float price) {
        this.offer = offer;
        this.quantity = quantity;
        this.price = price;
        calculateFields();
    }

    private void calculateFields() {
//        float taxRate = offer.getTaxRate();
        this.total = this.price * this.quantity;
        this.total = Math.round(this.total * 100.0f) / 100.0f;
//        this.tax = this.total / 100.0f * taxRate;
        this.tax = Math.round(this.tax * 100.0f) / 100.0f;

    }

    public TableOfContentsRow getTableOfContentsRow() {
        return this;
    }

    public Offer getOffer() {
        return offer;
    }

    public float getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public float getTotal() {
        return total;
    }

    public float getTax() {
        return tax;
    }

//    public String getOfferName() {
//        return offer.getName();
//    }

}


