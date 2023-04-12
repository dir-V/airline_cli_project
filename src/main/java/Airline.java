import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
    private static ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            String input = scanner.nextLine();
            switch (input){
                case"Add Flight":
                    addNewFlight();
                    break;
                default:
                    System.out.println("Enter valid command");
            }

        }
    }





    // Adding a flight method
    public static void addNewFlight(){
        System.out.println("Enter destination");
        String destination = scanner.nextLine();


        System.out.println("Enter iD");
        Integer iD = scanner.nextInt();

        flights.add(new Flight(iD, destination));
    }






}
