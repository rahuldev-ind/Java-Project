import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class simpleLogin extends JFrame implements ActionListener{

    JButton login, signup, clear;
    JTextField userTextField;
    JPasswordField passwordTextField;

    simpleLogin(){

        setSize(700, 500);
        setVisible(true);

        setTitle("Simple Login Page");

        setLayout(null);

        JLabel text = new JLabel("Welcome To Rahul");
        text.setFont(new Font("Arial", Font.BOLD, 33));
        text.setForeground(Color.ORANGE);
        text.setBounds(200, 20, 400, 40);
        add(text);

        JLabel username = new JLabel("Username : ");
        username.setFont(new Font("Arial", Font.BOLD, 25));
        username.setForeground(Color.BLACK);
        username.setBounds(100, 100, 150, 20);
        add(username);

        JLabel password = new JLabel("Password : ");
        password.setFont(new Font("Arial", Font.BOLD, 25));
        password.setForeground(Color.BLACK);
        password.setBounds(100, 160, 150, 20);
        add(password);

        userTextField = new JTextField("");
        userTextField.setFont(new Font("Arial", Font.BOLD, 14));
        userTextField.setBounds(300, 100, 230, 30);
        add(userTextField);

        passwordTextField = new JPasswordField("");
        passwordTextField.setFont(new Font("Arial", Font.BOLD, 14));
        passwordTextField.setBounds(300, 160, 230, 30);
        add(passwordTextField);

        login = new JButton("Login");
        login.setBounds(350, 230, 80, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        signup = new JButton("Signup");
        signup.setBounds(450, 230, 80, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("Clear");
        clear.setBounds(350, 270, 180, 30);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);




    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == clear){
            userTextField.setText("");
            passwordTextField.setText("");
        } else if (e.getSource() == signup) {
            this.setVisible(false); // Hide the login frame
            new SignUpOne(); // Open the signup frame

        } else if (e.getSource() == login) {
            this.setVisible(false); // Hide the login frame
            new LoginPage(); // Open the homePage frame
        }
    }















    public static void main(String[] args){
        new simpleLogin();

    }
}
