package HMS;

/**
 * This is the base class for all room types.
 * It uses encapsulation to protect its data.
 */
public class Room {
    private final int roomNumber;
    protected double basePrice;
    private boolean isAvailable;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.isAvailable = true; // All rooms are initially available
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * This method demonstrates polymorphism.
     * It will be overridden by subclasses to calculate their specific price.
     *
     * @return The calculated price of the room.
     */
    public double calculatePrice() {
        return this.basePrice;
    }

    @Override
    public String toString() {
        return String.format("Room #%d - Base Price: $%.2f", roomNumber, basePrice);
    }
}