package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JLabel card,number,pin,pinno,cardDetail,pinDetail,services;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno){
        this.formno = formno;

        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", 1, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 30);
        add(r1);
    
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", 1, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 300, 30);
        add(r2);
    
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", 1, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 30);
        add(r3);
    
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", 1, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 30);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);
        
        number = new JLabel("XXXX-XXXX-XXXX-8945");
        number.setFont(new Font("Raleway", 1, 18));
        number.setBounds(330, 300, 300, 30);
        add(number);

        cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", 1, 16));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway", 1, 18));
        pinno.setBounds(330, 370, 250, 30);
        add(pinno);

        pinDetail = new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Raleway", 1, 16));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);

        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", 1, 22));
        services.setBounds(100, 450, 250, 30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", 1, 16));
        c1.setBackground(new Color(204, 255, 255));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(204, 255, 255));
        c2.setFont(new Font("Raleway", 1, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(204, 255, 255));
        c3.setFont(new Font("Raleway", 1, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(new Color(204, 255, 255));
        c4.setFont(new Font("Raleway", 1, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(204, 255, 255));
        c5.setFont(new Font("Raleway", 1, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(204, 255, 255));
        c6.setFont(new Font("Raleway", 1, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6); 
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        c7.setBackground(new Color(204, 255, 255));
        c7.setFont(new Font("Raleway", 1, 13));
        c7.setBounds(100, 680, 600, 20);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Raleway", 1, 15));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 720, 100, 35);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Raleway", 1, 15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 720, 100, 35);
        add(cancel);
        cancel.addActionListener(this);
        setSize(850,820);
        setLocation(350, 0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if (ae.getSource() == submit) {
            String atype = null;
            if (r1.isSelected()) {
            atype = "Saving Account";
            }
            else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
            }
            else if (r3.isSelected()) {
            atype = "Current Account";
            } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
            }

            Random ran = new Random();
            long first7 = ran.nextLong() % 90000000L + 75467000000000L;
            String cardnumber = "" + Math.abs(first7);
    
            long first4 = ran.nextLong() % 9000L + 10000L;
            String pinnumber = "" + Math.abs(first4);

            String facility = "";
            if (c1.isSelected()) {
              facility = facility + " ATM Card";
            }
            if (c2.isSelected()) {
              facility = facility + " Internet Banking";
            }
            if (c3.isSelected()) {
              facility = facility + " Mobile Banking";
            }
            if (c4.isSelected()) {
              facility = facility + " Email Alerts";
            }
            if (c5.isSelected()) {
              facility = facility + " Cheque Book";
            }
            if (c6.isSelected()) {
              facility = facility + " E-Statement";
            }

            try {
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type Required");
                } else {
                    Conn conn = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"','" + atype + "','"+cardnumber+"','"+pinnumber+"','" +facility+"')";
                    String q2 = "insert into login values('"+formno+"','" +cardnumber + "','" + pinnumber + "')";
                    
                    conn.s.executeUpdate(q1);
                    conn.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                    setVisible(false);
                    new Withdrawl(pinnumber).setVisible(true);;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
       } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
       }
    }
    public static void main(String[] args) {
        new SignupThree("");
    
    }
}
