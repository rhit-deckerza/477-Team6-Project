import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblStatus;

    public LoginUI() {
        setTitle("jFTP Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Components
        add(new JLabel("Username:"));
        txtUsername = new JTextField();
        add(txtUsername);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        add(btnLogin);

        lblStatus = new JLabel("");
        add(lblStatus);

        setLocationRelativeTo(null);
    }

    private void loginUser() {
        String username = txtUsername.getText();
        User user = UserDatabase.getUser(username);
        if (user != null && user.getPassword().equals(new String(txtPassword.getPassword()))) {
            lblStatus.setText("Login successful!");
            System.out.println("Logged in with access level: " + user.getAccessLevel());
        } else {
            lblStatus.setText("Invalid username or password!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }
}
