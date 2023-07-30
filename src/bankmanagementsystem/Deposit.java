package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
    JLabel text;
    JTextField amount;
    JButton deposit, back;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the amount you want to Deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System",1,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",1,25));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        image.add(deposit);
        deposit.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " +number+ " Deposited Successfully");
                    setVisible(false);
                    new FastCash(pinNumber).setVisible(true);
                } catch (SQLException e) {
                    System.err.println(e);;
                }
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
