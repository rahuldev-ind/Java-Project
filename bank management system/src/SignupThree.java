import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
import java.util.Random;
import java.util.*;

public class SignupThree extends  JFrame implements ActionListener{

    JRadioButton savingAC, recuringAC, currentAC, studentAC;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancle;
    String formno;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        savingAC = new JRadioButton("Saving Account");
        savingAC.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAC.setBounds(100, 180, 150, 20);
        savingAC.setBackground(Color.WHITE);
        add(savingAC);

        recuringAC = new JRadioButton("Recuring Account");
        recuringAC.setFont(new Font("Raleway", Font.BOLD, 16));
        recuringAC.setBounds(350, 180, 200, 20);
        recuringAC.setBackground(Color.WHITE);
        add(recuringAC);

        currentAC = new JRadioButton("Current Account");
        currentAC.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAC.setBounds(100, 220, 200, 20);
        currentAC.setBackground(Color.WHITE);
        add(currentAC);

        studentAC = new JRadioButton("Student Account");
        studentAC.setFont(new Font("Raleway", Font.BOLD, 16));
        studentAC.setBounds(350, 220, 200, 20);
        studentAC.setBackground(Color.WHITE);
        add(studentAC);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4107");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 360, 200, 30);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnumber.setBounds(330, 360, 300, 30);
        add(pinnumber);

        JLabel pinDetail = new JLabel("Your 4 Digit Password");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 390, 300, 20);
        add(pinDetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 430, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 470, 200, 30);
        add(c1);

        c2 = new JCheckBox("Intenet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 470, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 520, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 520, 200, 30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 570, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 570, 200, 30);
        add(c6);

        submit = new  JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 620, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancle = new  JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway", Font.BOLD, 14));
        cancle.setBounds(420, 620, 100, 30);
        cancle.addActionListener(this);
        add(cancle);

        getContentPane().setBackground(Color.WHITE);

        ButtonGroup gropuAC = new ButtonGroup();
        gropuAC.add(savingAC);
        gropuAC.add(recuringAC);
        gropuAC.add(currentAC);
        gropuAC.add(studentAC);

        setSize(850, 820);
        setLocation(350,0);
        setVisible(true);

    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if (savingAC.isSelected()) {
                accountType = "Saving Account";
            } else if (recuringAC.isSelected()) {
                accountType = "Recuring Account";
            } else if (currentAC.isSelected()) {
                accountType = "Current Account";
            } else if (studentAC.isSelected()) {
                accountType = "Student Account";
            }

            Random random = new Random();
            //String formno = "" + random;
            formno = "" + Math.abs(random.nextInt(999999));
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()){
                facility = facility + " EMAIL & SMS Alert";
            } else if (c5.isSelected()){
                facility = facility + " Check Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query = "INSERT INTO signupthree VALUES('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                    String query2 = "INSERT INTO login VALUES('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";

                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber + "\n Pin: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }

            } catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == cancle) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main(String[] args){
        new SignupThree("");

    }
}
