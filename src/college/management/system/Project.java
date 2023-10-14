
package college.management.system;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    Project(){
        
        setSize(1540,850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);       
        javax.swing.JLabel image = new javax.swing.JLabel(i3);
        add(image);

        String[] mb = {"New Information ","View Details ","Update Details ","Fee Details ","Examinations ","Apply Leave ","Leave Details ","Utility ","Exit "};
        String[][] mb_items = {{"New Student Information","New Faculty Information"},
                {"View Student Details","View Faculty Details"},
                {"Update Student Details","Update Faculty Details"},
                {"About","Fee Structure","Fee form"},{"Enter Marks","Examination Result"},
                {"Student Leave","Faculty Leave"},
                {"View Student Leave","View Faculty Leave"},
                {"Notepad","Calculator"},{"EXIT"}};
        Font big = new Font("Verdana", Font.PLAIN, 16);
        JMenuBar menuBar = new JMenuBar();
        JMenu[] menus;
        ArrayList<ArrayList<JMenuItem>> menuItems = new ArrayList<ArrayList<JMenuItem>>();

    
        menus = new JMenu[mb.length];

        for (int i=0;i<mb.length;i++){
            menus[i]= new JMenu(mb[i]);
            menuItems.add(new ArrayList<JMenuItem>());
            
            for(int j=0;j<mb_items[i].length;j++){
                menuItems.get(i).add(new JMenuItem(mb_items[i][j]));
                menus[i].add(menuItems.get(i).get(j)).addActionListener(this);
                menus[i].setFont(big);
                menus[i].setForeground(Color.WHITE);
            }

            menuBar.add(menus[i]);
       }
        menuBar.setBackground(Color.BLACK);
//        JMenu exit = new JMenu("Exit");
//        menuBar.add(exit);
//        exit.addActionListener(this);

        setJMenuBar(menuBar);
        setVisible(true);
}
        @Override
        public void actionPerformed(ActionEvent ae){
        String submenu = ae.getActionCommand();
        switch(submenu){
            
            case "New Student Information":
                new AddStudent();
                break;
                
            case "New Faculty Information":
                new AddTeacher();
                break;
                
            case "View Student Details":
                new StudentDetails();
                break;
                
            case "View Faculty Details":
                new TeacherDetails();
                break;
                
            case "Update Student Details":
                new UpdateStudent();
                break;
                
            case "Update Faculty Details":
                new UpdateTeacher();
                break;
                
            case "Fee Structure":
                new FeeStructure();
                break;
                
            case "Fee form":
                new StudentFeeForm();
                break;
                
            case "About":
                new About();
                break;
                
            case "Student Leave":
                new StudentLeave();
                break;
                
            case "Faculty Leave":
                new TeacherLeave();
                break;
                
            case "View Student Leave":
                new StudentLeaveDetails();
                break;
                
            case "View Faculty Leave":
                new TeacherLeaveDetails();
                break;
                
            case "Examination Result":
                new ExaminationDetails();
                break;
                
            case "Enter Marks":
                new EnterMarks();
                break;
                
            case "EXIT":
                setVisible(false);
                break;
                
            case "Notepad":
                try{
                    Runtime.getRuntime().exec("notepad.exe");
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
                
            case "Calculator":
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            
        }
        }
    
    
    public static void main(String[] args){
        new Project();
    }
}
