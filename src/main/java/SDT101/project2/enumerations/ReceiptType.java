package SDT101.project2.enumerations;

public enum ReceiptType {

    SALE(1, "Sell", "Sale"),
    REFUND(2, "Refund", "Return");

    private final int id;
    private final String name;
    private final String description;

    ReceiptType(int id, String name, String description) {
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

