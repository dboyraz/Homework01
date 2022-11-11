import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {


    // Declare components
    private JFrame frame;
    private JPanel panelTop, panelLeft, boxPanel;
    private JButton btnExit, btnChangeUser;
    private JLabel lblUser;
    private String username;


    public MyFrame(String username) {

        this.username = username;

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
        btnChangeUser = new JButton("Change User");
        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        btnChangeUser.addActionListener(this);

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
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));


        // Set maximum size of the buttons,
        // align them to right
        // add them to the panel
        btnChangeUser.setMaximumSize(new Dimension(500, 100));
        btnExit.setMaximumSize(new Dimension(500, 100));
        btnExit.setAlignmentX(1);
        btnChangeUser.setAlignmentX(1);
        boxPanel.add(btnChangeUser);
        boxPanel.add(btnExit);


        // Set border for the user label
        lblUser.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));


        // Add the panels to the frame
        // using Border Layout for the main frame
        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);

        // Add sub-panel and label to the top panel
        panelTop.add(boxPanel, BorderLayout.EAST);
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
