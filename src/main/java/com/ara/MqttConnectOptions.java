package com.ara;

import org.eclipse.paho.client.mqttv3.*;

public class MqttConnectOptions extends org.eclipse.paho.client.mqttv3.MqttConnectOptions {
    public static void main(String[] args) {
        String broker = "tcp://soldier.cloudmqtt.com:12147";
        String clientId = "client";
        String topic = "topic1";
        int subQos = 1;
        int pubQos = 1;
        String msg = "Hello MQTT";

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
                        System.out.println("topic: " + topic);
                        System.out.println("qos: " + message.getQos());
                        System.out.println("message content: " + new String(message.getPayload()));
                    }

                    public void connectionLost(Throwable cause) {
                        System.out.println("connectionLost: " + cause.getMessage());
                    }

                    public void deliveryComplete(IMqttDeliveryToken token) {
                        System.out.println("deliveryComplete: " + token.isComplete());
                    }
                });

                client.subscribe(topic, subQos);

                MqttMessage message = new MqttMessage(msg.getBytes());
                message.setQos(pubQos);
                client.publish(topic, message);
            }

            client.disconnect();
            client.close();

        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
