import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReaderHelper {

    private ArrayList<Customer> cList;
    private String fileLocation;
    private String line;
    private BufferedReader bf;

    public void ReadAndWrite(ArrayList<Customer> cList, String fileLocation) {
        this.cList = cList;
        this.fileLocation = fileLocation;

        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocation), "UTF-8"));


            while ((line = bf.readLine()) != null) {

                if (!line.isEmpty()) {
                    String[] tokens = line.split(",");

                    Customer customer = new Customer(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                    customer.setId(Integer.parseInt(tokens[0].trim()));
                    customer.setName(tokens[1].trim());
                    customer.setAddress(tokens[2].trim());
                    customer.setPhone(tokens[3].trim());
                    customer.setLicensePlate(tokens[4].trim());
                    customer.setVehicleInfo(tokens[5].trim());

                    cList.add(customer);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("error while reading text file");
        }
    }


}


