package com.java.objects;

import com.java.util.CommonConstants;
import com.java.util.SpriteLoader;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Bullet {

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite(CommonConstants.BULLET_SPRITE);

    private final BufferedImage sprite;
    private final double scale;

    private int absX, absY;
    private Rectangle2D rectangle;

    public Bullet(){
        sprite = SPRITE;
        scale = ObjectConstants.OBJECT_SCALE;
        rectangle = new Rectangle();
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public double getScale() {
        return scale;
    }

    public int getAbsX() {
        return absX;
    }

    public void setAbsX(int absX) {
        this.absX = absX;
    }

    public int getAbsY() {
        return absY;
    }

    public void setAbsY(int absY) {
        this.absY = absY;
    }

    public Rectangle2D getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle2D rectangle) {
        this.rectangle = rectangle;
    }
}
