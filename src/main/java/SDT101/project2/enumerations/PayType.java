package SDT101.project2.enumerations;

public enum PayType {

    CASH(1, "Cash", "Cash"),
    CARD(2, "Card", "Card");

    private final int id;
    private final String name;
    private final String description;

    PayType(int id, String name, String description) {
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

}

