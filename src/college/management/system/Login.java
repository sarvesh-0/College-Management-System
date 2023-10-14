
package college.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    private JButton btn ,c_btn;
    private JTextField txt_u;
    private JPasswordField pwd;
    private JLabel lbl;
    Connect c;
   
    
    Login(){
        getContentPane().setBackground(Color.WHITE);                           //java.awt.Color
        
        setLayout(null);
       
        lbl = new JLabel("USERNAME : ");
        lbl.setBounds(220,30,150,30);
        this.add(lbl);
        
        txt_u = new JTextField();
        txt_u.setBounds(320,30,200,30);
        this.add(txt_u);
        
        lbl = new JLabel("PASSWORD : ");
        lbl.setBounds(220,90,150,30);
        this.add(lbl);
        
        pwd = new JPasswordField();
        pwd.setBounds(320,90,200,30);
        this.add(pwd);
        
        btn = new JButton("LOG IN");
        btn.setBounds(220,150,140,30);
        this.add(btn);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Calibri", Font.BOLD,15));
        btn.addActionListener(this);                                           // Listener
        
        c_btn = new JButton("CANCLE");
        c_btn.setBounds(380,150,140,30);
        this.add(c_btn);
        c_btn.setBackground(Color.BLACK);
        c_btn.setForeground(Color.WHITE);
        c_btn.setFont(new Font("Calibri", Font.BOLD,15));
        c_btn.addActionListener(this);                                         // Listener
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        javax.swing.JLabel image = new javax.swing.JLabel(i3);
        add(image);
        image.setBounds(10,10,200,200);
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btn){                                               //Login
            String uname = txt_u.getText();
            String pass = pwd.getText();
            
            String query = "Select * from login where username='"+uname+"' and pwd='"+pass+"'";
            try{
                  c = new Connect();
                  ResultSet rs = c.st.executeQuery(query);
                  
                if (rs.next()){
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password, TRY AGAIN !");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                  c.c.close();  
                }catch(Exception e){
                    e.printStackTrace();
                }
            }    
        }
        else if(ae.getSource() == c_btn){                                        //Cancel
            setVisible(false);
        }
    }
    
    public static void main (String[] args){
        new Login();
    }
}
