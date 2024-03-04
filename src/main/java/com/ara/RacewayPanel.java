package com.ara;

import javax.swing.*;
import java.awt.*;

public class RacewayPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw raceway here
        // For example, drawing a simple track
        g.setColor(Color.GRAY);
        g.fillRect(200, 50, 300, 200); // Outer track

        g.setColor(Color.WHITE);
        g.fillRect(100, 100, 200, 100); // Inner track
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Raceway Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        RacewayPanel racewayPanel = new RacewayPanel();
        frame.getContentPane().add(racewayPanel);

        frame.setVisible(true);
    }
}

