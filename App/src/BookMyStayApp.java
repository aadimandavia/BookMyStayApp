import java.util.*;

/**
 * ===============================================================
 * CLASS - AddOnService
 * ===============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * Represents an optional service that can be added
 * to a confirmed reservation.
 *
 * Examples:
 * - Breakfast
 * - Spa
 * - Airport Pickup
 *
 * @version 7.0
 */

public class BookMyStayApp {

    /* ================= ADD ON SERVICE ================= */

    static class AddOnService {

        private String serviceName;
        private double cost;

        public AddOnService(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        public String getServiceName() {
            return serviceName;
        }

        public double getCost() {
            return cost;
        }
    }

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

    /* ================= ADD ON SERVICE MANAGER ================= */

    static class AddOnServiceManager {

        private Map<String, List<AddOnService>> reservationServices;

        public AddOnServiceManager() {
            reservationServices = new HashMap<>();
        }

        public void addService(String guestName, AddOnService service) {

            reservationServices.computeIfAbsent(guestName, k -> new ArrayList<>()).add(service);
        }

        public void displayServices(String guestName) {

            List<AddOnService> services = reservationServices.get(guestName);

            if (services == null) {
                System.out.println("No services added.");
                return;
            }

            double total = 0;

            for (AddOnService s : services) {

                System.out.println("Service: " + s.getServiceName());
                System.out.println("Cost: " + s.getCost());
                System.out.println();

                total += s.getCost();
            }

            System.out.println("Total Service Cost: " + total);
        }
    }

    /* ================= MAIN CLASS ================= */

    public static void main(String[] args) {

        Reservation reservation =
                new Reservation("Aadi", "Suite");

        AddOnServiceManager manager =
                new AddOnServiceManager();

        AddOnService breakfast =
                new AddOnService("Breakfast", 500);

        AddOnService spa =
                new AddOnService("Spa", 2000);

        AddOnService airportPickup =
                new AddOnService("Airport Pickup", 800);

        manager.addService(reservation.getGuestName(), breakfast);
        manager.addService(reservation.getGuestName(), spa);
        manager.addService(reservation.getGuestName(), airportPickup);

        System.out.println("Add-On Services for " +
                reservation.getGuestName() + "\n");

        manager.displayServices(reservation.getGuestName());
    }
}