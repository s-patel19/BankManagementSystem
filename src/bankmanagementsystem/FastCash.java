package bankmanagementsystem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JLabel text;
    String pinNumber;
    JButton onehun,fivehun,onek,twok,fivek,tenk,back;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);  
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("SELECT WITHDRAWL");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", 1, 20));
        text.setBounds(210, 300, 700, 35);
        image.add(text);

        onehun = new JButton("Rs 100");
        onehun.setBounds(170,415,150,30);
        image.add(onehun);
        onehun.addActionListener(this);

        fivehun = new JButton("Rs 500");
        fivehun.setBounds(355,415,150,30);
        image.add(fivehun);
        fivehun.addActionListener(this);

        onek = new JButton("Rs 1000");
        onek.setBounds(170,450,150,30);
        image.add(onek);
        onek.addActionListener(this);

        twok = new JButton("Rs 2000");
        twok.setBounds(355,450,150,30);
        image.add(twok);
        twok.addActionListener(this);

        fivek = new JButton("Rs 5000");
        fivek.setBounds(170,485,150,30);
        image.add(fivek);
        fivek.addActionListener(this);

        tenk = new JButton("Rs 10000");
        tenk.setBounds(355,485,150,30);
        image.add(tenk);
        tenk.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(262,520,150,30);
        image.add(back);
        back.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
       } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                    if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " + amount + " Debited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.err.println(e);
            }

       }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
