// File: HMS/Hotel.java
package HMS;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages the hotel's operations using composition.
 * It contains a list of rooms and a list of reservations.
 */
public class Hotel {
    private final List<Room> rooms;
    private final List<Reservation> reservations;
    private int nextReservationId = 1;

    public Hotel() {
       rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    // --- Room Management ---
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Added room: " + room);
    }

    /**
     * Finds and returns a list of all rooms that are currently available.
     * This version uses a simple for loop.
     *
     * @return A List of available Room objects.
     */
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        // Loop through all rooms and add available ones to the new list.
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // --- Reservation Management ---
    /**
     * Attempts to make a reservation for a guest in a specific room number.
     * This version uses a simple for loop and returns null on failure.
     *
     * @param guest The guest making the reservation.
     * @param roomNumber The number of the room to reserve.
     * @return The new Reservation object if successful, or null if the room is not available.
     */
    public Reservation makeReservation(Guest guest, int roomNumber) {
        Room roomToReserve = null;
        // Loop through all rooms to find the one with the matching room number and check its availability.
        for (Room room : this.rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                roomToReserve = room;
                break; // Exit the loop once the room is found.
            }
        }

        if (roomToReserve != null) {
            // Found an available room, so create a reservation.
            Reservation newReservation = new Reservation(nextReservationId++, guest, roomToReserve);
            reservations.add(newReservation);
            System.out.println("Reservation successful: " + newReservation);
            return newReservation;
        } else {
            System.out.println("Reservation failed: Room #" + roomNumber + " is not available or does not exist.");
            return null; // Return null to indicate failure.
        }
    }

    /**
     * Attempts to check out a reservation by ID.
     * This version uses a simple for loop and returns false on failure.
     *
     * @param reservationId The ID of the reservation to check out.
     * @return true if the checkout was successful, false otherwise.
     */
    public boolean checkOut(int reservationId) {
        Reservation reservationToCheckOut = null;
        int reservationIndex = -1;
        // Loop through all reservations to find the one with the matching ID.
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationId() == reservationId) {
                reservationToCheckOut = reservations.get(i);
                reservationIndex = i;
                break; // Exit the loop once the reservation is found.
            }
        }

        if (reservationToCheckOut != null) {
            // Found the reservation, so free up the room and remove the reservation.
            Room room = reservationToCheckOut.getRoom();
            room.setAvailable(true);
            reservations.remove(reservationIndex);
            System.out.println("Checkout successful for reservation ID: " + reservationId);
            return true;
        } else {
            System.out.println("Checkout failed: Reservation ID " + reservationId + " not found.");
            return false;
        }
    }
}
