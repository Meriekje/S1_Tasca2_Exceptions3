package org.example;

import java.util.Scanner;

public class Cinema {
    private int rows;
    private int seatsPerRow;
    private SeatManagement seatManagement;
    private CinemaManagement cinemaManagement;

    public Cinema() {
        seatManagement = new SeatManagement();
        cinemaManagement = new CinemaManagement(this);
        initializeCinema();
    }

    public void initializeCinema() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of seats per row: ");
                seatsPerRow = scanner.nextInt();
                if (rows > 0 && seatsPerRow > 0) break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number");
                scanner.nextLine();
            }
        }
    }

    public void start() {
        int option;
        do {
            option = cinemaManagement.showMenu();
            switch (option) {
                case 1:
                    cinemaManagement.showReservedSeats();
                    break;
                case 2:
                    cinemaManagement.showReservationsByPerson();
                    break;
                case 3:
                    cinemaManagement.reserveSeat();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    public int getRows() {
        return rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public SeatManagement getSeatManagement() {
        return seatManagement;
    }
}

