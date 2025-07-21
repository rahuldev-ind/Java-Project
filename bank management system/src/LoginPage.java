import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class LoginPage {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);
            frame.setOpacity(0.95f);
            frame.setLayout(new BorderLayout());

            // Background panel with gradient
            JPanel backgrounfpanel = new JPanel(){
                @Override
                protected void paintComponent(Graphics g){
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    GradientPaint gradient = new GradientPaint(0, 0, new Color(123, 97, 255), 0, getHeight(), new Color(0, 204, 255));
                    g2d.setPaint(gradient);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            backgrounfpanel.setLayout(new BorderLayout());

            // Login Panel
            JPanel loginPanel = new JPanel();
            loginPanel.setOpaque(false);
            loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
            loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // Title Lable
            JLabel titleLable = new JLabel("Welcome Back!");
            titleLable.setFont(new Font("Arial", Font.BOLD, 24));
            titleLable.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginPanel.add(titleLable);

            // Username Field
            JTextField userTextfield = new JTextField(20);
            userTextfield.setFont(new Font("Arial", Font.PLAIN, 14));
            userTextfield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            userTextfield.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginPanel.add(Box.createVerticalStrut(10));
            loginPanel.add(userTextfield);

            // Password Field
            JPasswordField passwordField = new JPasswordField(20);
            passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
            passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            loginPanel.add(Box.createVerticalStrut(10));
            loginPanel.add(passwordField);

            // Login Button
            JButton loginButton = new JButton("Login");
            loginButton.setFont(new Font("Arial", Font.BOLD, 14));
            loginButton.setBackground(new Color(0, 204, 255));
            loginButton.setForeground(Color.WHITE);
            loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginButton.setBorderPainted(false);
            loginButton.setFocusPainted(false);
            loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            loginButton.addActionListener(e -> {
                String username = userTextfield.getText();
                char[] password = passwordField.getPassword();
                if ("admin".equals(username) && "password".equals(new
                        String(password))){
                    JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            loginPanel.add(Box.createVerticalStrut(10));
            loginPanel.add(loginButton);

            // Add panels to frame
            backgrounfpanel.add(loginPanel, BorderLayout.CENTER);
            frame.add(backgrounfpanel);

            // Display frame
            frame.setVisible(true);
        });
    }
}
