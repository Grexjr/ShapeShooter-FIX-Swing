package com.java.objects;

import java.awt.image.BufferedImage;

public class Entity {

    private final int id,pointsValue,hp;
    private final BufferedImage sprite;
    private final String name;
    private final double scale;

    private float xPos, yPos;

    public Entity(int id, BufferedImage sprite, String name, double scale, int hp, int pointsValue){
        // Provide each entity an ID
        this.id = id;

        // Initialize entity-specific variables
        this.sprite = sprite;
        this.name = name;
        this.scale = scale;
        this.hp = hp;
        this.pointsValue = pointsValue;
    }

    public int getID(){return id;}
    public int getId() {return id;}
    public int getPointsValue() {return pointsValue;}
    public int getHp() {return hp;}
    public BufferedImage getSprite() {return sprite;}
    public String getName() {return name;}
    public double getScale() {return scale;}
    public float getXPos() {return xPos;}
    public float getYPos() {return yPos;}

    public void setXPos(float newPos){xPos = newPos;}
    public void setYPos(float newPos){yPos = newPos;}

}
