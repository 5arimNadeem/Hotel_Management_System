package HMS;

/**
 * Represents a guest. Encapsulation is used to protect guest data.
 */
public class Guest {
    private int guestId;
    private String name;

    public Guest(int guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    public int getGuestId() {
        return guestId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Guest [ID=" + guestId + ", Name=" + name + "]";
    }
}