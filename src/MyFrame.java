import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener, Runnable {


    // Declare components
    public static JLabel lblDate;
    private JFrame frame;
    private JPanel panelTop, panelLeft, panelCenter, panelOccupied, panelEmpty;
    private JButton btnOverview, btnCustomers, btnRates, btnReports, btnSettings, btnExit, btnChangeUser;
    private JLabel lblUser, lblOccupied, lblEmpty, lblOccupiedCount, lblEmptyCount;
    private Color colorButton;
    private Font mainFont;
    private Dimension dimButton;
    private Thread tRefresh, tClock;

    /***
     * Constructor
     * @param username Current user
     */
    public MyFrame(String username) {

        // Instantiate thread which refreshes center panel and start it
        tRefresh = new Thread(this, "Thread 1");
        tRefresh.start();

        // Instantiate thread which refreshes clock and start it
        tClock = new Thread(new Clock(), "Thread 2");
        tClock.start();

        // Set the default button color, font and button size
        colorButton = new Color(21, 43, 46);
        mainFont = new Font("Arial", Font.BOLD, 16);
        dimButton = new Dimension(500, 100);


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
        panelCenter = new JPanel();
        panelOccupied = new JPanel();
        panelEmpty = new JPanel();

        // Instantiate the buttons,
        // add default text ,
        // add action listener
        btnOverview = new JButton("Overview");
        btnCustomers = new JButton("Customers");
        btnRates = new JButton("Rates");
        btnReports = new JButton("Reports");
        btnSettings = new JButton("Settings");
        btnChangeUser = new JButton("Change User");
        btnExit = new JButton("Exit");
        btnOverview.addActionListener(this);
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

        lblOccupied = new JLabel("Occupied");
        lblOccupied.setForeground(Color.WHITE);
        lblEmpty = new JLabel("Empty");
        lblEmpty.setForeground(Color.WHITE);

        lblOccupiedCount = new JLabel(" ");
        lblEmptyCount = new JLabel(" ");
        lblOccupiedCount.setForeground(Color.WHITE);
        lblEmptyCount.setForeground(Color.WHITE);

        // Set the color of the panels
        panelTop.setBackground(new Color(35, 87, 94));
        panelLeft.setBackground(new Color(21, 43, 46));
        panelCenter.setBackground(Color.WHITE);
        panelOccupied.setBackground(new Color(35, 94, 76));
        panelEmpty.setBackground(new Color(29, 145, 145));

        // Set the size of the panels
        panelTop.setPreferredSize(new Dimension(100, 100));
        panelLeft.setPreferredSize(new Dimension(300, 100));
        panelOccupied.setBounds(100, 100, 300, 150);
        panelEmpty.setBounds(500, 100, 300, 150);

        // Set the layout of the panels
        panelTop.setLayout(new BorderLayout());
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelCenter.setLayout(null);
        panelOccupied.setLayout(null);
        panelEmpty.setLayout(null);

        // add two panels to center panel
        panelCenter.add(panelOccupied);
        panelCenter.add(panelEmpty);

        // Set size and coordinates of the labels
        // Add them to the panels

        lblOccupied.setBounds(50, 80, 100, 50);
        lblOccupiedCount.setBounds(50, 50, 100, 50);
        lblEmpty.setBounds(50, 80, 100, 50);
        lblEmptyCount.setBounds(50, 50, 100, 50);
        lblOccupied.setFont(mainFont);
        lblOccupiedCount.setFont(mainFont);
        lblEmpty.setFont(mainFont);
        lblEmptyCount.setFont(mainFont);
        panelOccupied.add(lblOccupied);
        panelOccupied.add(lblOccupiedCount);
        panelEmpty.add(lblEmpty);
        panelEmpty.add(lblEmptyCount);


        /***
         * Set maximum size of the buttons
         * @param dimButton Dimension
         */
        btnOverview.setMaximumSize(dimButton);
        btnCustomers.setMaximumSize(dimButton);
        btnRates.setMaximumSize(dimButton);
        btnReports.setMaximumSize(dimButton);
        btnSettings.setMaximumSize(dimButton);
        btnChangeUser.setMaximumSize(dimButton);
        btnExit.setMaximumSize(dimButton);

        // Set color of the buttons
        btnOverview.setBackground(colorButton);
        btnOverview.setForeground(Color.WHITE);
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

        // Set font of the buttons
        btnOverview.setFont(mainFont);
        btnCustomers.setFont(mainFont);
        btnRates.setFont(mainFont);
        btnReports.setFont(mainFont);
        btnSettings.setFont(mainFont);
        btnChangeUser.setFont(mainFont);
        btnExit.setFont(mainFont);


        btnOverview.setBorderPainted(false);
        btnCustomers.setBorderPainted(false);
        btnRates.setBorderPainted(false);
        btnReports.setBorderPainted(false);
        btnSettings.setBorderPainted(false);
        btnChangeUser.setBorderPainted(false);
        btnExit.setBorderPainted(false);

        // Add the buttons to the left panel
        panelLeft.add(btnOverview);
        panelLeft.add(btnCustomers);
        panelLeft.add(btnRates);
        panelLeft.add(btnReports);
        panelLeft.add(btnSettings);
        panelLeft.add(btnChangeUser);
        panelLeft.add(btnExit);


        // Set border for the user label
        lblUser.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));


        // Add user label to the top panel
        panelTop.add(lblUser, BorderLayout.WEST);

        // Create clock label
        lblDate = new JLabel();
        lblDate.setForeground(Color.WHITE);
        lblDate.setFont(mainFont);
        panelTop.add(lblDate, BorderLayout.EAST);


        // Add the panels to the frame
        // using Border Layout for the main frame
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelCenter, BorderLayout.CENTER);


        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // Exits the program when Exit button is clicked
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnChangeUser) {

            // Returns to Login page
            // when Change User button is clicked
            // and closes the current frame
            new Login();
            frame.dispose();
        } else if (e.getSource() == btnOverview) {

            // Opens Overview page
            new OverviewPanel();
        }


    }

    @Override
    public void run() {

        // Refresh occupied and empty lot count
        try {
            while (true) {
                Thread.sleep(1000);
                lblOccupiedCount.setText(Main.parkingLots.size() + "");
                lblEmptyCount.setText(Main.MAX_PARKING_LOTS - Main.parkingLots.size() + "");

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
