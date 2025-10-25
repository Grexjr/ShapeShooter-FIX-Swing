package com.java.game;

import com.java.objects.GameWorld;
import com.java.objects.Player;

import javax.swing.*;
import java.awt.*;

public class ObjectManager {

    private final ShapeShooter game;

    private final GameWorld world;
    private final Player player;

    public ObjectManager(ShapeShooter game){
        // Game reference
        this.game = game;
        // Create new world
        this.world = new GameWorld(GameConstants.WORLD_WIDTH,GameConstants.WORLD_HEIGHT);
        // Create new player
        this.player = new Player();
        initializePlayer();
    }

    protected GameWorld getWorld(){return world;}
    public Player getPlayer(){return player;}

    private void initializePlayer(){
        // Set the logical starting position of the player
        player.setAbsX(800);
        player.setAbsY(450);
    }



}
