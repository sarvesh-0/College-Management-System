package college.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(600, 450);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.gif"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,20, 180, 180);
        add(image);
        
        JLabel heading = new JLabel("<html>College<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Made by (SARVESH TEWARE)");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);
        
        JLabel cl = new JLabel("PRMIT&R Amravati-Badnera");
        cl.setBounds(70, 280, 550, 40);
        cl.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(cl);
        
        JLabel contact = new JLabel("Contact: sarveshteware651@gmail.com");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);
        
        setLayout(null);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
