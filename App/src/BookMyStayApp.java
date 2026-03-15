import java.util.*;

/**
 * ===============================================================
 * CLASS - Reservation
 * ===============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * Description:
 * This class represents a booking request made by a guest.
 * At this stage, a reservation only captures intent.
 *
 * @version 5.0
 */

public class BookMyStayApp {

    /* ================= RESERVATION CLASS ================= */

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

    /* ================= MAIN METHOD ================= */

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        // Guests sending booking requests
        queue.addRequest(new Reservation("Aadi", "Single"));
        queue.addRequest(new Reservation("Rahul", "Double"));
        queue.addRequest(new Reservation("Priya", "Suite"));

        System.out.println("Processing Booking Requests (FIFO)\n");

        while (queue.hasPendingRequests()) {

            Reservation request = queue.getNextRequest();

            System.out.println("Guest Name: " + request.getGuestName());
            System.out.println("Requested Room: " + request.getRoomType());
            System.out.println();
        }
    }
}