package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Window extends JFrame {
    public Window(){
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Jakub Mańczak  kontakt.manczakkubapl@gmail.com");

        // Sliders

        JPanel sliderPanel1 = new JPanel();
        sliderPanel1.setLayout(new GridLayout(1,3,5,5));
        sliderPanel1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel sliderPanel2 = new JPanel();
        sliderPanel2.setLayout(new GridLayout(1,3,10,10));
        sliderPanel2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Text Panels

        JTextArea textArea1 = new JTextArea(1, 13);
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Arial", Font.BOLD, 13));


        JTextArea textArea2 = new JTextArea(1, 13);
        textArea2.setEditable(false);
        textArea2.setFont(new Font("Arial", Font.BOLD, 13));


        JTextArea textOut = new JTextArea(5, 20);
        textOut.setEditable(false);
        textOut.setFont(new Font("Arial", Font.BOLD, 20));
        textOut.setForeground(new Color(172,172,172));
        textOut.setBackground(new Color(172,172,172));
        textOut.setText("   \n\n Jakub Mańczak  kontakt.manczakkubapl@gmail.com");
        // Squares

        JPanel box1Panel = new JPanel();
        JPanel box2Panel = new JPanel();

        // Label values for Slider

        var valuesOfSlider = new Hashtable<Integer, JLabel>();
        valuesOfSlider.put(0, new JLabel("0"));
        valuesOfSlider.put(85, new JLabel("85"));
        valuesOfSlider.put(170, new JLabel("170"));
        valuesOfSlider.put(255, new JLabel("255"));

        // Slider initialize

        List<JSlider> backgroundColorsList = Arrays.asList(
                new JSlider(JSlider.VERTICAL, 0, 255, 172),
                new JSlider(JSlider.VERTICAL, 0, 255, 172),
                new JSlider(JSlider.VERTICAL, 0, 255, 172)
        );

        List<JSlider> textColorsList = Arrays.asList(
                new JSlider(JSlider.VERTICAL, 0, 255, 172),
                new JSlider(JSlider.VERTICAL, 0, 255, 172),
                new JSlider(JSlider.VERTICAL, 0, 255, 172)
        );

        // Slider Values Set

        var valuesOfBack = new Hashtable<Integer, Integer>();
        valuesOfBack.put(0,172);
        valuesOfBack.put(1,172);
        valuesOfBack.put(2,172);
        textArea1.setText("R: "+valuesOfBack.get(0)+" B: "+valuesOfBack.get(1) +" C: "+valuesOfBack.get(2));

        var valuesOfFront= new Hashtable<Integer, Integer>();
        valuesOfFront.put(0,172);
        valuesOfFront.put(1,172);
        valuesOfFront.put(2,172);
        textArea2.setText("R: "+valuesOfFront.get(0)+" B: "+valuesOfFront.get(1) +" C: "+valuesOfFront.get(2));

        // Slider Settings

        backgroundColorsList
                .forEach(slider -> {
                    slider.setMinorTickSpacing(10);
                    slider.setLabelTable(valuesOfSlider);
                    slider.setPaintLabels(true);
                    slider.setPaintTicks(true);

                });
        textColorsList
                .forEach(slider -> {
                    slider.setMinorTickSpacing(10);
                    slider.setLabelTable(valuesOfSlider);
                    slider.setPaintLabels(true);
                    slider.setPaintTicks(true);

                });

        // Color box initialize

        Paint paint = new Paint();
        Paint2 paint2 = new Paint2();
        paint.setColorBack(new Color(valuesOfBack.get(0),valuesOfBack.get(1),valuesOfBack.get(2)));
        paint2.setColorBack(new Color(valuesOfBack.get(0),valuesOfBack.get(1),valuesOfBack.get(2)));
        paint.setColorText(new Color(valuesOfFront.get(0),valuesOfFront.get(1),valuesOfFront.get(2)));
        paint2.setColorText(new Color(valuesOfFront.get(0),valuesOfFront.get(1),valuesOfFront.get(2)));

        // Change listener
        backgroundColorsList
                .forEach(slider -> slider.addChangeListener(e ->{
                    JSlider val = (JSlider) e.getSource();
                    valuesOfBack.put(backgroundColorsList.indexOf(slider),val.getValue());
                    textArea1.setText("R: "+valuesOfBack.get(0)+" B: "+valuesOfBack.get(1) +" C: "+valuesOfBack.get(2));
                    Color color = new Color(valuesOfBack.get(0),valuesOfBack.get(1),valuesOfBack.get(2));
                    paint.setColorBack(color);
                    paint2.setColorBack(color);
                    textOut.setBackground(color);



                        }));
        textColorsList
                .forEach(slider ->slider.addChangeListener(e -> {
                    JSlider val = (JSlider) e.getSource();
                    valuesOfFront.put(textColorsList.indexOf(slider),val.getValue());
                    textArea2.setText("R: "+valuesOfFront.get(0)+" B: "+valuesOfFront.get(1) +" C: "+valuesOfFront.get(2));
                    Color color = new Color(valuesOfFront.get(0),valuesOfFront.get(1),valuesOfFront.get(2));
                    paint.setColorText(color);
                    paint2.setColorText(color);
                    textOut.setForeground(color);


                }) );




        // Window App Setup

        for (JSlider jSlider : backgroundColorsList) {
            sliderPanel1.add(jSlider);
        }
        for (JSlider jSlider : textColorsList) {
            sliderPanel2.add(jSlider);
        }

        box1Panel.add(paint);
        box2Panel.add(paint2);


        gbc.insets=new Insets(5,5,5,5);


        gbc.gridx=0;
        gbc.gridy=0;
        add(box1Panel,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        add(box2Panel,gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        add(sliderPanel1,gbc);

        gbc.gridx=2;
        gbc.gridy=0;
        add(sliderPanel2,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.anchor=GridBagConstraints.NORTH;
        add(textArea1,gbc);


        gbc.gridx=2;
        gbc.gridy=1;
        gbc.anchor=GridBagConstraints.NORTH;
        add(textArea2,gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=2;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.CENTER;
        add(textOut,gbc);

        this.pack();
        this.setVisible(true);

    }
}



