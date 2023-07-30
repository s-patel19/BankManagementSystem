package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    JLabel text,pinText,repinText;
    JPasswordField pin,repin;
    JButton change, back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBackground(Color.WHITE);
        text.setFont(new Font("System", 1, 16));
        text.setBounds(250, 280, 500, 30);
        image.add(text);

        pinText = new JLabel("New PIN: ");
        pinText.setBackground(Color.WHITE);
        pinText.setFont(new Font("System", 1, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", 1, 25));
        pin.setBounds(320,320,180,25);
        image.add(pin);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", 1, 25));
        repin.setBounds(320,360,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        repinText = new JLabel("ReEnter PIN: ");
        repinText.setBackground(Color.WHITE);
        repinText.setFont(new Font("System", 1, 16));
        repinText.setBounds(165, 360, 180, 25);
        image.add(repinText);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change){
              try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"PIN cannot be Empty!");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter new PIN");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pin_number = '"+rpin+"' where pin_number = '"+pinNumber+"'";
                String query3 = "update signupthree set pin_number = '"+rpin+"' where pin_number = '"+pinNumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e){
                System.err.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber);
        }
      
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
