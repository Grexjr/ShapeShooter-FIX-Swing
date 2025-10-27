package com.java.objects;

import com.java.util.CommonConstants;
import com.java.util.SpriteLoader;

import java.awt.image.BufferedImage;

public class Player extends Entity{

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite(CommonConstants.PLAYER_SPRITE);

    public Player(){
        super(
                SPRITE,
                ObjectConstants.PLAYER_NAME,
                ObjectConstants.OBJECT_SCALE,
                ObjectConstants.PLAYER_DEF_HEALTH
        );
    }

}
