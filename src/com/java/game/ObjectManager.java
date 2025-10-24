package com.java.game;

import com.java.gui.GameScreen;
import com.java.objects.Entity;
import com.java.objects.Player;

import javax.swing.*;

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



}
