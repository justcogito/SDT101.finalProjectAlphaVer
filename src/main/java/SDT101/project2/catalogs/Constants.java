package SDT101.project2.catalogs;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final String SOME_CONSTANT = "SomeValue";
    public static final int ANOTHER_CONSTANT = 123;

    public static final int storeId = 31;
    public static final int cashDeskId = 4;

    private static final Map<Integer, String> receiptTypes;

    static {
        receiptTypes = new HashMap<>();
        receiptTypes.put(1, "Sell");
        receiptTypes.put(2, "Refund");
    }


    public static String getReceiptType(Integer key) {
        return receiptTypes.get(key);
    }







    // add more constants as needed
}