package com.java.game;

import com.java.gui.GameScreen;
import com.java.objects.Entity;
import com.java.objects.Player;

import javax.swing.*;
import java.awt.*;

public class ObjectManager {

    private final ShapeShooter game;
    private final Player player;

    private int nextId = 0;

    public ObjectManager(ShapeShooter game){
        // Game reference
        this.game = game;
        // Create new player
        this.player = new Player(0);
    }

    protected Player getPlayer(){return player;}

    protected void loadGameObjects(JPanel screen){
        screen.add(player);
        // Set the initial bounds of the player
        player.setBounds(
                screen.getWidth()/2,
                screen.getHeight()/2,
                player.getWidth(),
                player.getHeight()
        );
    }

    public void translatePlayer(Container screen){
        player.setBounds(
                player.getX() + (10 *screen.getWidth()),
                player.getY() + (10 *screen.getHeight()),
                player.getWidth(),
                player.getHeight()
        );

        calculatePositionRatio(player,screen);
    }

    ///  To be called every time a sprite moves
    protected void calculatePositionRatio(Entity object, Container screen){
        // gets the ratio position from the center of the object
        double ratioX = (double)(screen.getWidth() - object.getX()) / screen.getWidth();
        // gets the ratio position from the center of the object
        double ratioY = (double)(screen.getHeight() - object.getY()) / screen.getHeight();
        //DEBUG
        System.out.println("Ratios (x y): " + ratioX + " " + ratioY);
        object.setPositionScaleX(ratioX);
        object.setPositionScaleY(ratioY);
    }

    protected void initializePlayer(){
        // Set player's position to middle of screen
        player.setPositionScaleX(0.5);
        player.setPositionScaleY(0.5);
    }



}
