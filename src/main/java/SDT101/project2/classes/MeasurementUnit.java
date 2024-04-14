package SDT101.project2.classes;

public class MeasurementUnit {

    public int id;
    public String name;
    public String abbreviation;

    public MeasurementUnit(int id, String name, String abbreviation) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String printFullInfo() {
        return "ID: " + id + ", name: " + name + ", abbrv: " + abbreviation;
    }

    @Override
    public String toString() {
        return "(" + abbreviation + ")";
    }

}
