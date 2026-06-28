package busticketbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {

    private List<Customer> customers;
    private List<Bus> buses;
    private List<Ticket> tickets;

    private int customerIdCounter;
    private int busIdCounter;
    private int ticketIdCounter;

    private Customer currentCustomer;

    public BookingSystem() {

        customers = new ArrayList<>();
        buses = new ArrayList<>();
        tickets = new ArrayList<>();

        customerIdCounter = 1;
        busIdCounter = 1;
        ticketIdCounter = 1;

        initializeBuses();
    }

    public void initializeBuses() {

        buses.add(new Bus(busIdCounter++, "AC", "Seater", 30));
        buses.add(new Bus(busIdCounter++, "Non-AC", "Seater", 40));
        buses.add(new Bus(busIdCounter++, "AC", "Sleeper", 20));
        buses.add(new Bus(busIdCounter++, "Non-AC", "Sleeper", 25));
    }

    public void signUp(Scanner sc) {

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        System.out.println("Enter Age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine();

        Customer customer = new Customer(customerIdCounter++,
                name, password, age, gender);

        customers.add(customer);

        System.out.println("Signup Successful");
        System.out.println("Customer ID: " + customer.getCustomerId());
    }

    public boolean login(Scanner sc) {

        System.out.println("Enter Customer ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        for (Customer customer : customers) {

            if (customer.getCustomerId() == id &&
                    customer.getPassword().equals(password)) {

                currentCustomer = customer;

                System.out.println("Login Successful");
                return true;
            }
        }

        System.out.println("Invalid Credentials");
        return false;
    }

    public void showAvailableBuses() {

        for (Bus bus : buses) {
            System.out.println(bus);
            System.out.println("----------------");
        }
    }

    public void bookTicket(Scanner sc) {

        if (currentCustomer == null) {
            System.out.println("Please login first");
            return;
        }

        showAvailableBuses();

        System.out.println("Enter Bus ID:");
        int busId = sc.nextInt();
        sc.nextLine();

        Bus selectedBus = null;

        for (Bus bus : buses) {
            if (bus.getBusId() == busId) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Invalid Bus");
            return;
        }

        selectedBus.showAvailableSeats();

        System.out.println("Enter Number Of Tickets:");
        int n = sc.nextInt();
        sc.nextLine();

        if (n > selectedBus.getAvailableSeats()) {
            System.out.println("Seats Not Available");
            return;
        }

        List<Integer> seatsToBook = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("Enter Seat Number:");
            int seat = sc.nextInt() - 1;
            sc.nextLine();

            if (!selectedBus.bookSeat(seat)) {
                System.out.println("Seat already booked");
                return;
            }

            seatsToBook.add(seat);
        }

        double fare = selectedBus.getBusType().equals("AC") ? 1000 : 500;

        if (selectedBus.getSeatType().equals("Sleeper"))
            fare += 500;

        double totalFare = fare * n;

        Ticket ticket = new Ticket(ticketIdCounter++,
                selectedBus, n, totalFare,
                currentCustomer.getCustomerId());

        for (int seat : seatsToBook) {
            ticket.addBookedSeat(seat);
        }

        tickets.add(ticket);

        System.out.println("Booking Successful");
        System.out.println("Ticket ID: " + ticket.getTicketId());
        System.out.println("Fare: " + totalFare);
    }

    public void viewTickets() {

        if (currentCustomer == null) {
            System.out.println("Login First");
            return;
        }

        for (Ticket ticket : tickets) {

            if (ticket.getCustomerId() ==
                    currentCustomer.getCustomerId()) {

                System.out.println(ticket);
            }
        }
    }

    public void cancelTicket(Scanner sc) {

        if (currentCustomer == null) {
            System.out.println("Login First");
            return;
        }

        viewTickets();

        System.out.println("Enter Ticket ID:");
        int id = sc.nextInt();
        sc.nextLine();

        Ticket cancelTicket = null;

        for (Ticket ticket : tickets) {

            if (ticket.getTicketId() == id &&
                    ticket.getCustomerId() ==
                            currentCustomer.getCustomerId()) {

                cancelTicket = ticket;
                break;
            }
        }

        if (cancelTicket == null) {
            System.out.println("Invalid Ticket");
            return;
        }

        Bus bus = cancelTicket.getBus();

        for (int seat : cancelTicket.getBookedSeats()) {
            bus.cancelSeat(seat);
        }

        tickets.remove(cancelTicket);

        System.out.println("Ticket Cancelled");
        System.out.println("Refund: " + cancelTicket.getFare());
    }

    public void showBusSummary() {

        for (Bus bus : buses) {

            System.out.println("Bus ID: " + bus.getBusId());
            System.out.println("Booked Seats: "
                    + (bus.getTotalSeats()
                    - bus.getAvailableSeats()));

            System.out.println("Available Seats: "
                    + bus.getAvailableSeats());

            System.out.println();
        }
    }
}