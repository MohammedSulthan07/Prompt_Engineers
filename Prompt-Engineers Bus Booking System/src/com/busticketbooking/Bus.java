package busticketbooking;
import java.util.Arrays;

public class Bus {

    private int busId;
    private String busType;
    private String seatType;
    private int totalSeats;
    private boolean[] seats;

    public Bus(int busId, String busType, String seatType, int totalSeats) {
        this.busId = busId;
        this.busType = busType;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }

    public int getBusId() {
        return busId;
    }

    public String getBusType() {
        return busType;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        int count = 0;

        for (boolean seat : seats) {
            if (!seat) {
                count++;
            }
        }

        return count;
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= totalSeats)
            return false;
        if (!seats[seatNumber]) {
            seats[seatNumber] = true;
            return true;
        }
        return false;
    }

    public boolean cancelSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= totalSeats)
            return false;
        if (seats[seatNumber]) {
            seats[seatNumber] = false;
            return true;
        }
        return false;
    }

    public void showAvailableSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Bus ID: " + busId +
                "\nBus Type: " + busType +
                "\nSeat Type: " + seatType +
                "\nTotal Seats: " + totalSeats +
                "\nAvailable Seats: " + getAvailableSeats() +
                "\nSeats: " + Arrays.toString(seats);
    }
}