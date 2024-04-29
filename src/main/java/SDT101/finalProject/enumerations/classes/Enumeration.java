package SDT101.finalProject.enumerations.classes;

public abstract class Enumeration {

    private int id;
    private String name;
    private String description;

    Enumeration(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

}
