import java.util.ArrayList;

public class Flight {
    private int iD;
    private String destination;
    private ArrayList<Passenger>passenger;

    public Flight(int iD, String destination, ArrayList<Passenger> passenger){
        this.iD = iD;
        this.destination = destination;
        this.passenger = new ArrayList<>();
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ArrayList<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(ArrayList<Passenger> passenger) {
        this.passenger = passenger;
    }
//    Method to add new passengers
    public void addPassenger(Passenger passenger){
        passenger.add(passenger);
    }
}
