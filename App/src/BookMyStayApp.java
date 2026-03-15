import java.util.*;

/**
 * ===============================================================
 * CLASS - RoomSearchService
 * ===============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class provides search functionality
 * for guests to view available rooms.
 *
 * It reads room availability from inventory
 * and room details from Room objects.
 *
 * No inventory mutation or booking logic
 * is performed in this class.
 *
 * @version 4.0
 */

public class BookMyStayApp {

    /* ================= ROOM CLASS ================= */

    static class Room {

        String type;
        int beds;
        int size;
        double price;

        public Room(String type, int beds, int size, double price) {
            this.type = type;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public String getType() {
            return type;
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

        private Map<String, Integer> roomAvailability;

        public RoomInventory() {
            roomAvailability = new HashMap<>();
            initializeInventory();
        }

        private void initializeInventory() {

            roomAvailability.put("Single", 5);
            roomAvailability.put("Double", 3);
            roomAvailability.put("Suite", 2);

        }

        public Map<String, Integer> getRoomAvailability() {
            return roomAvailability;
        }
    }

    /* ================= ROOM SEARCH SERVICE ================= */

    static class RoomSearchService {

        public void searchAvailableRooms(
                RoomInventory inventory,
                Room singleRoom,
                Room doubleRoom,
                Room suiteRoom) {

            Map<String, Integer> availability = inventory.getRoomAvailability();

            // Check Single Room
            if (availability.get("Single") > 0) {

                System.out.println("Single Room Available");
                System.out.println("Beds: " + singleRoom.getBeds());
                System.out.println("Size: " + singleRoom.getSize() + " sqft");
                System.out.println("Price: " + singleRoom.getPrice());
                System.out.println("Available: " + availability.get("Single"));
                System.out.println();
            }

            // Check Double Room
            if (availability.get("Double") > 0) {

                System.out.println("Double Room Available");
                System.out.println("Beds: " + doubleRoom.getBeds());
                System.out.println("Size: " + doubleRoom.getSize() + " sqft");
                System.out.println("Price: " + doubleRoom.getPrice());
                System.out.println("Available: " + availability.get("Double"));
                System.out.println();
            }

            // Check Suite Room
            if (availability.get("Suite") > 0) {

                System.out.println("Suite Room Available");
                System.out.println("Beds: " + suiteRoom.getBeds());
                System.out.println("Size: " + suiteRoom.getSize() + " sqft");
                System.out.println("Price: " + suiteRoom.getPrice());
                System.out.println("Available: " + availability.get("Suite"));
                System.out.println();
            }
        }
    }

    /* ================= MAIN CLASS ================= */

    public static void main(String[] args) {

        Room single = new Room("Single", 1, 250, 1500);
        Room dbl = new Room("Double", 2, 400, 2500);
        Room suite = new Room("Suite", 3, 750, 5000);

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();

        System.out.println("Available Rooms:\n");

        searchService.searchAvailableRooms(
                inventory,
                single,
                dbl,
                suite
        );
    }
}