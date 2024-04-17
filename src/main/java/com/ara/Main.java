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
import java.util.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static java.awt.Color.white;
import static java.awt.SystemColor.info;

public class Main {
    private static boolean q = false ;
    private static JPanel contentPanel1 ;
    private static JPanel imagepanel1;
    private static JButton to_order = new JButton("Order");
    private static JPanel a ;
    private static String json2 ;
    private static JFrame custom_Drink;
    private static Color rgb = new Color(255, 255, 255);
    private static JFrame jFrame;
    private static JFrame Make_Drink;
    private static JFrame gnaAppication;
    private static JFrame loading;
    private static JFrame karlenickpac;
    private static String info1;
    private static String we;
  @SneakyThrows
  static void CUSTOM_DRINKTEXT(){
      JLabel CustomDR = new JLabel("    Custom Drink     ");
      CustomDR.setFont(new Font("Garamond",Font.ITALIC,40));
      JPanel panel = new JPanel();
      panel.add(CustomDR);
      Gson json = new Gson();
      ObjectMapper objectMapper = new ObjectMapper();
      List<Xmichqner> list = objectMapper.readValue(info1, new TypeReference<List<Xmichqner>>() {
      });
      List<Xmichqner> list1 = objectMapper.readValue(info1, new TypeReference<List<Xmichqner>>() {
      });
      list1.sort(new Comparator<Xmichqner>() {
          @Override
          public int compare(Xmichqner o1, Xmichqner o2) {
              return Integer.compare(o1.getName().length(),o2.getName().length());
          }
      });
      JTextField JTF_Drink1 = new JTextField(30);
      JTextField JTF_Drink2 = new JTextField(30);
      JTextField JTF_Drink3 = new JTextField(30);
      JTextField JTF_Drink4 = new JTextField(30);
      JTextField JTF_Drink5 = new JTextField(30);
      JTextField JTF_Drink6 = new JTextField(30);
      JTextField JTF_Drink7 = new JTextField(30);
      for (int i = 0; i <= list.size() - 1;i++){
          if (!list.get(i).isAlcho()) {
              JLabel Drink1 = new JLabel(list.get(i).getName() + " ".repeat(list1.get(list1.size() - 1).getName().length() - list.get(i).getName().length()));
              panel.add(Drink1);
              if (i == 0){
                  panel.add(JTF_Drink1);
              }
              if (i == 2){
                  panel.add(JTF_Drink2);
              }
              if (i == 3){
                  panel.add(JTF_Drink3);
              }
              if (i == 4){
                  panel.add(JTF_Drink4);
              }
              if (i == 5){
                  panel.add(JTF_Drink5);
              }
              if (i == 7){
                  panel.add(JTF_Drink6);
              }
              if (i == 8){
                  panel.add(JTF_Drink7);
              }



          }
      }
      JButton close = new JButton("Close");
      close.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              custom_Drink.setVisible(false);
          }
      });
      to_order.setBackground(new Color(202, 255, 118));

      to_order.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              int D1 = 0;
              int D2 = 0;
              int D3 = 0;
              int D4 = 0;
              int D5 = 0;
              int D6 = 0;
              int D7 = 0;

              if (!JTF_Drink1.getText().equals("")) {
                  D1 = Integer.parseInt(JTF_Drink1.getText());
              }
              if (!JTF_Drink2.getText().equals("")){
                   D2 = Integer.parseInt(JTF_Drink2.getText());}
              if (!JTF_Drink3.getText().equals("")){
                   D3 = Integer.parseInt(JTF_Drink3.getText());}
              if (!JTF_Drink4.getText().equals("")){
                   D4 = Integer.parseInt(JTF_Drink4.getText());}
              if (!JTF_Drink5.getText().equals("")){
                   D5 = Integer.parseInt(JTF_Drink5.getText());}
              if (!JTF_Drink6.getText().equals("")){
                  D6 = Integer.parseInt(JTF_Drink6.getText());
          }
              if (!JTF_Drink7.getText().equals("")) {
                   D7 = Integer.parseInt(JTF_Drink7.getText());
              }
              int[] arr = new int[]{D1,D2,D3,D4,D5,D6,D7};
              Random random = new Random(10);
              int i1 = random.nextInt();
              if (i1 < 0){
                  i1 = -1 * i1 ;
              }
               json2 = json.toJson(new XmichqId(arr, String.valueOf(i1),0,""));
          }
      });
      close.setBackground(new Color(202, 255, 118));
