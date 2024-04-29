package SDT101.finalProject.registers.prices;

import SDT101.finalProject.registers.RegisterEntry;

public class Price extends RegisterEntry {

    private float price;

    public Price(int ownerId, float price) {
        super(ownerId);
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

}
