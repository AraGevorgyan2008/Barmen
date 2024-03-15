package com.ara;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.scene.image.ImageView;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.*;

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

import static java.awt.SystemColor.info;

public class Main {
    private static JPanel contentPanel1 ;
    private static JPanel a ;
    private static JFrame jFrame;
    /*    private static JPanel contentPanel2 ;
        private static JPanel contentPanel3 ;
        private static JPanel contentPanel4 ;*/
    public static void Mqtt(List<Xmichqner> list){

    }
    @SneakyThrows
    public static void JavaSwingVisualCode() {

        JFrame loading = new JFrame("Loading...");
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setUndecorated(true);
        loading.setBounds(450,250,500,250);
        loading.setLayout(new BorderLayout());
        JPanel panelloading = new JPanel();
        ImageIcon loadingIcon = new ImageIcon("C:\\Users\\intech\\IdeaProjects\\Barmen2\\src\\Nkarner\\Spinner-1s-200px.gif");
        JLabel labelLoading = new JLabel(loadingIcon);
        JLabel lcvume = new JLabel("Սպասեք մինչև կլցվի");
        lcvume.setFont(new Font("Arial",Font.ITALIC,30));

        panelloading.add(labelLoading);
        panelloading.add(lcvume);
        loading.add(panelloading);
        jFrame = new JFrame();
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setTitle("Java Swing Visual Code");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setLayout(new BorderLayout());

        // Creating navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setPreferredSize(new Dimension(800, 141));
        navPanel.setBackground(new Color(188, 250, 183));
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));

        JLabel pText = new JLabel("Armath");
        pText.setForeground(Color.RED);
        pText.setAlignmentX(Component.CENTER_ALIGNMENT);
        navPanel.add(pText);

        JLabel hText = new JLabel("Erevan");
        hText.setForeground(Color.BLACK);
        hText.setAlignmentX(Component.CENTER_ALIGNMENT);
        navPanel.add(hText);

        JPanel logSortPanel = new JPanel();
        logSortPanel.setBackground(new Color(188, 250, 183));
        logSortPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton toggleMenuButton = new JButton("Toggle Menu");
        toggleMenuButton.setPreferredSize(new Dimension(100, 40)); // Set preferred size as per your requirement
        logSortPanel.add(toggleMenuButton);

        JLabel drinkMixRLabel = new JLabel("DrinkMixR");
        drinkMixRLabel.setForeground(Color.BLACK);
        logSortPanel.add(drinkMixRLabel);

        ImageIcon logoIcon = new ImageIcon("") ;
        JLabel logoLabel = new JLabel(logoIcon);
        logSortPanel.add(logoLabel);

        navPanel.add(logSortPanel);





        String broker = "tcp://soldier.cloudmqtt.com:12147";
        String clientId = "client";
        String topic = "topic1";
        String topic2 = "topic2";
        int subQos = 1;
        int pubQos = 1;
        try {
            MqttClient client = new MqttClient(broker, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName("fqakeccp");
            options.setPassword("ryNhh1ECFYRZ".toCharArray());
            options.setCleanSession(true);

// Set the heartbeat interval in seconds
            options.setKeepAliveInterval(300);

// Set the connection timeout in seconds
            options.setConnectionTimeout(30);

// Set whether to automatically reconnect
            options.setAutomaticReconnect(true);
            client.connect(options);

            if (client.isConnected()) {
                client.setCallback(new MqttCallback() {
                    public void messageArrived(String topic, MqttMessage message) throws Exception {
                        a = new JPanel();
                        a.setBackground(new Color(188, 250, 183));
                        System.out.println("topic: " + topic);
                        System.out.println("qos: " + message.getQos());
                        String info = new String(message.getPayload());
                        ObjectMapper objectMapper = new ObjectMapper();
                        List<Xmichqner> list =  objectMapper.readValue(info, new TypeReference<List<Xmichqner>>() {});
                        for (int i = 0 ; i < list.size() ; i++){

                            Xmichqner xmichq = list.get(i);
                            contentPanel1 = new JPanel();
                            contentPanel1.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
                            contentPanel1.setBackground(new Color(188, 250, 183));
                            JPanel productBox = new JPanel();
                            productBox.setPreferredSize(new Dimension(130, 300));
                            productBox.setBackground(new Color(188, 250, 183));
                            productBox.setLayout(new BoxLayout(productBox, BoxLayout.PAGE_AXIS));

                            JPanel imagepanel = new JPanel();
                            imagepanel.setPreferredSize(new Dimension(70,200));
                            imagepanel.setBackground(new Color(188, 250, 183));

                            ImageIcon logoIcon1 = new ImageIcon( "C:\\Users\\intech\\IdeaProjects\\Barmen2\\src\\Nkarner\\" + xmichq.getImg());
                            Image img = logoIcon1.getImage().getScaledInstance(70, 200, Image.SCALE_AREA_AVERAGING);
// Create a new ImageIcon with the resized image
                            ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
                            JLabel image1 = new JLabel(resizedIcon);

                            imagepanel.add(image1);

                            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,1,1));
                            buttonPanel.setBackground(new Color(188, 250, 183));
                            JButton buyButton = new JButton("Buy");
                            JLabel name = new JLabel(xmichq.getName());
                            name.setBackground(Color.BLACK);
                            JLabel price = new JLabel(String.valueOf(xmichq.getPrice()));
                            price.setBackground(Color.BLACK);
                            JLabel description = new JLabel(xmichq.getDescription());
                            description.setBackground(Color.BLACK);
                            buttonPanel.add(Box.createHorizontalGlue());

                            buyButton.addActionListener(new ActionListener() {
                                @SneakyThrows
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    if (xmichq.isAlcho()){
                                        loading.setVisible(false);
                                        System.out.println("Alcholi hamar mtnel aplication");
                                    }else {
                                        MqttMessage id = new MqttMessage(xmichq.getDrink_id().getBytes());
                                        client.publish(topic2,id);
                                        loading.setVisible(true);
                                    }
                                }
                            });
                            buttonPanel.add(buyButton);
                            productBox.add(imagepanel);
                            productBox.add(name);
                            productBox.add(price);
                            productBox.add(description);
                            productBox.add(buttonPanel);

                            contentPanel1.add(productBox);

                            a.add(contentPanel1);
                            navPanel.add(a);
                        }

                    }

                    public void connectionLost(Throwable cause) {
                        System.out.println("connectionLost: " + cause.getMessage());
                    }

                    public void deliveryComplete(IMqttDeliveryToken token) {
                        System.out.println("deliveryComplete: " + token.isComplete());
                    }
                });

                client.subscribe(topic, subQos);
            }



        } catch (MqttException e) {
            e.printStackTrace();
        }

        // MQtt kodna vereviny


/*        ServerSocket serverSocket = new ServerSocket(9999);
        Socket peer2Socket = serverSocket.accept();*/
/*        BufferedReader in = new BufferedReader(new InputStreamReader(peer2Socket.getInputStream()));
        PrintWriter out = new PrintWriter(peer2Socket.getOutputStream(), true);*/



        /*Xmichqner xmichq = gson.fromJson(in.readLine(), Xmichqner.class);*/







        jFrame.add(navPanel);

        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        JavaSwingVisualCode();
    }
}