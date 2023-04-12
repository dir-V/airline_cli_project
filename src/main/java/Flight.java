import java.util.ArrayList;

public class Flight {
    private int flightID;
    private String destination;
    private ArrayList<Passenger>passengers;

    public Flight( int iD, String destination){
        this.flightID = iD;
        this.destination = destination;
        this.passengers = new ArrayList<>();
    }

    public int getId() {
        return flightID;
    }

    public void setId(int iD) {
        this.flightID = iD;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<Passenger> getPassenger() {
        return passengers;
    }

    public void setPassenger(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
//    Method to add new passengers
    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
}
