import java.util.*;

/**
 * ===============================================================
 * CLASS - Reservation
 * ===============================================================
 * Represents a booking request made by a guest.
 */

public class BookMyStayApp {

    /* ================= RESERVATION ================= */

    static class Reservation {

        private String guestName;
        private String roomType;

        public Reservation(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
        }

        public String getGuestName() {
            return guestName;
        }

        public String getRoomType() {
            return roomType;
        }
    }

    /* ================= BOOKING REQUEST QUEUE ================= */

    static class BookingRequestQueue {

        private Queue<Reservation> requestQueue;

        public BookingRequestQueue() {
            requestQueue = new LinkedList<>();
        }

        public void addRequest(Reservation reservation) {
            requestQueue.offer(reservation);
        }

        public Reservation getNextRequest() {
            return requestQueue.poll();
        }

        public boolean hasPendingRequests() {
            return !requestQueue.isEmpty();
        }
    }

    /* ================= ROOM INVENTORY ================= */

    static class RoomInventory {

        private Map<String, Integer> roomAvailability;

        public RoomInventory() {

            roomAvailability = new HashMap<>();

            roomAvailability.put("Single", 2);
            roomAvailability.put("Double", 2);
            roomAvailability.put("Suite", 1);
        }

        public Map<String, Integer> getRoomAvailability() {
            return roomAvailability;
        }

        public void decreaseRoom(String roomType) {

            int count = roomAvailability.get(roomType);
            roomAvailability.put(roomType, count - 1);
        }
    }

    /* ================= ROOM ALLOCATION SERVICE ================= */

    /**
     * ===============================================================
     * CLASS - RoomAllocationService
     * ===============================================================
     *
     * Use Case 6: Reservation Confirmation & Room Allocation
     *
     * This class confirms booking requests and assigns rooms.
     */

    static class RoomAllocationService {

        private int roomIdCounter = 101;

        public void processRequests(BookingRequestQueue queue,
                                    RoomInventory inventory) {

            while (queue.hasPendingRequests()) {

                Reservation request = queue.getNextRequest();
                String roomType = request.getRoomType();

                int available =
                        inventory.getRoomAvailability().get(roomType);

                if (available > 0) {

                    int allocatedRoomId = roomIdCounter++;

                    inventory.decreaseRoom(roomType);

                    System.out.println("Booking Confirmed");
                    System.out.println("Guest: " + request.getGuestName());
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Allocated Room ID: " + allocatedRoomId);
                    System.out.println();

                } else {

                    System.out.println("Booking Failed");
                    System.out.println("Guest: " + request.getGuestName());
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Reason: No rooms available");
                    System.out.println();
                }
            }
        }
    }

    /* ================= MAIN METHOD ================= */

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Aadi", "Single"));
        queue.addRequest(new Reservation("Rahul", "Double"));
        queue.addRequest(new Reservation("Priya", "Suite"));
        queue.addRequest(new Reservation("Karan", "Suite")); // extra request

        RoomInventory inventory = new RoomInventory();

        RoomAllocationService allocationService =
                new RoomAllocationService();

        System.out.println("Processing Reservations...\n");

        allocationService.processRequests(queue, inventory);
    }
}