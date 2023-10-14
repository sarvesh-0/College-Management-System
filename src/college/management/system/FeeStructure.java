package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    Connect c;
    FeeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JTable table = new JTable();
        
        try {
            c = new Connect();
            ResultSet rs = c.st.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                c.c.close();  
            }catch(Exception e){
                e.printStackTrace();
            }  
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}
