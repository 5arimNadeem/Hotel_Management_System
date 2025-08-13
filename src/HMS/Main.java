// File: HMS/Main.java
package HMS;

import java.util.List;

/**
 * This is the main class to run the application and demonstrate its features.
 */
public class Main {
    public static void main(String[] args) {
        Hotel myHotel = new Hotel();

        // Add various types of rooms to the hotel.
        System.out.println("--- Initializing Hotel with Rooms ---");
        myHotel.addRoom(new StandardRoom(101, 100.0));
        myHotel.addRoom(new StandardRoom(102, 100.0));
        myHotel.addRoom(new DeluxeRoom(201, 150.0));
        myHotel.addRoom(new Suite(301, 250.0));

        System.out.println("\n--- All available rooms before any reservations ---");
        List<Room> availableRooms = myHotel.getAvailableRooms();
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        // Create a guest.
        Guest guest1 = new Guest(1, "Alice Smith");
        Guest guest2 = new Guest(2, "Bob Johnson");

        // --- Making Reservations ---
        System.out.println("\n--- Making a reservation for room 201 ---");
        Reservation res1 = myHotel.makeReservation(guest1, 201);

        System.out.println("\n--- Attempting to make a reservation for the same room ---");
        myHotel.makeReservation(guest2, 201);

        System.out.println("\n--- Making a reservation for room 301 ---");
        Reservation res2 = myHotel.makeReservation(guest2, 301);

        System.out.println("\n--- Checking available rooms after reservations ---");
        for (Room room : myHotel.getAvailableRooms()) {
            System.out.println(room);
        }

        // --- Checking Out ---
        System.out.println("\n--- Checking out reservation ID 1 ---");
        // We now check if the returned reservation is not null before using it.
        if (res1 != null) {
            myHotel.checkOut(res1.getReservationId());
        }

        System.out.println("\n--- Checking available rooms after checkout ---");
        for (Room room : myHotel.getAvailableRooms()) {
            System.out.println(room);
        }
    }
}
