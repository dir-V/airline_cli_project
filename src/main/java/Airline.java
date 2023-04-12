import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
//    Declaring ArrayLists
    private static ArrayList<Flight> flights = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
            boolean running = true;
            while (running == true) { // Interface will continue running infinitely until running becomes false.
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
                        System.out.println("Invalid command"); // Error message if an invalid input is entered.
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

// Display flights method
    public static void displayFlights(){
        for (Flight flight : flights){
            System.out.println(flight);
        }
    }

//    Add Passenger to Database
    public static void addPassenger(){
        System.out.println("Enter Passenger name: ");
        String name = scanner.nextLine();
        System.out.println("Enter passenger contact information: ");
        String info = scanner.nextLine();
        System.out.println("Enter passenger ID: ");
        int id = scanner.nextInt();

        passengers.add(new Passenger(name, info, id)); // Adds new passenger to the "passengers" arraylist
        System.out.println("Passenger added.");

    }

//    Adding a passenger to a flight
    public static void bookFlight() {
        boolean cancel = true;
        Passenger passenger = null; // Calling the Passenger class
        while (passenger == null) { // Using a while loop to keep asking for user input. Ends once a valid passenger ID is entered.
            System.out.println("Enter the passenger ID:\nPress 0 to cancel. ");
            int passengerID = scanner.nextInt();
            passenger = findPassenger(passengerID);
            if (passengerID == 0){
                System.out.println("Cancelling operation.");
                cancel = false;
                break;
            }
            if (passenger == null) {
                System.out.println("Passenger not found");
            }
        }
        Flight flight = null;
        while (flight == null && cancel ) {// Using a while loop to keep asking for a flight ID. Ends once a valid flight ID is entered.
            System.out.println("Enter flight ID:\n Enter 0 to cancel. ");
            int flightID = scanner.nextInt();
            flight = findFlight(flightID);
            if (flightID == 0) {
                System.out.println("Cancelling operation. Returning to main menu.");
                cancel = false;
                break;
            }
            if (flight == null) { // Error message if in correct flight ID is entered.
                System.out.println("Flight not found.");
            }
        }
        if (cancel){
        flight.addPassenger(passenger); // Once a valid flight and passenger ID are inputted the passenger is added to the flight.
        System.out.println("Booking confirmed");
    }
    }



// Finding a passenger by using their ID
    public static Passenger findPassenger(int id){
        for (Passenger passenger : passengers){ // Iterates through every passenger in "passengers" array list until the ID is found. Using a HashMap would be quicker.
            if (passenger.getId() == id){
                return passenger;
            }
        }
        return null;

    }

//    Finding a flight using only ID
    public static Flight findFlight(int id) { // Same method as findPassenger() but just for "flights" arraylist.
        for (Flight flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }

//    Cancelling a flight
    public static void cancelFlight(){
        boolean cancel = true;
        Flight flight = null;
            while (flight == null){
            System.out.println("Enter flight ID: \nEnter 0 to cancel");
            int flightID = scanner.nextInt();
             flight = findFlight(flightID);
             if (flightID == 0){
                    System.out.println("Operation cancelled. Returning to main console.");
                    cancel = false;
                    break;
                }
             if (flight == null){
                    System.out.println("Please enter a valid flight ID: ");
                }
        }
            if (cancel) {
                flights.remove(flight); // Removes a flight from the "flights" arraylist using flightID.
                System.out.println("Flight successfully cancelled.");
            }
    }



}