panel.setBackground(Color.WHITE);
      panel.add(to_order);
      panel.add(close);
      custom_Drink.add(panel);
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
    static void Make_Drink(){
        Make_Drink = new JFrame("Loading...");
        Make_Drink.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Make_Drink.setUndecorated(true);
        Make_Drink.setBounds(450,250,500,260);
        JPanel panelloading = new JPanel();
        ImageIcon loadingIcon = new ImageIcon("src\\Nkarner\\giphy.gif");
        ImageIcon loadingicon = resizeImageIcon(loadingIcon,200,200);
        JLabel labelLoading = new JLabel(loadingicon);
        JLabel lcvume = new JLabel("Ձեր խմիչքը պատրաստ է  " + we);
        lcvume.setFont(new Font("Arial",Font.ITALIC,30));

        panelloading.add(labelLoading);
        panelloading.add(lcvume);
        Make_Drink.setLayout(new BorderLayout());
        Make_Drink.add(panelloading);
        Make_Drink.setVisible(true);
    }

    static void Custom_Drink(){
        custom_Drink = new JFrame();
        custom_Drink.setBounds(500,130,350,500);
        custom_Drink.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        custom_Drink.setLayout(new BorderLayout());
        custom_Drink.setUndecorated(true);
        custom_Drink.setShape(new RoundRectangle2D.Double(0, 0, 350, 500, 30, 30)); // Set the shape of the window
        CUSTOM_DRINKTEXT();
        custom_Drink.setVisible(true);
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
        plus.setBackground(new Color(202, 255, 118));
        plus.setBorder(new RoundedRectangleBorder(10));
        plus.setFont(new Font("Arial",Font.PLAIN,50));
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Custom_Drink();
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
        String MixerDR = "MixerDR";
        String topic3 = "topic3";
        String topic8 = "topic8";
        String topic9 = "topic9";
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
                     to_order.addActionListener(new ActionListener() {
                         @SneakyThrows
                         @Override
                         public void actionPerformed(ActionEvent e) {

                             MqttMessage id = new MqttMessage(json2.getBytes());
                             id.setQos(0);
                             client.publish(MixerDR, id);
                         }
                     });

                       if (topic.equals(topic8)){
                           we = Arrays.toString(message.getPayload());
                       }
                        if (topic.equals(topic3)){
                            loading();
                            Thread.sleep(10000);
                            Make_Drink();

                        }
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
                             info1 = new String(message.getPayload());
                            ObjectMapper objectMapper = new ObjectMapper();
                            List<Xmichqner> list = objectMapper.readValue(info1, new TypeReference<List<Xmichqner>>() {
                            });

                            for (int i = 0; i < list.size(); i++) {

                                Xmichqner xmichq = list.get(i);
                                contentPanel1 = new JPanel();

                                JPanel productBox = new JPanel(new BorderLayout());
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
                                            String json1 = json.toJson(new XmichqId(xmichq.getDrink_id(), String.valueOf(i1),0, ""));
                                            System.out.println(json1);
                                            MqttMessage id = new MqttMessage(json1.getBytes());
                                            id.setQos(0);
                                            client.publish(topic2, id);

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
                client.subscribe(topic3, 0);
                client.subscribe(topic6, 0);
                client.subscribe(topic8, 0);
                client.subscribe(topic5, 0);
                client.subscribe(MixerDR,0);
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