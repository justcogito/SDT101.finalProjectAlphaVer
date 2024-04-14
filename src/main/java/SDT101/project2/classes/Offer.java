package SDT101.project2.classes;

public class Offer {

    private int id;
    private String name;
    private int articleNumber;
    private MeasurementUnit measurementUnit;
    private int taxGroupNumber;
    private float taxRate;

    public Offer() {
        this.id = id;
        this.name = name;
        this.articleNumber = articleNumber;
        this.measurementUnit = measurementUnit;
        this.taxGroupNumber = taxGroupNumber;
        this.taxRate = taxRate;
    }

    public Offer(int id, String name, int articleNumber, MeasurementUnit measurementUnit, int taxGroupNumber, float taxRate) {
        this.id = id;
        this.name = name;
        this.articleNumber = articleNumber;
        this.measurementUnit = measurementUnit;
        this.taxGroupNumber = taxGroupNumber;
        this.taxRate = taxRate;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public MeasurementUnit getMeasurement_unit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurement_unit) {
        this.measurementUnit = measurement_unit;
    }

    public int getTaxGroupNumber() {
        return taxGroupNumber;
    }

    public void setTaxGroupNumber(int taxGroupNumber) {
        this.taxGroupNumber = taxGroupNumber;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }



}