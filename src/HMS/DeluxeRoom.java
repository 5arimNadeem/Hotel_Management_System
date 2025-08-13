package HMS;

/**
 * A subclass of Room with a price multiplier.
 */
public class DeluxeRoom extends Room {
    private static final double PRICE_MULTIPLIER = 1.25;

    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice() {
        // A deluxe room's price is the base price multiplied.
        return super.calculatePrice() * PRICE_MULTIPLIER;
    }

    @Override
    public String toString() {
        return String.format("Deluxe Room #%d - Price: $%.2f", getRoomNumber(), calculatePrice());
    }
}