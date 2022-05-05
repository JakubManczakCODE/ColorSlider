package com.company;
//s22492
import javax.swing.*;
import java.awt.*;

public class Paint extends JPanel {
    Color color1 = new Color(0,0,0);
    Color color2 = new Color(0,0,0);

        Paint(){
            this.setPreferredSize(new Dimension(200, 200));
        }
    @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color1);
        g2.fillRect(0,0,100,100);
        g2.fillRect(100,100,100,100);
        g2.setColor(color2);
        g2.fillRect(0,100,100,100);
        g2.fillRect(100,0,100,100);
        repaint();






    }
    public void setColorBack(Color color){
            this.color1 = color;


    }
    public void setColorText(Color color){
       this.color2 = color;


    }

}
