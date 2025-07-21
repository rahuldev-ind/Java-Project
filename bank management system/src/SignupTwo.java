import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

    long random;
    JTextField  aadharTextField, panTextField;
    JRadioButton Yes, No, Yess, Noo;
    JComboBox religions, categorys, incomes, educations, occuption;
    JButton next;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionDetails = new JLabel("Page 1: Additional Details");
        additionDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionDetails.setBounds(290, 80, 400, 30);
        add(additionDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300, 140, 400, 30);
        add(religions);


        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categorys = new JComboBox(valcategory);
        categorys.setBounds(300, 190, 400, 30);
        add(categorys);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valincome[] = {"null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomes = new JComboBox(valincome);
        incomes.setBounds(300, 240, 400, 30);
        add(incomes);


        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        String educationValues[] = {"Non Graduation", "Geaduation", "Post Graduation", "Doctorate"};
        educations = new JComboBox(educationValues);
        educations.setBounds(300, 290, 400, 30);
        add(educations);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        String occuptionValues[] = {"Salaried", "Self-Employed", "Bussness", "Student", "Retaired"};
        occuption = new JComboBox(occuptionValues);
        occuption.setBounds(300, 340, 400, 30);
        add(occuption);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 390, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 440, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 490, 200, 30);
        add(senior);

        Yes = new JRadioButton("Yes");
        Yes.setBounds(300, 490, 100, 30);
        Yes.setBackground(Color.WHITE);
        add(Yes);

        No = new JRadioButton("No");
        No.setBounds(450, 490, 100, 30);
        No.setBackground(Color.WHITE);
        add(No);

        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(Yes);
        seniorCitizen.add(No);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 540, 200, 30);
        add(existing);

        Yess = new JRadioButton("Yes");
        Yess.setBounds(300, 540, 100, 30);
        Yess.setBackground(Color.WHITE);
        add(Yess);

        Noo = new JRadioButton("No");
        Noo.setBounds(450, 540, 100, 30);
        Noo.setBackground(Color.WHITE);
        add(Noo);

        ButtonGroup existingAc = new ButtonGroup();
        existingAc.add(Yess);
        existingAc.add(Noo);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String sreligion = (String) religions.getSelectedItem();
        String scategory = (String) categorys.getSelectedItem();
        String sincome = (String) incomes.getSelectedItem();
        String seducation = (String) educations.getSelectedItem();
        String soccuption = (String) occuption.getSelectedItem();
        String seniorcitizen = null;
        if (Yes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (No.isSelected()) {
            seniorcitizen = "No";
        }
        String existingAccount = null;
        if (Yess.isSelected()) {
            existingAccount = "Yess";
        } else if (Noo.isSelected()) {
            existingAccount = "Noo";
        }
        String span = panTextField.getText();
        String aadhar = aadharTextField.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccuption+"', '"+span+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);

            //signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);

        }

    }
}



