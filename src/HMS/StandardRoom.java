package HMS;

/**
 * A simple subclass of Room with no extra charges.
 */
public class StandardRoom extends Room {

    public StandardRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice() {
        // A standard room's price is just its base price.
        return super.calculatePrice();
    }

    @Override
    public String toString() {
        return String.format("Standard Room #%d - Price: $%.2f", getRoomNumber(), calculatePrice());
    }
}