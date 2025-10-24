package com.java.gui;

import com.java.game.GUIManager;
import com.java.game.ShapeShooter;
import com.java.objects.Entity;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {

    private GUIManager manager;

    private float scale;

    public GameScreen(GUIManager manager){
        // Set layout to null for exact positioning of entities on the screen
        super(null);
        // Reference to gui manager object
        this.manager = manager;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        // Get one scaling factor that comes from the smaller of the width or the height to keep the aspect ratio
        scale = Math.min(manager.getContent().getWidth(),manager.getContent().getHeight());

        // Draw the player
        g2.drawImage(
                manager.getGame().getObjectManager().getPlayer().getSprite(),
                manager.getContent().getWidth()/2,
                manager.getContent().getHeight()/2,
                calculateScale(manager.getGame().getObjectManager().getPlayer()),
                calculateScale(manager.getGame().getObjectManager().getPlayer()),
                null
                );

    }

    /**
     * Calculates the real size of the drawable entity on screen based on the screen size
     * @param drawable the entity to be drawn
     * @return the actual size (width and height)
     */
    private int calculateScale(Entity drawable){
        return Math.toIntExact(Math.round(drawable.getScale() * scale));
    }







}
