package SDT101.finalProject.registers;

public abstract class RegisterEntry implements Referable<RegisterEntry> {

    private int ownerId;
    private String ownerRepresentation;

    public RegisterEntry(int ownerId) {
        this.ownerId = ownerId;
//        this.ownerRepresentation = ownerRepresentation;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public RegisterEntry getReference(int ownerId) {
        return this;
    }
}
