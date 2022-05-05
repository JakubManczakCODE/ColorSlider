package com.company;
import javax.swing.*;
import java.awt.*;

public class Paint2 extends JPanel {
    private Color color1 = new Color(0,0,0);
    private Color color2 = new Color(0,0,0);

    Paint2(){
        this.setPreferredSize(new Dimension(200, 200));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color1);
        g2.fillRect(0,0,200,200);
        g2.setColor(color2);
        g2.fillRect(50,50,100,100);

        repaint();






    }
    public void setColorBack(Color color){
        this.color1 = color;


    }
    public void setColorText(Color color){
        this.color2 = color;


    }

}