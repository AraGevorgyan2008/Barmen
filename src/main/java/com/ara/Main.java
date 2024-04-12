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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.awt.Color.white;
import static java.awt.SystemColor.info;

public class Main {
    private static JPanel contentPanel1 ;
    private static JPanel imagepanel1;
    private static JPanel a ;
    private static JFrame WTF;
    private static Color rgb = new Color(255, 255, 255);
    private static JFrame jFrame;
    private static JFrame gnaAppication;
    private static JFrame loading;
    private static JFrame karlenickpac;
  static void WTFTEXT(){
      JPanel panel = new JPanel();
      JLabel Drink1 = new JLabel("Mojito            ");
      JTextField JTF_Drink1 = new JTextField(30);
      JLabel Drink2 = new JLabel("Alcohol           ");
      JTextField JTF_Drink2 = new JTextField(30);
      JLabel Drink3 = new JLabel("Sparkling water   ");
      JTextField JTF_Drink3 = new JTextField(30);
      JLabel Drink4 = new JLabel("Fanta             ");
      JTextField JTF_Drink4 = new JTextField(30);
      JLabel Drink5 = new JLabel("Mango juice       ");
      JTextField JTF_Drink5 = new JTextField(30);
      JLabel Drink6 = new JLabel("Coke             ");
      JTextField JTF_Drink6 = new JTextField(30);
      JLabel Drink7 = new JLabel("Orange           ");
      JTextField JTF_Drink7 = new JTextField(30);
      JLabel Drink8 = new JLabel("Pommegranate juice");
      JTextField JTF_Drink8 = new JTextField(30);

      JButton to_order = new JButton("Order");
      JButton close = new JButton("Close");
      close.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              WTF.setVisible(false);
          }
      });
      to_order.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              int text1 = 0 ;
              int text2= 0 ;
              int text3= 0 ;
              int text4= 0 ;
              int text5= 0 ;
              int text6= 0 ;
              int text7= 0 ;
              int text8= 0 ;
              if (!(JTF_Drink1.getText().equals(""))){
                  text1 = Integer.valueOf(JTF_Drink1.getText());
              }
              if (!(JTF_Drink2.getText().equals(""))){
              text2 = Integer.parseInt(JTF_Drink2.getText());
              }
                  if (!(JTF_Drink3.getText().equals(""))){
              text3 = Integer.parseInt(JTF_Drink3.getText());
                  }
                      if (!(JTF_Drink4.getText().equals(""))){
              text4 = Integer.parseInt(JTF_Drink4.getText());
                      }
                          if (!(JTF_Drink5.getText().equals(""))){
              text5 = Integer.parseInt(JTF_Drink5.getText());
                          }
                              if (!(JTF_Drink6.getText().equals(""))){
              text6 = Integer.parseInt(JTF_Drink6.getText());
                              }
                                  if (!(JTF_Drink7.getText().equals(""))){
              text7 = Integer.parseInt(JTF_Drink7.getText());
                                  }
                                      if (!(JTF_Drink8.getText().equals(""))) {
                                          text8 = Integer.parseInt(JTF_Drink8.getText());
                                      }
              int[] arr = new int[]{text1,text2,text3,text4,text5,text6,text7,text8};
              System.out.println(Arrays.toString(arr));
          }
      });
