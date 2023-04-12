import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
    private static ArrayList<Flight> flights = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
            boolean running = true;
            while (running == true) {
                System.out.println("Enter a command:");
                System.out.println("1. Add a new flight");
                System.out.println("2. Display all available flights");
                System.out.println("3. Add a new passenger");
                System.out.println("4. Book a passenger onto a flight");
                System.out.println("5. Cancel a flight");
                System.out.println("6. Exit");

                int command = scanner.nextInt();
                scanner.nextLine();

                switch (command) {
                    case 1:
                        addNewFlight();
                        break;
                    case 2:
                        displayFlights();
                        break;
                    case 3:
                        addPassenger();
                        break;
                    case 4:
                        bookFlight();
                        break;
                    case 5:
                        cancelFlight();
                        break;
                    case 6:
                        System.out.println("Exiting ...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }
        }



    // Adding a flight method
    public static void addNewFlight(){
        System.out.println("Enter destination");
        String destination = scanner.nextLine();
        System.out.println("Enter flight ID: ");
        int iD = scanner.nextInt();
        flights.add(new Flight(iD, destination));
        System.out.println("New flight added.");
    }


    public static void displayFlights(){
        for (Flight flight : flights){
            System.out.println(flight);
        }
    }

    public static void addPassenger(){
        System.out.println("Enter Passenger name: ");
        String name = scanner.nextLine();
        System.out.println("Enter passenger contact information: ");
        String info = scanner.nextLine();
        System.out.println("Enter passenger ID: ");
        int id = scanner.nextInt();

        passengers.add(new Passenger(name, info, id));
        System.out.println("Passenger added.");

    }
    public static void bookFlight() {
        Passenger passenger = null;
        while (passenger == null) {
            System.out.println("Enter the passenger ID: ");
            int passengerID = scanner.nextInt();
            passenger = findPassenger(passengerID);
            if (passenger == null) {
                System.out.println("Passenger not found");
            }
        }
        Flight flight = null;
        while (flight == null) {
            System.out.println("Enter flight ID: ");
            int flightID = scanner.nextInt();
            flight = findFlight(flightID);
            if (flight == null) {
                System.out.println("Flight not found.");
            }
        }
        flight.addPassenger(passenger);
        System.out.println("Booking confirmed");
    }




    public static Passenger findPassenger(int id){
        for (Passenger passenger : passengers){
            if (passenger.getId() == id){
                return passenger;
            }
        }
        return null;

    }

    public static Flight findFlight(int id) {
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

    public static void cancelFlight(){
        System.out.println("Enter flight ID: ");
        int flightID = scanner.nextInt();
        Flight flight = findFlight(flightID);
        flights.remove(flight);
        System.out.println("Flight successfully cancelled.");
    }



}
