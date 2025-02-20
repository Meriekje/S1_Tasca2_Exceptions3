package org.example;

import java.util.ArrayList;
import java.util.List;

public class SeatManagement {
    private List<Seat> seats;

    public SeatManagement() {
        seats = new ArrayList<>();
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) throws Exception {
        if (findSeat(seat.getRow(), seat.getSeatNumber()) != -1) {
            throw new SeatAlreadyReservedException("Seat is already reserved.");
        }
        seats.add(seat);
    }

    public void removeSeat(int row, int seatNumber) throws Exception {
        int index = findSeat(row, seatNumber);
        if (index == -1) {
            throw new SeatNotReservedException("Seat is not reserved.");
        }
        seats.remove(index);
    }

    public void removeSeatsByPerson(String personName) {
        seats.removeIf(seat -> seat.getReservedBy().equalsIgnoreCase(personName));
    }

    public int findSeat(int row, int seatNumber) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i).getRow() == row && seats.get(i).getSeatNumber() == seatNumber) {
                return i;
            }
        }
        return -1;
    }
}

