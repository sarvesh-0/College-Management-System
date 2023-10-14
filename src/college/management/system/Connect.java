package college.management.system;

import java.sql.*;

    public class Connect {
      Connection c;
      Statement st;

      Connect() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagementsystem","root","");
            st = c.createStatement();
            
            System.out.println("Connected to the database successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}