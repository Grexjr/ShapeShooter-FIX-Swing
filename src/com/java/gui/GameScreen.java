package com.java.gui;

import com.java.game.GUIManager;
import com.java.objects.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameScreen extends JPanel {

    private GUIManager manager;

    private float scale;

    public GameScreen(GUIManager manager){
        // Set layout to null for exact positioning of entities on the screen
        super(null);
        // Reference to gui manager object
        this.manager = manager;
        // Initialize action and input maps

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        calculateScale();

        // Repaint the player ever frame
        g2.drawImage(
                manager.getGame().getPlayer().getSprite(),
                manager.rescaleObjectXPositions(manager.getGame().getPlayer()),
                manager.rescaleObjectYPositions(manager.getGame().getPlayer()),
                calculateObjectSize(manager.getGame().getPlayer()),
                calculateObjectSize(manager.getGame().getPlayer()),
                null
        );

        System.out.println(getWidth());
        System.out.println(manager.getGame().getPlayer().getPositionScaleX());
        System.out.println(manager.getGame().getPlayer().getX());
        System.out.println(manager.getGame().getPlayer().getPositionScaleX() * getWidth());

        // Set the player bounds every frame

        //TODO: Make the player stay in the same position when resizing, likely with a scale x and scale y for position

    }

    private void calculateScale(){
        // Get one scaling factor that comes from the smaller of the width or the height to keep the aspect ratio
        scale = Math.min(getWidth(),getHeight());
    }

    private int calculateObjectSize(Entity object){
        return Math.toIntExact(Math.round(object.getScale() * scale));
    }



}
