package org.example;

public class Seat {
    private int row;
    private int seatNumber;
    private String reservedBy;

    public Seat(int row, int seatNumber, String reservedBy) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.reservedBy = reservedBy;
    }

    public int getRow() {
        return row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Seat seat = (Seat) obj;
        return row == seat.row && seatNumber == seat.seatNumber;
    }

    @Override
    public String toString() {
        return "Row: " + row + ", Seat: " + seatNumber + ", Reserved by: " + reservedBy;
    }

}
