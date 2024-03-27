package com.ara;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Gif {
    public static void main(String[] args) {
  /*      Scanner mutq = new Scanner(System.in);
        List<String> list = List.of("Mojito", "Cola", "Pepsi", "Viski");
        String a = mutq.nextLine();
        List<String> collect = list.stream()
                .filter(e -> e.contains(a))
                .peek(System.out::println)
                .collect(Collectors.toList());*/

        String broker = "tcp://soldier.cloudmqtt.com:12147";
        String clientId = "client";
        String topic1 = "topic1";
        String topic6 = "topic6";
        String topic5 = "topic5";
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

                        if (topic.equals(topic1)) {
                            System.out.println("topic: " + topic);
                            System.out.println("qos: " + message.getQos());
                            String info1 = new String(message.getPayload());
                            ObjectMapper objectMapper = new ObjectMapper();
                            List<Xmichqner> list = objectMapper.readValue(info1, new TypeReference<List<Xmichqner>>() {
                            });
                            System.out.println(list);
                            List<Xmichqner> a1 = list.stream()
                                    .filter(a -> a.getName().contains("Fanta"))
                                    .peek(System.out::println)
                                    .collect(Collectors.toList());
                            System.out.println(a1);

                        }
                    }

                    public void connectionLost(Throwable cause) {
                        System.out.println("connectionLost: " + cause.getMessage());
                    }

                    public void deliveryComplete(IMqttDeliveryToken token) {
                        System.out.println("deliveryComplete: " + token.isComplete());
                    }
                });

                client.subscribe(topic1, subQos);
                client.subscribe(topic6, 0);
                client.subscribe(topic5, 0);
            }



        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
    /*
    User
package com.ara;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.scene.image.ImageView;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.*;
import org.ietf.jgss.GSSName;

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

import static java.awt.Color.white;
import static java.awt.SystemColor.info;

public class Main {
    private static JPanel contentPanel1 ;
    private static JPanel a ;
    private static JFrame jFrame;
    private static JFrame karlenickpac;
        private static JPanel contentPanel2 ;
        private static JPanel contentPanel3 ;
        private static JPanel contentPanel4 ;
    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the Image from ImageIcon
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT); // Scale the image
        return new ImageIcon(scaledImage); // Return a new ImageIcon with the scaled image
    }
    @SneakyThrows
    public static void JavaSwingVisualCode() {
// loading jFrame
        JFrame loading = new JFrame("Loading...");
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setUndecorated(true);
        loading.setBounds(450,250,500,250);
        loading.setLayout(new BorderLayout());
        JPanel panelloading = new JPanel();
        ImageIcon loadingIcon = new ImageIcon("src\\Nkarner\\loading-thinking.gif");
        ImageIcon loadingicon = resizeImageIcon(loadingIcon,200,200);
        JLabel labelLoading = new JLabel(loadingicon);
        JLabel lcvume = new JLabel("Սպասեք մինչև կլցվի");
        lcvume.setFont(new Font("Arial",Font.ITALIC,30));

        panelloading.add(labelLoading);
        panelloading.add(lcvume);
        loading.add(panelloading);
        ////////////////////////////////////

        // gna Appication
        JFrame gnaAppication = new JFrame("Loading...");
        gnaAppication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gnaAppication.setBounds(350,250,730,130);
        gnaAppication.setLayout(new BorderLayout());
        JPanel panellgna = new JPanel();


        ImageIcon loadingIcon = new ImageIcon("src\\Nkarner\\loading-thinking.gif");
        ImageIcon loadingicon = resizeImageIcon(loadingIcon,200,200);
        JLabel labelLoading = new JLabel(loadingicon);
        JLabel gna = new JLabel("Ալկոհոլ կարելի է պատվիրել միայն Appication-ով");
        gna.setFont(new Font("Arial",Font.ITALIC,30));
        Button ok = new Button("OK");
        ok.setFont(new Font("Arial",Font.ITALIC,30));
        panellgna.add(gna);
        panellgna.add(ok);
        gnaAppication.add(panellgna);

        ////////////////////////////
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

        karlenickpac = new JFrame();




}



     */
}
