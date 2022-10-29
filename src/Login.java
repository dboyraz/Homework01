import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    public static void main(String[] args) {

        new Login();
    }

    // Declare components for the login frame
    private JFrame frame;
    private JButton btnLogin, btnExit;
    private JLabel lblUsername, lblPassword, lblTitle;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private Font font, fontTitle, fontButton;
    private Color clrText;


    // Constructor
    Login() {


        initializeLoginFrame();

    }

    public void initializeLoginFrame() {

        // Initialize the frame components
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().setBackground(new Color(6, 45, 49));
        frame.setLocationRelativeTo(null);
        frame.setTitle("PLM");
        frame.setLayout(null);

        // Instantiate the font and color used by labels
        font = new Font("Arial", Font.PLAIN, 19);
        fontTitle = new Font("Arial", Font.BOLD, 22);
        fontButton = new Font("Arial", Font.PLAIN, 15);
        clrText = new Color(255, 255, 255);

        // Instantiate text-fields assign their fonts
        txtUsername = new JTextField();
        txtUsername.setFont(font);
        txtPassword = new JPasswordField();
        txtPassword.setFont(font);

        // Instantiate buttons and assign their default text
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");

        // Set color and font for the Login button
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(new Color(35, 87, 94));
        btnLogin.setFont(fontButton);
        btnLogin.setForeground(clrText);

        // Set color and font for the Exit button
        btnExit.setFocusPainted(false);
        btnExit.setBackground(new Color(35, 87, 94));
        btnExit.setFont(fontButton);
        btnExit.setForeground(clrText);

        // Instantiate labels and set their font and color
        lblUsername = new JLabel("Username", SwingConstants.CENTER);
        lblUsername.setForeground(clrText);
        lblPassword = new JLabel("Password", SwingConstants.CENTER);
        lblPassword.setForeground(clrText);
        lblTitle = new JLabel("Parking Lot Manager", SwingConstants.CENTER);
        lblTitle.setForeground(clrText);
        lblUsername.setFont(font);
        lblPassword.setFont(font);
        lblTitle.setFont(fontTitle);

        // Add action listener to login and exit buttons
        btnLogin.addActionListener(this);
        btnExit.addActionListener(this);


        // Set x,y coordinates and height-width property for labels, buttons and text-fields
        // Add labels, buttons and text-fields to the frame
        lblTitle.setBounds(45, 60, 300, 25);
        frame.add(lblTitle);
        lblUsername.setBounds(92, 140, 100, 25);
        frame.add(lblUsername);
        txtUsername.setBounds(100, 170, 165, 25);
        frame.add(txtUsername);
        lblPassword.setBounds(92, 210, 100, 25);
        frame.add(lblPassword);
        txtPassword.setBounds(100, 235, 165, 25);
        frame.add(txtPassword);
        btnLogin.setBounds(90, 290, 90, 30);
        frame.add(btnLogin);
        btnExit.setBounds(190, 290, 90, 30);
        frame.add(btnExit);

        // Set Login button as default button
        // Set the frame visible
        frame.getRootPane().setDefaultButton(btnLogin);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Exit application if Exit Button clicked
        if (e.getSource() == btnExit) {
            System.exit(0);
        }

        // Initiate login process if Login button clicked
        else if (e.getSource() == btnLogin) {

            authenticateLogin();

        }

    }

    // Handles the login process
    public void authenticateLogin() {

        // Declare variables
        String username, password;

        // Assign their values from text-field inputs
        username = txtUsername.getText();
        password = new String(txtPassword.getPassword());


        // If both username and password is correct then login
        if (username.equals() && password.equals()) {


            Object successMessage = "Login Successful!\nWelcome " + username + "!" +
                    "\nParking Lot Manager is an application that will help you run your establishment." +
                    "\nPress OK to proceed.";


            JOptionPane.showMessageDialog(null, successMessage, "Welcome", JOptionPane.INFORMATION_MESSAGE);
        }
        // If username is correct but password incorrect, show error message
        else if (username.equals() && !password.equals()) {
            JOptionPane.showMessageDialog(null, "Wrong Password!", "Error", JOptionPane.WARNING_MESSAGE);
        }
        //If username is incorrect, show error message
        else {
            JOptionPane.showMessageDialog(null, "User does not exist!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
