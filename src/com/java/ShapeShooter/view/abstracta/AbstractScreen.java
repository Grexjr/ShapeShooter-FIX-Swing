package com.java.ShapeShooter.view.abstracta;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// Extend container or jpanel?
public abstract class AbstractScreen extends JPanel {

    private final BufferedImage bgImage;

    public AbstractScreen(BufferedImage bg){
        bgImage = bg;
    }

    @Override
    protected final void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(bgImage != null){
            g2.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
        }
        render(g2);
    }

    public void refresh(){
        repaint();
        revalidate();
    }

    /**
     * Overridden by subclasses so they do not need to call paint Component.
     * @param g2 graphics object
     */
    protected abstract void render(Graphics2D g2);









}
