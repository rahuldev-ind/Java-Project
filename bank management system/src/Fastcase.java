import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcase extends JFrame implements ActionListener{

    JButton deposite, withdraw, ministatement, pinchange, fastcase, balanceEnqury, exit;
    String pinnumber;

    Fastcase(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 720);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235, 237, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 13));
        image.add(text);

        deposite = new JButton("100");
        deposite.setBounds(170, 333, 120, 25);
        deposite.addActionListener(this);
        image.add(deposite);

        withdraw = new JButton("500");
        withdraw.setBounds(370, 333, 120, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcase = new JButton("1000");
        fastcase.setBounds(170, 360, 120, 25);
        fastcase.addActionListener(this);
        image.add(fastcase);

        ministatement = new JButton("2000");
        ministatement.setBounds(370, 360, 120, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("5000");
        pinchange.setBounds(170, 387, 120, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnqury = new JButton("10000");
        balanceEnqury.setBounds(370, 387, 120, 25);
        balanceEnqury.addActionListener(this);
        image.add(balanceEnqury);

        exit = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText(); //.substring(3);500
            int withdrawalAmount = Integer.parseInt(amount);
            Conn c = new Conn();

            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < withdrawalAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Dabited successfully ");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);

            }
        }
    }


    public static void main(String[] args){
        new Fastcase("");
    }
}
