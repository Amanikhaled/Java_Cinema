

import java.util.Scanner;

public class Main {


    static void mainMenu() {
        System.out.println();
        System.out.println("========= CINEMA =========");
        System.out.println("1. Display Seats");
        System.out.println("2. Book Seat");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Show all movies");
        System.out.println("5. Show number of available and booked seats");
        System.out.println("6. Exit");
        System.out.println("=======================");
        System.out.print("Choose an option: ");
    }

    static void displaySeats(char[][] seats) {
        for (int row = 0; row < seats.length; row++) {
            System.out.print((row + 1) + "  ");
            for (int col = 0; col < seats[row].length; col++) {
                System.out.print(seats[row][col] + " ");
            }
            System.out.println();
        }
    }

    static void bookSeat(char[][] seats, Scanner scanner) {
        System.out.print("Enter row number (1-5): ");
        int row = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter seat number (1-6): ");
        int seat = Integer.parseInt(scanner.nextLine().trim());

        row--;
        seat--;


        if (seats[row][seat] == 'X') {
            System.out.println("This seat is already booked.");
        } else {
            seats[row][seat] = 'X';
            System.out.println("Seat booked successfully!");
        }

    }

    static void cancelBooking(char[][] seats, Scanner scanner) {
        System.out.print("Enter row number (1-5): ");
        int row = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter seat number (1-6): ");
        int seat = Integer.parseInt(scanner.nextLine().trim());

        row--;
        seat--;

        if (seats[row][seat] == 'O') {
            System.out.println("This seat is already not booked.");
        } else {
            seats[row][seat] = 'O';
            System.out.println("The booked seat is cancelled successfully!");
        }


    }

    static void displaySeatCounts(char[][] seats) {

        int booked = 0;
        int available = 0;

        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {

                if (seats[row][col] == 'X') {
                    booked++;
                } else {
                    available++;
                }
            }
        }

        System.out.println("Booked seats: " + booked);
        System.out.println("Available seats: " + available);
    }

    static void showMovies(String[] movies) {
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Movies" + movies[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] seats = new char[5][6];
        String[] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};

        //initialize all seats
        for (int row = 0; row < seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                seats[row][col] = 'O';
            }
        }


        String choice;
        do {
            mainMenu();

            choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    displaySeats(seats);
                    break;

                case "2":
                    bookSeat(seats, scanner);
                    break;

                case "3":
                    cancelBooking(seats, scanner);
                    break;

                case "4":
                    showMovies(movieNames);
                    break;

                case "5":
                    displaySeatCounts(seats);
                    break;

                case "6":
                    System.out.println("Thank you for using our cinema!");
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!choice.equals("6"));

        scanner.close();

    }
}
