public class ParkingLot {


    private boolean isOccupied;
    private String licensePlate;
    private String customerName;

    /***
     * Constructor for the ParkingLot class
     * @param isOccupied Is it occupied or empty
     * @param licensePlate License plate of the occupying car
     * @param customerName Owner of the occupying car
     */
    public ParkingLot(boolean isOccupied, String licensePlate, String customerName) {
        this.isOccupied = isOccupied;
        this.licensePlate = licensePlate;
        this.customerName = customerName;
    }


    public String getCustomerName() {
        return customerName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
