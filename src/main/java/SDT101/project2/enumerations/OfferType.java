package SDT101.project2.enumerations;

public enum OfferType {

    ITEM(1, "Item", "Item"),
    SERVICE(2, "Service", "Service");

    private final int id;
    private final String name;
    private final String description;

    OfferType(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static OfferType getById(int id) {
        for (OfferType offerType : values()) {
            if (offerType.getId() == id) {
                return offerType;
            }
        }
        return null; // or throw an exception
    }

}

