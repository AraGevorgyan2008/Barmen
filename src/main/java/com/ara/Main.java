package com.ara;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    private static JPanel contentPanel1 ;
    private static JPanel contentPanel2 ;
    private static JPanel contentPanel3 ;
    private static JPanel contentPanel4 ;
    public static void JavaSwingVisualCode() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Java Swing Visual Code");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLayout(new BorderLayout());

        // Creating navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setPreferredSize(new Dimension(800, 141));
        navPanel.setBackground(Color.decode("#2F6541"));
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        JLabel pText = new JLabel("Armath");
        pText.setForeground(Color.WHITE);
        pText.setAlignmentX(Component.CENTER_ALIGNMENT);
        navPanel.add(pText);

        JLabel hText = new JLabel("Erevan");
        hText.setForeground(Color.WHITE);
        hText.setAlignmentX(Component.CENTER_ALIGNMENT);
        navPanel.add(hText);

        JPanel logSortPanel = new JPanel();
        logSortPanel.setBackground(Color.decode("#2F6541"));
        logSortPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton toggleMenuButton = new JButton("Toggle Menu");
        toggleMenuButton.setPreferredSize(new Dimension(100, 40)); // Set preferred size as per your requirement
        logSortPanel.add(toggleMenuButton);

        JLabel drinkMixRLabel = new JLabel("DrinkMixR");
        drinkMixRLabel.setForeground(Color.WHITE);
        logSortPanel.add(drinkMixRLabel);

        ImageIcon logoIcon = new ImageIcon("") ;// Replace with your actual logo path
        JLabel logoLabel = new JLabel(logoIcon);
        logSortPanel.add(logoLabel);

        navPanel.add(logSortPanel);

        jFrame.add(navPanel, BorderLayout.NORTH);

        for (int i = 0 ; i < 100 ; i++){
            Xmichqner xmichq = new Xmichqner("Cola",100,"voch alcoholayin",new ArrayList<>(10),false,false,1,"coca",true,false);
            contentPanel1 = new JPanel();
            contentPanel1.setBackground(Color.decode("#56753E"));
            contentPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
            JPanel productBox = new JPanel();
            productBox.setPreferredSize(new Dimension(100, 200));
            productBox.setBackground(Color.decode("#56753E"));
            productBox.setLayout(new BoxLayout(productBox, BoxLayout.Y_AXIS));

            ImageIcon logoIcon1 = new ImageIcon("C:\\Users\\intech\\Downloads\\coca cola.jpg");
            Image img = logoIcon1.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
// Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
            JLabel image1 = new JLabel(resizedIcon);
            productBox.add(image1);
             JLabel name = new JLabel(xmichq.getName());
            JLabel description = new JLabel(xmichq.getDescription());
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,1,1));
            buttonPanel.setBackground(Color.decode("#56753E"));
            JButton buyButton = new JButton("Buy");
            buttonPanel.add(Box.createHorizontalGlue());
            buttonPanel.add(name);// Pushes the button to the right
            buttonPanel.add(description);// Pushes the button to the right
            buttonPanel.add(buyButton);
            productBox.add(buttonPanel, BorderLayout.SOUTH);
            contentPanel1.add(productBox);
        }

        jFrame.add(contentPanel1, BorderLayout.WEST);



        jFrame.setVisible(true);
    }
    public static void product1(){
        contentPanel1 = new JPanel();
        contentPanel1.setBackground(Color.decode("#56753E"));
        contentPanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        JPanel productBox = new JPanel();
        productBox.setPreferredSize(new Dimension(100, 200));
       productBox.setBackground(Color.decode("#56753E"));
        productBox.setLayout(new BoxLayout(productBox, BoxLayout.Y_AXIS));

        ImageIcon logoIcon1 = new ImageIcon("https://www.encopadebalon.com/3505-large_default/sprite-tin-24-x-330ml.jpg");
        Image img = logoIcon1.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
// Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
        JLabel image1 = new JLabel(resizedIcon);
        productBox.add(image1);

        JPanel buttonPanel = new JPanel(new FlowLayout(100,20,5));
        buttonPanel.setBackground(Color.decode("#56753E"));
        JButton buyButton = new JButton("Buy");
        buttonPanel.add(Box.createHorizontalGlue()); // Pushes the button to the right
        buttonPanel.add(buyButton);
        productBox.add(buttonPanel, BorderLayout.SOUTH);

        contentPanel1.add(productBox);
    }
    public static void product2(){
        contentPanel2 = new JPanel();
        contentPanel2.setBackground(Color.decode("#56753E"));
        contentPanel2.setLayout(new FlowLayout(10, 5, 20));
        JPanel productBox1 = new JPanel();
        productBox1.setPreferredSize(new Dimension(100, 200));
        productBox1.setBackground(Color.decode("#56753E"));
        productBox1.setLayout(new BoxLayout(productBox1, BoxLayout.Y_AXIS));

        ImageIcon logoIcon1 = new ImageIcon("C:\\Users\\intech\\Downloads\\pepsi.jpg");
        Image img = logoIcon1.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
// Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
        JLabel image1 = new JLabel(resizedIcon);
        productBox1.add(image1);

        JPanel buttonPanel = new JPanel(new FlowLayout(100,20,5));
        buttonPanel.setBackground(Color.decode("#56753E"));
        JButton buyButton = new JButton("Buy");
        buttonPanel.add(Box.createHorizontalGlue()); // Pushes the button to the right
        buttonPanel.add(buyButton);
        productBox1.add(buttonPanel, BorderLayout.SOUTH);

        contentPanel2.add(productBox1);
    }
    public static void product3(){
        contentPanel3 = new JPanel();
        contentPanel3.setBackground(Color.decode("#56753E"));
        contentPanel3.setLayout(new FlowLayout(5, 30, 20));
        JPanel productBox = new JPanel();
        productBox.setPreferredSize(new Dimension(100, 200));
        productBox.setBackground(Color.decode("#56753E"));
        productBox.setLayout(new BoxLayout(productBox, BoxLayout.Y_AXIS));

        ImageIcon logoIcon1 = new ImageIcon("C:\\Users\\intech\\Downloads\\coca cola.jpg");
        Image img = logoIcon1.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
// Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
        JLabel image1 = new JLabel(resizedIcon);
        productBox.add(image1);

        JPanel buttonPanel = new JPanel(new FlowLayout(100,20,5));
        buttonPanel.setBackground(Color.decode("#56753E"));
        JButton buyButton = new JButton("Buy");
        buttonPanel.add(Box.createHorizontalGlue()); // Pushes the button to the right
        buttonPanel.add(buyButton);
        productBox.add(buttonPanel, BorderLayout.SOUTH);

        contentPanel3.add(productBox);
    }
    public static void product4(){
        contentPanel4 = new JPanel();
        contentPanel4.setBackground(Color.decode("#56753E"));
        contentPanel4.setLayout(new FlowLayout(10, 15, 20));
        JPanel productBox1 = new JPanel();
        productBox1.setPreferredSize(new Dimension(100, 200));
        productBox1.setBackground(Color.decode("#56753E"));
        productBox1.setLayout(new BoxLayout(productBox1, BoxLayout.Y_AXIS));

        ImageIcon logoIcon1 = new ImageIcon("C:\\Users\\intech\\Downloads\\coca cola.jpg");
        Image img = logoIcon1.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
// Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
        JLabel image1 = new JLabel(resizedIcon);
        productBox1.add(image1);

        JPanel buttonPanel = new JPanel(new FlowLayout(100,20,5));
        buttonPanel.setBackground(Color.decode("#56753E"));
        JButton buyButton = new JButton("Buy");
        buttonPanel.add(Box.createHorizontalGlue()); // Pushes the button to the right
        buttonPanel.add(buyButton);
        productBox1.add(buttonPanel, BorderLayout.SOUTH);

        contentPanel4.add(productBox1);
    }


    public static void main(String[] args) {
        JavaSwingVisualCode();
    }

    }
