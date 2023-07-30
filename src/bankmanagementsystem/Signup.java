package bankmanagementsystem;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{

    long ran;
    JTextField nameTextField,FnameTextField,emailTextField,addrTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;
    
    Signup() {
        setLayout(null);
        
        Random random = new Random();
        ran = Math.abs((random.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APLLICATION FORM NO. " + ran);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel Fname = new JLabel("Father's Name :");
        Fname.setFont(new Font("Raleway",Font.BOLD,22));
        Fname.setBounds(100,190,200,30);
        add(Fname);

        FnameTextField = new JTextField();
        FnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        FnameTextField.setBounds(300, 190, 400, 30);
        add(FnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bgender = new ButtonGroup();
        bgender.add(male);
        bgender.add(female);

        JLabel email = new JLabel("Email-Address :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);


        JLabel mstatus = new JLabel("Marital Status :");
        mstatus.setFont(new Font("Raleway",Font.BOLD,22));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup bmarital = new ButtonGroup();
        bmarital.add(married);
        bmarital.add(unmarried);

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);

        addrTextField = new JTextField();
        addrTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addrTextField.setBounds(300, 440, 400, 30);
        add(addrTextField); 

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        JLabel pin = new JLabel("Pin Code :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,590,200,30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

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
        String formno = "" + ran;
        String name = nameTextField.getText();
        String fname = FnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        String address = addrTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name field is Empty");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new Signup();
    }
}
