package bankmanagementsystem;

import java.sql.*;

public class Conn {
    // Register thr Driver
    // Create Connection
    // Create Statement
    // Execute Query
    // Close Connection
    Connection c;
    Statement s;
    public Conn() {
        try {
            // Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Sp@8986742723");
            s = c.createStatement();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
