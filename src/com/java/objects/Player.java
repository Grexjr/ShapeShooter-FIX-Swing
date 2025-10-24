package com.java.objects;

import com.java.util.SpriteLoader;

import java.awt.image.BufferedImage;

public class Player extends Entity {

    public Player(int id){
        super(
                id,
                SpriteLoader.getPlayerSprite(),
                ObjectConstants.PLAYER_NAME,
                ObjectConstants.SCALE_FACTOR,
                ObjectConstants.PLAYER_HEALTH,
                0
        );
    }


}
