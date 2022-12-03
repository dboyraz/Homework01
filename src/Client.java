import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread {

    private int port;

    public Client(int port) {
        this.port = port;
    }

    public void getCustomerList(Socket socket) {

        try {

            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<Customer> customers = (ArrayList<Customer>) ois.readObject();
            System.out.println(customers);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error when getting the customer list");
        }
    }

    public void requestName(Socket socket, int id) {

        try {

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            dos.writeUTF(String.valueOf(id));


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error when requesting name from server");
        }

    }

    public void getServerResponse(Socket socket) {

        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            System.out.println("Server says : " + dis.readUTF());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("error when getting response from server");
        }
    }

    @Override
    public void run() {

        try {

            Socket clientSocket = new Socket("localhost", this.port);

            getCustomerList(clientSocket);
            requestName(clientSocket, 1);
            getServerResponse(clientSocket);

            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error in client run method");


        }
    }
}
