package com.java.game;

import com.java.objects.Player;

public class ObjectManager {

    private Player player;

    public ObjectManager(){
        // Create new player
        player = new Player(0);
    }

    // Okay to be hard-coded since there will always be a player
    public Player getPlayer(){return player;}



}
