package com.busticketbooking;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private int ticketId;
    private Bus bus;
    private List<Integer> bookedSeats;
    private int numberOfTickets;
    private double fare;
    private int customerId;

    public Ticket(int ticketId, Bus bus, int numberOfTickets,
                  double fare, int customerId) {
        this.ticketId = ticketId;
        this.bus = bus;
        this.numberOfTickets = numberOfTickets;
        this.fare = fare;
        this.customerId = customerId;
        this.bookedSeats = new ArrayList<>();
    }

    public void addBookedSeat(int seatNumber) {
        bookedSeats.add(seatNumber);
    }

    public int getTicketId() {
        return ticketId;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public Bus getBus() {
        return bus;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getFare() {
        return fare;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                "\nBus ID: " + bus.getBusId() +
                "\nSeats: " + bookedSeats +
                "\nNumber Of Tickets: " + numberOfTickets +
                "\nFare: " + fare;
    }
}