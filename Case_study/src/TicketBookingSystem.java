import java.util.Scanner;

class Passenger {
    private int passengerId;
    private String passengerName;
    private String gender;
    private String dob;
    private int totalSeatsRequired;
    private static int totalSeatsAvailable = 100;
    private static final double COST_PER_SEAT = 200.0;

    public Passenger(int id, String name, String gender, String dob, int seats) {
        this.passengerId = id;
        this.passengerName = name;
        this.gender = gender;
        this.dob = dob;
        this.totalSeatsRequired = seats;
    }

    public double calculateTicketPrice() {
        double ticketPrice = totalSeatsRequired * COST_PER_SEAT;

        if (isSeniorCitizen()) {
            ticketPrice *= 0.82; // 18% discount for seniors (above 60)
        }

        if (gender.equalsIgnoreCase("female")) {
            ticketPrice *= 0.90; // 10% discount for females
        }

        if (totalSeatsAvailable > 50 && totalSeatsAvailable < 75) {
            ticketPrice *= 1.18; // 18% price increase if available seats are between 50 and 75
        } else if (totalSeatsAvailable < 75) {
            ticketPrice *= 1.32; // 32% price increase if available seats are less than 75
        }

        return ticketPrice;
    }

    private boolean isSeniorCitizen() {
        // Assuming date of birth is in "dd-mm-yyyy" format
        String[] dobParts = dob.split("-");
        int yearOfBirth = Integer.parseInt(dobParts[2]);
        int currentYear = java.time.LocalDate.now().getYear();
        return currentYear - yearOfBirth > 60;
    }

    public int getSeatsRequired() {
        return totalSeatsRequired;
    }

    public static void updateAvailableSeats(int bookedSeats) {
        totalSeatsAvailable -= bookedSeats;
    }

    public static int getAvailableSeats() {
        return totalSeatsAvailable;
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueBooking = true;

        while (continueBooking) {
            System.out.println("Enter Passenger ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter Passenger Name:");
            String name = scanner.nextLine();

            System.out.println("Enter Passenger Gender:");
            String gender = scanner.nextLine();

            System.out.println("Enter Passenger DOB (in dd-mm-yyyy format):");
            String dob = scanner.nextLine();

            System.out.println("Enter Total Seats Required:");
            int seatsRequired = scanner.nextInt();

            Passenger passenger = new Passenger(id, name, gender, dob, seatsRequired);

            double ticketPrice = passenger.calculateTicketPrice();

            System.out.println("Available Seats: " + Passenger.getAvailableSeats());
            System.out.println("Total Ticket Price: Rs." + ticketPrice);

            Passenger.updateAvailableSeats(passenger.getSeatsRequired());

            System.out.println("Do you want to continue booking? (yes/no)");
            String choice = scanner.next();
            continueBooking = choice.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for booking!");
        scanner.close();
    }
}