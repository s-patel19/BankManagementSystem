package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    // constructor
    Login(){
        // title of the window
        setTitle("ATM Sytem");
        setLayout(null);
        // adding logo and scaling
        ImageIcon logo1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image logo2 =  logo1.getImage().getScaledInstance(101, 101, Image.SCALE_DEFAULT);
        ImageIcon logo3 = new ImageIcon(logo2);
        JLabel label = new JLabel(logo3);
        label.setBounds(70, 10, 100, 100);  
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardNo = new JLabel("CARD NO :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNo.setBounds(120, 150, 180, 40);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(350, 160, 250, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(120, 220, 180, 40);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 230, 250, 30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,15));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(350, 330, 100, 30);
        login.setForeground(Color.white);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(500, 330, 100, 30);
        clear.setForeground(Color.white);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(350, 390, 250, 30);
        signup.setForeground(Color.white);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
        setSize(800, 480);
        setVisible(true);
        setLocation(300, 200);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == login){
            Conn c = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select *from login where card_number = '" + cardNumber + "' and pin_number = '" + pinNumber + "'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Details or Pin");
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } else if(ae.getSource() == signup) {
                setVisible(false);
                new Signup().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
