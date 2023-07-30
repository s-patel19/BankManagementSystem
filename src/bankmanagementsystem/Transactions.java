package bankmanagementsystem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{
    JLabel text;
    String pinNumber;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceEnquiry,exit;
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", 1, 20));
        text.setBounds(210, 300, 700, 35);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);
        withdrawl.addActionListener(this);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement);
        ministatement.addActionListener(this);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        image.add(pinchange);
        pinchange.addActionListener(this);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        image.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);

        exit = new JButton("EXIT");
        exit.setBounds(262,520,150,30);
        image.add(exit);
        exit.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == exit){
            System.exit(0);
       } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
       } else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
       } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
       } else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
       } else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber);
       } else if(ae.getSource() == ministatement){
            new MiniStatement(pinNumber);
       }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
