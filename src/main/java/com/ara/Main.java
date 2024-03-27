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
    /*    private static JPanel contentPanel2 ;
        private static JPanel contentPanel3 ;
        private static JPanel contentPanel4 ;*/
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


        /*ImageIcon loadingIcon = new ImageIcon("src\\Nkarner\\loading-thinking.gif");
        ImageIcon loadingicon = resizeImageIcon(loadingIcon,200,200);
        JLabel labelLoading = new JLabel(loadingicon);*/
        JLabel gna = new JLabel("Ալկոհոլ կարելի է պատվիրել միայն Appication-ով");
        gna.setFont(new Font("Arial",Font.ITALIC,30));
        JButton ok = new JButton("OK");
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
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 110));
        navPanel.setBackground(new Color(80, 225, 225));




        karlenickpac = new JFrame();

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

                        if(topic.equals(topic6)) {
                            karlenickpac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            karlenickpac.setBounds(450, 250, 500, 250);
                            JPanel panel = new JPanel();
                            JLabel lcvume = new JLabel("Սպասեք մինչև կլցվի");
                            lcvume.setFont(new Font("Arial", Font.ITALIC, 30));
                            karlenickpac.setLayout(new BorderLayout());
                            panel.add(lcvume);
                            karlenickpac.add(panel);
                            String info = new String(message.getPayload());
                            if (info.equals("True")) {
                                System.out.println(5);
                                karlenickpac.setVisible(true);
                            }
                            else {
                                System.out.println(1);
                                karlenickpac.setVisible(false);
                                System.out.println(2);
                            }
                        }
                        if (topic.equals(topic1)) {
                            a = new JPanel();
                            a.setPreferredSize(new Dimension(1200,650));
                            a.setBackground(new Color(80, 250, 225));
                            System.out.println("topic: " + topic);
                            System.out.println("qos: " + message.getQos());
                            String info1 = new String(message.getPayload());
                            ObjectMapper objectMapper = new ObjectMapper();
                            List<Xmichqner> list = objectMapper.readValue(info1, new TypeReference<List<Xmichqner>>() {
                            });

                            for (int i = 0; i < list.size(); i++) {

                                Xmichqner xmichq = list.get(i);
                                contentPanel1 = new JPanel();

                                JPanel productBox = new JPanel();
                                productBox.setPreferredSize(new Dimension(150, 290));
                                productBox.setBackground(new Color(70, 224, 205));
                                productBox.setLayout(new BoxLayout(productBox, BoxLayout.PAGE_AXIS));

                                JPanel imagepanel = new JPanel();
                                imagepanel.setPreferredSize(new Dimension(100, 100));
                                imagepanel.setBackground(new Color(188, 250, 183));

                                ImageIcon logoIcon1 = new ImageIcon("src\\Nkarner\\" + xmichq.getImg());
                                Image img = logoIcon1.getImage().getScaledInstance(200, 215, Image.SCALE_FAST);
// Create a new ImageIcon with the resized image
                                ImageIcon resizedIcon = new ImageIcon(img);
// Create a JLabel with the resized image
                                JLabel image1 = new JLabel(resizedIcon);

                                imagepanel.add(image1);


                                JButton buyButton = new JButton("Buy");
                                JLabel name = new JLabel(xmichq.getName());
                                name.setBackground(Color.BLACK);

                                JLabel price = new JLabel(String.valueOf(xmichq.getPrice()));
                                price.setBackground(Color.BLACK);
                                JLabel description = new JLabel(xmichq.getDescription());
                                description.setBackground(Color.BLACK);


                                buyButton.addActionListener(new ActionListener() {
                                    @SneakyThrows
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        if (xmichq.isAlcho()) {

                                            gnaAppication.setVisible(true);
                                            ok.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    gnaAppication.setVisible(false);
                                                }
                                            });


                                        } else {
                                            MqttMessage id = new MqttMessage(xmichq.getDrink_id().getBytes());
                                            id.setQos(0);
                                            client.publish(topic5, id);
                                            loading.setVisible(true);
                                        }
                                    }
                                });
                                productBox.add(imagepanel);
                                productBox.add(name);
                                productBox.add(price);
                                productBox.add(description);
                                productBox.add(buyButton);

                                a.add(productBox);

                                /*a.add(contentPanel1);*/
                                navPanel.add(a);
                            }
                            jFrame.revalidate(); // Refresh layout
                            jFrame.repaint();
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