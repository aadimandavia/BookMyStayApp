import java.util.*;

/**
 * ===============================================================
 * CLASS - RoomInventory
 * ===============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * Room pricing and characteristics are obtained
 * from Room objects, not duplicated here.
 *
 * This avoids multiple sources of truth and
 * keeps responsibilities clearly separated.
 *
 * @version 3.1
 */

public class BookMyStayApp {

    /* ================= ROOM CLASS ================= */

    static class Room {
        String roomType;
        int beds;
        int size;
        double price;

        public Room(String roomType, int beds, int size, double price) {
            this.roomType = roomType;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public String getRoomType() {
            return roomType;
        }

        public int getBeds() {
            return beds;
        }

        public int getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }
    }

    /* ================= ROOM INVENTORY ================= */

    static class RoomInventory {

        /**
         * Stores available room count for each room type.
         * Key   -> Room type name
         * Value -> Available room count
         */
        private Map<String, Integer> roomAvailability;

        /**
         * Constructor initializes inventory
         * with default availability values.
         */
        public RoomInventory() {
            roomAvailability = new HashMap<>();
            initializeInventory();
        }

        /**
         * Initializes room availability data.
         */
        private void initializeInventory() {

            roomAvailability.put("Single Room", 5);
            roomAvailability.put("Double Room", 3);
            roomAvailability.put("Suite Room", 2);

        }

        /**
         * Returns current availability map.
         */
        public Map<String, Integer> getRoomAvailability() {
            return roomAvailability;
        }

        /**
         * Updates availability for a specific room type.
         */
        public void updateAvailability(String roomType, int count) {
            roomAvailability.put(roomType, count);
        }
    }

    /* ================= MAIN METHOD ================= */

    public static void main(String[] args) {

        Room single = new Room("Single Room", 1, 250, 1500);
        Room dbl = new Room("Double Room", 2, 400, 2500);
        Room suite = new Room("Suite Room", 3, 750, 5000);

        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        List<Room> rooms = Arrays.asList(single, dbl, suite);

        for (Room room : rooms) {

            System.out.println(room.getRoomType() + ":");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available Rooms: " +
                    inventory.getRoomAvailability().get(room.getRoomType()));
            System.out.println();
        }
    }
}