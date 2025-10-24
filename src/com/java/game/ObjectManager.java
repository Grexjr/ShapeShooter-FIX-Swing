package com.java.game;

import com.java.objects.Player;

public class ObjectManager {

    private final ShapeShooter game;
    private Player player;

    public ObjectManager(ShapeShooter game){
        // Game reference
        this.game = game;
        // Create new player
        player = new Player(0);
    }

    // Okay to be hard-coded since there will always be a player
    public Player getPlayer(){return player;}

    public void initializePlayer(){
        player.setBounds(0,0,game.getGuiManager().getGameScreen().calculateScale(player),
                game.getGuiManager().getGameScreen().calculateScale(player));
    }

    public void movePlayerUp(){
        player.setBounds(
                Math.toIntExact(Math.round(player.getXPos())),
                player.getY() - 100,
                game.getGuiManager().getGameScreen().calculateScale(player),
                game.getGuiManager().getGameScreen().calculateScale(player)
        );
        player.repaint();
    }



}
