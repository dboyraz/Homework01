import java.io.Serializable;

public class Customer implements Serializable {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String licensePlate;
    private String vehicleInfo;

    public Customer(int id, String name, String address, String phone, String licensePlate, String vehicleInfo) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.licensePlate = licensePlate;
        this.vehicleInfo = vehicleInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }

    @Override
    public String toString() {
        return " Customer {" +
                " ID = " + id +
                ", Name = '" + name + '\'' +
                ", Address = '" + address + '\'' +
                ", Phone = '" + phone + '\'' +
                ", License Plate = '" + licensePlate + '\'' +
                ", Vehicle Info = '" + vehicleInfo + '\'' +
                '}' + '\n';
    }
}
