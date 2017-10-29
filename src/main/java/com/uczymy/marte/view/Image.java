package com.uczymy.marte.view;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Image extends JPanel{
    private BufferedImage image;

    void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
