import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {


    // Declare components
    private JFrame frame;
    private JPanel panelTop, panelLeft, boxPanel;
    private JButton btnCustomers, btnRates, btnReports, btnSettings, btnExit, btnChangeUser;
    private JLabel lblUser;
    private String username;
    private Color colorButton;


    public MyFrame(String username) {

        this.username = username;

        colorButton = new Color(21, 43, 46);


        // Instantiate the frame,
        // set its properties
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setTitle("Parking Lot Manager");
        frame.setLayout(new BorderLayout());

        // Instantiate the panels
        panelTop = new JPanel();
        panelLeft = new JPanel();
        boxPanel = new JPanel();

        // Instantiate the buttons,
        // add default text ,
        // add action listener
        btnCustomers = new JButton("Customers");
        btnRates = new JButton("Rates");
        btnReports = new JButton("Reports");
        btnSettings = new JButton("Settings");
        btnChangeUser = new JButton("Change User");
        btnExit = new JButton("Exit");
        btnCustomers.addActionListener(this);
        btnRates.addActionListener(this);
        btnReports.addActionListener(this);
        btnSettings.addActionListener(this);
        btnChangeUser.addActionListener(this);
        btnExit.addActionListener(this);

        // Instantiate the label,
        // add default text
        // set default font, size and color
        lblUser = new JLabel("Welcome " + username);
        lblUser.setFont(new Font("Arial", Font.BOLD, 20));
        lblUser.setForeground(Color.WHITE);


        // Set the color of the panels
        panelTop.setBackground(new Color(35, 87, 94));
        panelLeft.setBackground(new Color(21, 43, 46));
        boxPanel.setBackground(new Color(35, 87, 94));

        // Set the size of the panels
        panelTop.setPreferredSize(new Dimension(100, 100));
        panelLeft.setPreferredSize(new Dimension(300, 100));

        // Set the layout of the panels
        panelTop.setLayout(new BorderLayout());
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));


        // Set maximum size of the buttons,
        // align them to right
        // add them to the panel
        btnCustomers.setMaximumSize(new Dimension(500, 100));
        btnRates.setMaximumSize(new Dimension(500, 100));
        btnReports.setMaximumSize(new Dimension(500, 100));
        btnSettings.setMaximumSize(new Dimension(500, 100));
        btnChangeUser.setMaximumSize(new Dimension(500, 100));
        btnExit.setMaximumSize(new Dimension(500, 100));


        btnCustomers.setBackground(colorButton);
        btnCustomers.setForeground(Color.WHITE);
        btnRates.setBackground(colorButton);
        btnRates.setForeground(Color.WHITE);
        btnReports.setBackground(colorButton);
        btnReports.setForeground(Color.WHITE);
        btnSettings.setBackground(colorButton);
        btnSettings.setForeground(Color.WHITE);
        btnChangeUser.setBackground(colorButton);
        btnChangeUser.setForeground(Color.WHITE);
        btnExit.setBackground(colorButton);
        btnExit.setForeground(Color.WHITE);

        btnCustomers.setFont(new Font("Arial", Font.BOLD, 16));
        btnRates.setFont(new Font("Arial", Font.BOLD, 16));
        btnReports.setFont(new Font("Arial", Font.BOLD, 16));
        btnSettings.setFont(new Font("Arial", Font.BOLD, 16));
        btnChangeUser.setFont(new Font("Arial", Font.BOLD, 16));
        btnExit.setFont(new Font("Arial", Font.BOLD, 16));
        btnCustomers.setBorderPainted(false);
        btnRates.setBorderPainted(false);
        btnReports.setBorderPainted(false);
        btnSettings.setBorderPainted(false);
        btnChangeUser.setBorderPainted(false);
        btnExit.setBorderPainted(false);
        panelLeft.add(btnCustomers);
        panelLeft.add(btnRates);
        panelLeft.add(btnReports);
        panelLeft.add(btnSettings);
        panelLeft.add(btnChangeUser);
        panelLeft.add(btnExit);


        // Set border for the user label
        lblUser.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));


        // Add the panels to the frame
        // using Border Layout for the main frame
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);

        // Add sub-panel and label to the top panel
        //panelTop.add(boxPanel, BorderLayout.EAST);
        panelTop.add(lblUser, BorderLayout.WEST);


        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Exit program when the btnExit is clicked
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnChangeUser) {

            // Returns to login page when clicked


            new Login();
            frame.dispose();
        }


    }
}
