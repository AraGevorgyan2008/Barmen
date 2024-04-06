package com.ara;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.scene.image.ImageView;
import lombok.SneakyThrows;
import org.eclipse.paho.client.mqttv3.*;
import org.ietf.jgss.GSSName;
import javax.swing.border.Border;
import java.awt.geom.RoundRectangle2D;
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
import java.util.Random;
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
        Gson json = new Gson();
        JFrame loading = new JFrame("Loading...");
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setUndecorated(true);
        loading.setBounds(450,250,500,250);
        loading.setLayout(new BorderLayout());
        JPanel panelloading = new JPanel();
        ImageIcon loadingIcon = new ImageIcon("src\\Nkarner\\1a.gif");
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
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 10));
        navPanel.setBackground(new Color(149, 185, 114));

                 Random random = new Random(10);
       JPanel imagepanel1 = new JPanel();
        imagepanel1.setPreferredSize(new Dimension(100, 100));
        imagepanel1.setBackground(new Color(109, 143, 64));
        JLabel text = new JLabel("DrinkMixer");
        text.setForeground(new Color(178, 203, 159));
        Font font = new Font("Georgia",Font.ITALIC,70);
         text.setFont(font);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
         imagepanel1.add(text);
        navPanel.setBackground(new Color(179, 224, 123));

        karlenickpac = new JFrame();

        String broker = "tcp://soldier.cloudmqtt.com:12147";
        String clientId = "client";
        String topic1 = "topic1";
        String topic6 = "topic6";
        String topic2 = "topic2";
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
                                karlenickpac.setVisible(true);
                            }
                            else {
                                karlenickpac.setVisible(false);
                            }
                        }
                        if(topic.equals(topic2)){
                            String info = new String(message.getPayload());
                            if (info.equals("False")){
                                loading.setVisible(false);
                            }
                        }
                        int qq = 0 ;
                        if (topic.equals(topic1)) {
                            a = new JPanel();
                            a.setPreferredSize(new Dimension(1200,650));
                            a.setBackground(new Color(165, 210, 104));
                            System.out.println("topic: " + topic);
                            System.out.println("qos: " + message.getQos());
                            String info1 = new String(message.getPayload());
                            ObjectMapper objectMapper = new ObjectMapper();
                            List<Xmichqner> list = objectMapper.readValue(info1, new TypeReference<List<Xmichqner>>() {
                            });

                            for (int i = 0; i < list.size(); i++) {

                                Xmichqner xmichq = list.get(i);
                                contentPanel1 = new JPanel();

                                JPanel productBox = new JPanel(new BorderLayout());
                                Border roundedBorder = new Border() {
                                    @Override
                                    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                                        Graphics2D g2 = (Graphics2D) g.create();
                                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                        float arc = 20; // Adjust the arc value for the roundness of corners
                                        g2.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));
                                        g2.dispose();
                                    }

                                    @Override
                                    public Insets getBorderInsets(Component c) {
                                        return new Insets(4, 4, 4, 4); // Adjust as needed
                                    }

                                    @Override
                                    public boolean isBorderOpaque() {
                                        return false;
                                    }
                                };
                                productBox.setBorder(roundedBorder);
                                productBox.setPreferredSize(new Dimension(150, 290));
                                productBox.setBackground(new Color(195, 218, 152));
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
                                buyButton.setFont(new Font("Arial",Font.PLAIN,14));

                                buyButton.setBorder(new RoundedRectangleBorder(10)); // Adjust the arc value for roundness
                                buyButton.setForeground(Color.BLACK);



                                JLabel name = new JLabel(xmichq.getName());
                                name.setFont(new Font("Arial",Font.ITALIC,17));
                                name.setBackground(Color.BLACK);


                                JLabel price = new JLabel(String.valueOf(xmichq.getPrice()));
                                price.setBackground(Color.BLACK);
                                price.setFont(new Font("Arial",Font.ITALIC,17));


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

                                            int i1 = random.nextInt();
                                            if (i1 < 0){
                                                i1 = -1 * i1 ;
                                            }
                                            String json1 = json.toJson(new XmichqId(xmichq.getDrink_id(), String.valueOf(i1), ""));
                                            System.out.println(json1);
                                            MqttMessage id = new MqttMessage(json1.getBytes());
                                            id.setQos(0);
                                            client.publish(topic2, id);
                                            loading.setVisible(true);
                                        }
                                    }
                                });
                                productBox.add(imagepanel);
                                productBox.add(name);
                                productBox.add(price);
                                productBox.add(description);
                                productBox.add(buyButton);

                                JPanel rigidArea = new JPanel();
                                rigidArea.setPreferredSize(new Dimension(60, 0)); // Adjust the height as needed
                                rigidArea.setOpaque(false); // Make it transparent

                                // Add rigid area to create spacing between productBox components
                                a.add(rigidArea);
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
                client.subscribe(topic2, 0);
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





        jFrame.add(imagepanel1, BorderLayout.NORTH);
// Add navPanel to the CENTER position of jFrame
        jFrame.add(navPanel, BorderLayout.CENTER);
        jFrame.setVisible(true);

    }
    static class RoundedRectangleBorder implements Border {
        private final int arc;

        public RoundedRectangleBorder(int arc) {
            this.arc = arc;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8); // Adjust as needed
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(c.getForeground());
            g2.drawRoundRect(x, y, width - 1, height - 1, arc, arc);
            g2.dispose();
        }
    }
    public static void main(String[] args) {
        JavaSwingVisualCode();
    }

}