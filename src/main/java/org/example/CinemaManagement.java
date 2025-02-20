package org.example;

import java.util.Scanner;

class CinemaManagement {
    private Cinema cinema;
    private Scanner scanner;

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("1. Show all reserved seats\n2. Show reservations by person\n3. Reserve a seat\n4. Cancel a seat reservation\n5. Cancel all reservations for a person\n0. Exit");
        return scanner.nextInt();
    }

    public void showReservedSeats() {
        for (Seat seat : cinema.getSeatManagement().getSeats()) {
            System.out.println(seat);
        }
    }

    public void showReservationsByPerson() {
        System.out.print("Enter the person's name: ");
        String name = scanner.nextLine();
        for (Seat seat : cinema.getSeatManagement().getSeats()) {
            if (seat.getReservedBy().equalsIgnoreCase(name)) {
                System.out.println(seat);
            }
        }
    }

    public void reserveSeat() {
        try {
            int row = getValidRow();
            int seatNumber = getValidSeat();
            String name = getValidName();
            cinema.getSeatManagement().addSeat(new Seat(row, seatNumber, name));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cancelSeatReservation() {
        try {
            int row = getValidRow();
            int seatNumber = getValidSeat();
            cinema.getSeatManagement().removeSeat(row, seatNumber);
            System.out.println("Reservation canceled.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cancelAllReservationsForPerson() {
        try {
            String name = getValidName();
            cinema.getSeatManagement().removeSeatsByPerson(name);
            System.out.println("All reservations for " + name + " have been canceled.");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private int getValidRow() throws InvalidRowException {
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        if (row < 1 || row > cinema.getRows()) {
            throw new InvalidRowException("Invalid row number.");
        }
        return row;
    }

    private int getValidSeat() throws InvalidSeatException {
        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > cinema.getSeatsPerRow()) {
            throw new InvalidSeatException("Invalid seat number.");
        }
        return seatNumber;
    }

    private String getValidName() throws InvalidNameException {
        System.out.print("Enter name: ");
        String name = scanner.next();
        if (!name.matches("[a-zA-Z ]+")) {
            throw new InvalidNameException("Name cannot contain numbers.");
        }
        return name;
    }

}
