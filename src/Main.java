import java.util.ArrayList;
import java.util.List;

public class Main {


    /**
     * Declare list of User and ParkingLot as global variables
     * using static keyword
     */
    public static List<User> users = new ArrayList<User>();
    public static List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    public final static int MAX_PARKING_LOTS = 5;


    public static void main(String[] args) {


        // Populate the parking lot for demo purposes
        // Instantiate the Login frame and start the application
        parkingLots.add(new ParkingLot(true, "34 TTY 09", "Ahmet"));
        parkingLots.add(new ParkingLot(true, "01 KKL 781", "Mehmet"));
        parkingLots.add(new ParkingLot(true, "02 NNJ 50", "Ali"));
        parkingLots.add(new ParkingLot(true, "03 BBT 33", "Veli"));
        new Login();
    }

}