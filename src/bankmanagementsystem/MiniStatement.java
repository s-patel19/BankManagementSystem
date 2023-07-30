package bankmanagementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{
    MiniStatement(String pinNumber){
        setTitle("MINI STATEMENT");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 20);
        add(mini);

        JLabel bank = new JLabel("BANK OF CITY");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_number = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("card_number").substring(0,4) + "XXXXXX" + rs.getString("card_number").substring(10));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br></br></html>");  
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }          
            }
            balance.setText("Your current account balance is Rs " + bal);
            
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
