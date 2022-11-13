import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {

    // Declare components for the register frame
    private JFrame frame;
    private JButton btnCreate, btnExit;
    private JLabel lblUsername, lblPassword, lblTitle;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private Font font, fontTitle, fontButton;
    private Color clrText;


    public Register() {

        // Initialize the frame components
        frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.getContentPane().setBackground(new Color(15, 30, 77, 255));
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
        btnCreate = new JButton("Register");
        btnExit = new JButton("Exit");

        // Set color and font for the Create button
        btnCreate.setFocusPainted(false);
        btnCreate.setBackground(new Color(35, 87, 94));
        btnCreate.setFont(fontButton);
        btnCreate.setForeground(clrText);

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
        lblTitle = new JLabel("Register User", SwingConstants.CENTER);
        lblTitle.setForeground(clrText);
        lblUsername.setFont(font);
        lblPassword.setFont(font);
        lblTitle.setFont(fontTitle);

        // Add action listener to create and exit buttons
        btnCreate.addActionListener(this);
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
        btnCreate.setBounds(90, 290, 90, 30);
        frame.add(btnCreate);
        btnExit.setBounds(190, 290, 90, 30);
        frame.add(btnExit);

        // Set Create button as default button
        // Set the frame visible
        frame.getRootPane().setDefaultButton(btnCreate);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Exit application if Exit Button clicked
        if (e.getSource() == btnExit) {
            System.exit(0);
        }

        // Initiate create account process if Login button clicked
        else if (e.getSource() == btnCreate) {

            // Create a new user using text input
            // Add it to the global user list
            // Display a success message
            // Close the register frame
            Main.users.add(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
            JOptionPane.showMessageDialog(null, "User created successfully!");
            frame.dispose();

        }

    }
}
