package HMS;

/**
 * A subclass of Room with a fixed additional cost.
 */
public class Suite extends Room {
    private static final double ADDITIONAL_COST = 200.0;

    public Suite(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice() {
        // A suite's price is the base price plus a fixed cost.
        return super.calculatePrice() + ADDITIONAL_COST;
    }

    @Override
    public String toString() {
        return String.format("Suite #%d - Price: $%.2f", getRoomNumber(), calculatePrice());
    }
}
