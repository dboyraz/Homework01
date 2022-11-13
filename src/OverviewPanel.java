import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OverviewPanel extends JFrame implements ActionListener {


    private JFrame frame;
    private JButton btnSave, btnExit;
    private JLabel lblCustomerName, lblLicensePlate;
    private JTextField txtCustomerName, txtLicensePlate;
    private Font font, fontTitle, fontButton;
    private Color clrText;

    public OverviewPanel() throws HeadlessException {

        // Initialize the frame components
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().setBackground(new Color(117, 169, 106, 255));
        frame.setLocationRelativeTo(null);
        frame.setTitle("PLM");
        frame.setLayout(null);

        // Instantiate the font and color used by the labels
        font = new Font("Arial", Font.PLAIN, 19);
        fontTitle = new Font("Arial", Font.BOLD, 22);
        fontButton = new Font("Arial", Font.PLAIN, 15);
        clrText = new Color(255, 255, 255);

        // Instantiate text-fields and assign their fonts
        txtCustomerName = new JTextField();
        txtCustomerName.setFont(font);
        txtLicensePlate = new JTextField();
        txtLicensePlate.setFont(font);

        // Instantiate buttons and assign their default text
        btnSave = new JButton("Save");
        btnExit = new JButton("Exit");

        // Set color and font for the Save button
        btnSave.setFocusPainted(false);
        btnSave.setBackground(new Color(35, 87, 94));
        btnSave.setFont(fontButton);
        btnSave.setForeground(clrText);

        // Set color and font for the Exit button
        btnExit.setFocusPainted(false);
        btnExit.setBackground(new Color(35, 87, 94));
        btnExit.setFont(fontButton);
        btnExit.setForeground(clrText);

        // Instantiate labels and assign their default text
        // set their font and color
        lblCustomerName = new JLabel("Customer Name", SwingConstants.CENTER);
        lblCustomerName.setForeground(clrText);
        lblLicensePlate = new JLabel("License Plate", SwingConstants.CENTER);
        lblLicensePlate.setForeground(clrText);
        lblCustomerName.setFont(font);
        lblLicensePlate.setFont(font);


        btnSave.addActionListener(this);
        btnExit.addActionListener(this);

        // Set size and location for the labels, text-fields and buttons
        // and add them to the frame
        lblCustomerName.setBounds(70, 140, 200, 25);
        frame.add(lblCustomerName);
        txtCustomerName.setBounds(100, 170, 165, 25);
        frame.add(txtCustomerName);
        lblLicensePlate.setBounds(60, 210, 200, 25);
        frame.add(lblLicensePlate);
        txtLicensePlate.setBounds(100, 235, 165, 25);
        frame.add(txtLicensePlate);
        btnSave.setBounds(90, 290, 90, 30);
        frame.add(btnSave);
        btnExit.setBounds(190, 290, 90, 30);
        frame.add(btnExit);

        frame.getRootPane().setDefaultButton(btnSave);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnExit) {
            frame.dispose();
        } else if (e.getSource() == btnSave) {

            // If there is room in the parking lot, save the customer
            if (Main.parkingLots.size() < Main.MAX_PARKING_LOTS) {

                Main.parkingLots.add(new ParkingLot(true, txtCustomerName.getText(), txtLicensePlate.getText()));
                Main.parkingLots.forEach(parkingLot -> System.out.println("Customer Name: " + parkingLot.getCustomerName() + " License Plate: " + parkingLot.getLicensePlate()));

                Object successMessage = "Customer: " + txtCustomerName.getText() + " \nLicense Plate: " + txtLicensePlate.getText() + " \nSaved successfully.";

                JOptionPane.showMessageDialog(null, successMessage, "Welcome", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Parking lot is full.", "Error", JOptionPane.ERROR_MESSAGE);
                frame.dispose();
            }


        }

    }
}
