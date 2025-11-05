package com.java.game;

import com.java.objects.Bullet;
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

    public void translatePlayer(String direction){
        switch(direction){
            case "UP" -> {
                player.setAbsY(player.getAbsY() - GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
            case "LEFT" -> {
                player.setAbsX(player.getAbsX() - GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
            case "DOWN" -> {
                player.setAbsY(player.getAbsY() + GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
            case "RIGHT" -> {
                player.setAbsX(player.getAbsX() + GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
        }
    }

    public void shootBullet(String direction){
        Bullet bullet = new Bullet();
        bullet.setAbsX(player.getAbsX());
        bullet.setAbsY(player.getAbsY());
        switch(direction){
            case "UP" -> {
                bullet.setAbsX(bullet.getAbsY() - GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
            case "LEFT" -> {
                bullet.setAbsX(bullet.getAbsX() - GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
            case "DOWN" -> {
                bullet.setAbsX(bullet.getAbsY() + GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
            case "RIGHT" -> {
                bullet.setAbsX(bullet.getAbsX() + GameConstants.MOVEMENT_BASE);
                //DEBUG need
                game.getGuiManager().repaintScreen();
            }
        }
    }



}