panel.setBackground(Color.WHITE);
      panel.add(Drink1);
      panel.add(JTF_Drink1);
      panel.add(Drink2);
      panel.add(JTF_Drink2);
      panel.add(Drink3);
      panel.add(JTF_Drink3);
      panel.add(Drink4);
      panel.add(JTF_Drink4);
      panel.add(Drink5);
      panel.add(JTF_Drink5);
      panel.add(Drink6);
      panel.add(JTF_Drink6);
      panel.add(Drink7);
      panel.add(JTF_Drink7);
      panel.add(Drink8);
      panel.add(JTF_Drink8);
      panel.add(to_order);
      panel.add(close);
      WTF.add(panel);
  }
    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the Image from ImageIcon
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT); // Scale the image
        return new ImageIcon(scaledImage); // Return a new ImageIcon with the scaled image
    }
     static void loading(){
         loading = new JFrame("Loading...");
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setUndecorated(true);
        loading.setBounds(450,250,500,260);
         JPanel panelloading = new JPanel();
         ImageIcon loadingIcon = new ImageIcon("src\\Nkarner\\1a.gif");
         ImageIcon loadingicon = resizeImageIcon(loadingIcon,200,200);
         JLabel labelLoading = new JLabel(loadingicon);
         JLabel lcvume = new JLabel("Սպասեք մինչև կլցվի");
         lcvume.setFont(new Font("Arial",Font.ITALIC,30));

         panelloading.add(labelLoading);
         panelloading.add(lcvume);
        loading.setLayout(new BorderLayout());
         loading.add(panelloading);
        loading.setVisible(true);
    }
    static void WTF(){
        WTF = new JFrame();
        WTF.setBounds(500,130,350,500);
        WTF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WTF.setLayout(new BorderLayout());
        WTF.setUndecorated(true);
        WTF.setShape(new RoundRectangle2D.Double(0, 0, 350, 500, 30, 30)); // Set the shape of the window
        WTFTEXT();
        WTF.setVisible(true);
    }
    static void imagepanel1(){
         imagepanel1 = new JPanel();
        imagepanel1.setPreferredSize(new Dimension(100, 100));
        imagepanel1.setBackground(rgb);
        imagepanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel text = new JLabel("DrinkMixer");
        text.setForeground(Color.BLACK);
        Font font = new Font("Garamond",Font.ITALIC,70);//Georgia
        text.setFont(font);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton plus = new JButton("+");
        plus.setBackground(Color.WHITE);
        plus.setBorder(new CircularBorder(16));
        plus.setFont(new Font("Arial",Font.PLAIN,50));
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WTF();
            }
        });

        JPanel rigidArea = new JPanel();
        rigidArea.setPreferredSize(new Dimension(450, 0)); // Adjust the height as needed
        rigidArea.setOpaque(false);

        imagepanel1.add(plus);
        imagepanel1.add(rigidArea);
        imagepanel1.add(text);

    }
    static void gnaAppication(){
         gnaAppication = new JFrame("Loading...");
        gnaAppication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gnaAppication.setBounds(350,250,730,130);
        gnaAppication.setLayout(new BorderLayout());
        JPanel panellgna = new JPanel();
        JLabel gna = new JLabel("Ալկոհոլ կարելի է պատվիրել միայն Appication-ով");
        gna.setFont(new Font("Arial",Font.ITALIC,30));
        JButton ok = new JButton("OK");
        ok.setFont(new Font("Arial",Font.ITALIC,30));
        panellgna.add(gna);
        panellgna.add(ok);
        gnaAppication.add(panellgna);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gnaAppication.setVisible(false);
            }
        });
        gnaAppication.setVisible(true);
    }
    @SneakyThrows
    public static void JavaSwingVisualCode() {
// loading jFrame
        Gson json = new Gson();

        jFrame = new JFrame();
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setTitle("Java Swing Visual Code");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new BorderLayout());
        jFrame.setUndecorated(true);
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 10));
        navPanel.setBackground(rgb);
                 Random random = new Random(10);
        imagepanel1();


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
                        if (topic.equals(topic1)) {
                            a = new JPanel();
                            a.setPreferredSize(new Dimension(1200,650));
                            a.setBackground(rgb);
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
                                productBox.setLayout(new FlowLayout());
                                productBox.setPreferredSize(new Dimension(150, 290));
                                productBox.setBackground(rgb);
                                productBox.setLayout(new BoxLayout(productBox, BoxLayout.PAGE_AXIS));

                                JPanel imagepanel = new JPanel();
                                imagepanel.setBackground(rgb);
                                ImageIcon logoIcon1 = new ImageIcon("src\\Nkarner\\" + xmichq.getImg());
                                Image img = logoIcon1.getImage().getScaledInstance(145, 215,Image.SCALE_FAST);
                                ImageIcon resizedIcon = new ImageIcon(img);
                                JLabel image1 = new JLabel(resizedIcon);

                                productBox.add(image1);



                                JLabel name = new JLabel(xmichq.getName());
                                name.setFont(new Font("Bodoni",Font.ITALIC,16));
                                name.setBackground(Color.BLACK);


                                JLabel price = new JLabel(String.valueOf(xmichq.getPrice()));
                                price.setBackground(Color.BLACK);
                                price.setFont(new Font("Bodoni",Font.LAYOUT_NO_LIMIT_CONTEXT,17));


                                JLabel description = new JLabel(xmichq.getDescription());
                                description.setBackground(Color.BLACK);

                                JButton buyButton = new JButton("Buy");
                                buyButton.setFont(new Font("Arial",Font.PLAIN,14));
                                buyButton.setPreferredSize(new Dimension(270,30));
                                buyButton.setBorder(new RoundedRectangleBorder(10)); // Adjust the arc value for roundness
                                buyButton.setBackground(new Color(202, 255, 118));
                                buyButton.addActionListener(new ActionListener() {
                                    @SneakyThrows
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        if (xmichq.isAlcho()) {
                                            gnaAppication();

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
                                            loading();
                                        }
                                    }
                                });


                                productBox.add(price);
                                productBox.add(name);
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





        jFrame.add(imagepanel1, BorderLayout.NORTH);
// Add navPanel to the CENTER position of jFrame
        jFrame.add(navPanel, BorderLayout.CENTER);
        jFrame.setVisible(true);

    }
    static class RoundedRectangleBorder  implements Border {
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
    static class CircularBorder implements Border {
        private int radius;

        public CircularBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        public boolean isBorderOpaque() {
            return false;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.BLACK);
            g.drawOval(x, y, width - 1, height - 1);
        }
    }
    public static void main(String[] args) {
        JavaSwingVisualCode();
    }

}