package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panno, aadharno;
    JButton next;
    JRadioButton syes,sno, eyes, eno;
    JComboBox religionBox, categoryBox, inccategoryBox, eduComboBox, occuComboBox;
    String formno;
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,200,30);
        add(religion);

        String[] valReligion = {"Hindu","Muslim","Sikh","Christian","Others"};
        religionBox = new JComboBox<>(valReligion);
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);

        String[] valCategory = {"General","OBC","SC","ST","Others"};
        categoryBox = new JComboBox<>(valCategory);
        categoryBox.setBounds(300,190,400,30);
        categoryBox.setBackground(Color.white);
        add(categoryBox);

        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);

        String[] incCategory = {"< 100000","< 500000","< 1000000","> 1000000"};
        inccategoryBox = new JComboBox<>(incCategory);
        inccategoryBox.setBounds(300,240,400,30);
        inccategoryBox.setBackground(Color.white);
        add(inccategoryBox);

        JLabel educational = new JLabel("Educational :");
        educational.setFont(new Font("Raleway",Font.BOLD,22));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String[] educationQual = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        eduComboBox = new JComboBox<>(educationQual);
        eduComboBox.setBounds(300,315,400,30);
        eduComboBox.setBackground(Color.white);
        add(eduComboBox);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String[] occupationVal = {"Student","Self-Employed","Corporate-Employed","Government-Employed","Retired"};
        occuComboBox = new JComboBox<>(occupationVal);
        occuComboBox.setBounds(300,395,400,30);
        occuComboBox.setBackground(Color.white);
        add(occuComboBox);

        JLabel pan = new JLabel("Pan NO. :");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);

        panno = new JTextField();
        panno.setFont(new Font("Raleway",Font.BOLD,14));
        panno.setBounds(300, 440, 400, 30);
        add(panno); 

        JLabel aadhar = new JLabel("Aadhar No. :");
        aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharno = new JTextField();
        aadharno.setFont(new Font("Raleway",Font.BOLD,14));
        aadharno.setBounds(300, 490, 400, 30);
        add(aadharno);

        JLabel sencit = new JLabel("Senior Citizen :");
        sencit.setFont(new Font("Raleway",Font.BOLD,22));
        sencit.setBounds(100,540,200,30);
        add(sencit);

        syes = new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup bsencit = new ButtonGroup();
        bsencit.add(syes);
        bsencit.add(sno);

        JLabel existing = new JLabel("Existing Account :");
        existing.setFont(new Font("Raleway",Font.BOLD,22));
        existing.setBounds(100,590,200,30);
        add(existing);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("NO");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup bexisting = new ButtonGroup();
        bexisting.add(syes);
        bexisting.add(sno);

        next = new JButton("NEXT", null);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionBox.getSelectedItem();
        String category = (String)categoryBox.getSelectedItem();
        String income = (String)inccategoryBox.getSelectedItem();
        String education = (String)eduComboBox.getSelectedItem();
        String occupation = (String)occuComboBox.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "YES";
        } else if(sno.isSelected()){
            seniorcitizen = "NO";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "YES";
        } else if(eno.isSelected()){
            existingaccount = "NO";
        }
        String pan = panno.getText();
        String aadhar = aadharno.getText();
        

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values ('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
            c.s.executeUpdate(query);

            // Signup 3 class 
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
