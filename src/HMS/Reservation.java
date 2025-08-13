package HMS;

/**
 * Represents a reservation. This class uses composition to hold a Guest and a Room.
 */
public class Reservation {
    private final int reservationId;
    private final Guest guest;
    private final Room room;

    public Reservation(int reservationId, Guest guest, Room room) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.room.setAvailable(false); // Mark the room as unavailable upon reservation.
    }

    public int getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return String.format("Reservation ID: %d\n  - %s\n  - %s",
                reservationId, guest.toString(), room.toString());
    }
}