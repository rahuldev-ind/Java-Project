import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{

    JButton deposite, withdraw, ministatement, pinchange, fastcase, balanceEnqury, exit;
    String pinnumber;

    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 720);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(235, 237, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 13));
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(170, 333, 120, 25);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(370, 333, 120, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcase = new JButton("Fastcase");
        fastcase.setBounds(170, 360, 120, 25);
        fastcase.addActionListener(this);
        image.add(fastcase);

        ministatement = new JButton("Ministatement");
        ministatement.setBounds(370, 360, 120, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pinchange");
        pinchange.setBounds(170, 387, 120, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnqury = new JButton("Balance");
        balanceEnqury.setBounds(370, 387, 120, 25);
        balanceEnqury.addActionListener(this);
        image.add(balanceEnqury);

        exit = new JButton("Exit");
        exit.setBounds(370, 415, 120, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 720);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposite) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);

        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new  Withdraw(pinnumber).setVisible(true);

        } else if (ae.getSource() == fastcase) {
            setVisible(false);
            new Fastcase(pinnumber).setVisible(true);

        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);

        } else if (ae.getSource() == balanceEnqury) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
            
        } else if (ae.getSource() == ministatement) {

            new Ministatement(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args){
        new Transaction("");
    }
}
