package college.management.system;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;


public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 560, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        javax.swing.JLabel image = new javax.swing.JLabel(i3);
        add(image,BorderLayout.CENTER);
        
        javax.swing.JLabel clgName = new javax.swing.JLabel("PRMIT&R AMRAVATI");
        javax.swing.JPanel p1 = new javax.swing.JPanel();
        p1.setPreferredSize(new Dimension(150, 40));        
        this.add(p1,BorderLayout.NORTH);
        clgName.setFont(new Font("Calibri", Font.BOLD,40));
        p1.add(clgName,BorderLayout.SOUTH);
        
        
        t = new Thread(this);
        t.start();
                
        setVisible(true);
        int x = 1;
        for (int i=2; i<=600; i+=4, x+=1){
            setLocation(600-((i+x)/2),350-(i/2));
            setSize(i+3*x,i+x/2);
            
            try{
                Thread.sleep(3);
            } catch(Exception e){}
        }
    }
    
    @Override
    public void run() {
        try{
            Thread.sleep(4000);
            setVisible(false);
            
            //NextFrame
            new Login();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new Splash();
    }
}

    
  

