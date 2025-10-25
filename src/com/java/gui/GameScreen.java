package com.java.gui;

import com.java.game.GUIManager;
import com.java.objects.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;

public class GameScreen extends JPanel {

    private GUIManager manager;

    private final Player player;

    public GameScreen(GUIManager manager){
        // Set layout to null for exact positioning of entities on the screen
        super(null);
        // Reference to gui manager object
        this.manager = manager;
        this.player = manager.getGame().getObjectManager().getPlayer();
    }

    // RUNS EVERY TIME THE WINDOW IS RESIZED OR MANUALLY CALLED!!!
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        // Create the player rectangle every frame
        player.setRectangle(
                new Rectangle(
                manager.scalePositionX(player),
                manager.scalePositionY(player),
                manager.scaleDimension(player),
                manager.scaleDimension(player)
        ));

        // Draw the player at the same place as their rectangle
        g2.drawImage(
                player.getSprite(),
                (int)player.getRectangle().getX(),
                (int)player.getRectangle().getY(),
                (int)player.getRectangle().getWidth(),
                (int)player.getRectangle().getHeight(),
                null
        );

    }



}
