package com.ara;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Main {
    private static JPanel contentPanel1;
    private static JPanel contentPanel2;
    private static JPanel contentPanel3;
    private static JPanel contentPanel4;

    @SneakyThrows
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

        ImageIcon logoIcon = new ImageIcon("");// Replace with your actual logo path
        JLabel logoLabel = new JLabel(logoIcon);
        logSortPanel.add(logoLabel);

        navPanel.add(logSortPanel);

        jFrame.add(navPanel, BorderLayout.NORTH);

        // Create a panel to hold all the product panels
        JPanel a = new JPanel(new FlowLayout(FlowLayout.LEFT));
        a.setBackground(Color.decode("#56753E"));
        ServerSocket serverSocket = new ServerSocket(9999);
Gson gson = new Gson();
        System.out.println("Spasum em ");
        Socket peer2socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(peer2socket.getInputStream()));
        PrintWriter out = new PrintWriter(peer2socket.getOutputStream(),true);

        String s = in.readLine();
        Xmichqner xmichq1 = gson.fromJson(s, Xmichqner.class);
        out.println(0);
        // Loop to create product panels
        for (int i = 0; i < 100; i++) {

            Xmichqner xmichq = xmichq1;

            JPanel productPanel = new JPanel();
            productPanel.setPreferredSize(new Dimension(130, 260));
            productPanel.setBackground(Color.decode("#56753E"));
            productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));

            ImageIcon logoIcon1 = new ImageIcon(xmichq.getImg());
            Image img = logoIcon1.getImage().getScaledInstance(70, 200, Image.SCALE_AREA_AVERAGING);
            // Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(img);
            // Create a JLabel with the resized image
            JLabel image1 = new JLabel(resizedIcon);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 1, 1));
            buttonPanel.setBackground(Color.decode("#56753E"));
            JButton buyButton = new JButton("Buy");
            int w = Integer.parseInt(in.readLine());
            System.out.println(w);
            
             buyButton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     out.println(1);
                     if (xmichq.isAlcho()) {
                         System.out.println("Alcoholic karox eq ogtvel miayn appicationov");
                     }else {
                         out.println(xmichq.getDrink_id());
                     }
                 }
             });
            JLabel name = new JLabel(xmichq.getName());
            JLabel description = new JLabel(xmichq.getDescription());

            buttonPanel.add(buyButton);
            productPanel.add(image1);
            productPanel.add(name);
            productPanel.add(description);
            productPanel.add(buttonPanel);

            // Add product panel to the container
            a.add(productPanel);

        }

        // Wrap the product panel container in a JScrollPane
         jFrame.add(a);
        jFrame.setVisible(true);
in.close();
out.close();

peer2socket.close();
serverSocket.close();
    }
    private static class buttonclic implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    public static void main(String[] args) {
        JavaSwingVisualCode();
    }
}
