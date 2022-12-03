import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private int port;
    private ArrayList<Customer> customers;

    public Server(int port, ArrayList<Customer> customers) {
        this.port = port;
        this.customers = customers;
    }

    public String findCustomer(int id) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (this.customers.get(i).getId() == id) {
                return this.customers.get(i).getName();
            }
        }

        return "Customer not found.";
    }

    public void writeList(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(this.customers);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error while writing list");
        }
    }

    public String getCustomer(Socket socket) {
        String name = " ";

        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            int id = Integer.parseInt(dis.readUTF());
            name = findCustomer(id);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("error while getting customer");
        }
        //return name;

        return "Listed all the customers...";
    }

    public void respondClient(Socket socket) {

        try {
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);


            dos.writeUTF(getCustomer(socket));
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("error while responding to client");

        }

    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            Socket socket;

            System.out.println("Login successful, starting the server...");

            while (true) {

                socket = server.accept();

                writeList(socket);
                respondClient(socket);

                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error in server run method");
        }

    }
}
