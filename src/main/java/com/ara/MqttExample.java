package com.ara;

import org.eclipse.paho.client.mqttv3.*;

public class MqttExample {

    public static void main(String[] args) {
        String broker = "tcp://soldier.cloudmqtt.com:12147"; // MQTT Broker URL
        String clientId = "JavaClient";
        String username = "fqakeccp"; // MQTT Username
        String password = "ryNhh1ECFYRZ"; // MQTT Password

        try {
            MqttClient mqttClient = new MqttClient(broker, clientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());
            mqttClient.connect(connOpts);

            System.out.println("Connected to broker: " + broker);

            // Other MQTT operations can be performed here, such as subscribing, publishing, etc.

            // Disconnecting from the broker
            mqttClient.disconnect();
            System.out.println("Disconnected from broker");

        } catch (MqttException me) {
            System.out.println("Reason code: " + me.getReasonCode());
            System.out.println("Message: " + me.getMessage());
            System.out.println("Localized Message: " + me.getLocalizedMessage());
            System.out.println("Cause: " + me.getCause());
            me.printStackTrace();
        }
    }
}

