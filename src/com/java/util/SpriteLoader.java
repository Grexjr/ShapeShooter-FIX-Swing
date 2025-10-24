package com.java.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class SpriteLoader {

    private static BufferedImage playerSprite;
    private static final HashMap<String, BufferedImage> SPRITE_CACHE = new HashMap<>();

    public static void init(){
        playerSprite = loadSprite(UtilConstants.PLAYER_SPRITE);

        SPRITE_CACHE.put(UtilConstants.PLAYER_SPRITE,playerSprite);
    }


    public static BufferedImage loadSprite(String fileName){
        return SPRITE_CACHE.computeIfAbsent(fileName, key -> {
            // Try with resources; automatically closes is after use
            try(InputStream is = SpriteLoader.class.getResourceAsStream("/assets/" + key)){
                if(is == null){
                    throw new IOException("Resource not found: " + key);
                }

                return ImageIO.read(is);
            } catch (IOException e){
                e.printStackTrace();
                return null;
            }
        });
    }

    public static BufferedImage getPlayerSprite(){return playerSprite;}







}
