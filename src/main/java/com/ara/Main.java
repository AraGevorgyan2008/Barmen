package com.ara;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static JPanel contentPanel1 ;
/*    private static JPanel contentPanel2 ;
    private static JPanel contentPanel3 ;
    private static JPanel contentPanel4 ;*/
    @SneakyThrows
    public static void JavaSwingVisualCode() {
        CountDownLatch latch = new CountDownLatch(1);
        Gson gson = new Gson();
        JFrame jFrame = new JFrame();
        JFrame loading = new JFrame("Loading...");
        loading.setSize(200,100);
        loading.setBounds(500,300,500,150);
        loading.setLayout(new BorderLayout());
        JPanel panelloading = new JPanel();
        JLabel labelLoading = new JLabel("Loading...");
        labelLoading.setFont(new Font("Arial",Font.ITALIC,50));

        panelloading.add(labelLoading);
        loading.add(panelloading);
        loading.setVisible(true);
        jFrame.setTitle("Java Swing Visual Code");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 600);
        jFrame.setLayout(new BorderLayout());

        // Creating navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setPreferredSize(new Dimension(800, 141));
        navPanel.setBackground(new Color(188, 250, 183));
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
        logSortPanel.setBackground(new Color(188, 250, 183));
        logSortPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton toggleMenuButton = new JButton("Toggle Menu");
        toggleMenuButton.setPreferredSize(new Dimension(100, 40)); // Set preferred size as per your requirement
        logSortPanel.add(toggleMenuButton);

        JLabel drinkMixRLabel = new JLabel("DrinkMixR");
        drinkMixRLabel.setForeground(Color.WHITE);
        logSortPanel.add(drinkMixRLabel);

        ImageIcon logoIcon = new ImageIcon("") ;
        JLabel logoLabel = new JLabel(logoIcon);
        logSortPanel.add(logoLabel);

        navPanel.add(logSortPanel);

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket peer2Socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(peer2Socket.getInputStream()));
        PrintWriter out = new PrintWriter(peer2Socket.getOutputStream(), true);


        jFrame.add(navPanel, BorderLayout.NORTH);
        JPanel a = new JPanel();
        a.setBackground(new Color(248,252,238));
        /*Xmichqner xmichq = gson.fromJson(in.readLine(), Xmichqner.class);*/
        loading.setVisible(false);
             String q = in.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Xmichqner> list =  objectMapper.readValue(q, new TypeReference<List<Xmichqner>>() {});
        for (int i = 0 ; i < list.size() ; i++){
            Xmichqner xmichq = list.get(i);

            contentPanel1 = new JPanel();
            contentPanel1.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
            contentPanel1.setBackground(new Color(248,252,238));
            JPanel productBox = new JPanel();
            productBox.setPreferredSize(new Dimension(130, 300));
            productBox.setBackground(new Color(248,252,238));
            productBox.setLayout(new BoxLayout(productBox, BoxLayout.PAGE_AXIS));

            JPanel imagepanel = new JPanel();
            imagepanel.setPreferredSize(new Dimension(70,200));
            imagepanel.setBackground(new Color(248,252,238));

            ImageIcon logoIcon1 = new ImageIcon( "C:\\Users\\intech\\IdeaProjects\\Barmen2\\src\\Nkarner\\" + xmichq.getImg());
            Image img = logoIcon1.getImage().getScaledInstance(70, 200, Image.SCALE_AREA_AVERAGING);
// Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
            JLabel image1 = new JLabel(resizedIcon);

            imagepanel.add(image1);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,1,1));
            buttonPanel.setBackground(new Color(248,252,238));
            JButton buyButton = new JButton("Buy");
            JLabel name = new JLabel(xmichq.getName());
            JLabel price = new JLabel(String.valueOf(xmichq.getPrice()));
            JLabel description = new JLabel(xmichq.getDescription());
            buttonPanel.add(Box.createHorizontalGlue());

buyButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        if (xmichq.isAlcho()){
            System.out.println("Alcholi hamar mtnel aplication");
        }else {


            out.println(xmichq.getDrink_id());

        }
    }
});
            buttonPanel.add(buyButton);
            productBox.add(imagepanel);
            productBox.add(name);
            productBox.add(price);
            productBox.add(description);
            productBox.add(buttonPanel, BorderLayout.CENTER);

            contentPanel1.add(productBox);

            a.add(contentPanel1);
        }

        jFrame.add(a );
    /*    jFrame.add(contentPanel2, BorderLayout.CENTER);
        jFrame.add(contentPanel3, BorderLayout.EAST);
        jFrame.add(contentPanel4, BorderLayout.SOUTH);*/

        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JavaSwingVisualCode();
    }
}
