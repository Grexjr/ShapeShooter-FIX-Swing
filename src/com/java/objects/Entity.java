package com.java.objects;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class Entity extends JComponent {

    private final int id;
    private final BufferedImage sprite;
    private final String name;
    private final float scale;

    private int maxHealth,health;
    //private Vector<Integer> velocity;

    public Entity(int id, BufferedImage sprite, String name, float scale, int maxHealth){
        // Initialize all variables
        this.id = id;
        this.sprite = sprite;
        this.name = name;
        this.scale = scale;
        this.maxHealth = maxHealth;
        this.health = maxHealth;

        // Set minimum size
        setMinimumSize(ObjectConstants.OBJECT_MINIMUM_SIZE);
        // Set the bounds to be the minimum size by default
        setBounds(0,0,ObjectConstants.OBJECT_MINIMUM_SIZE.width,ObjectConstants.OBJECT_MINIMUM_SIZE.height);
    }

    public int getId() {
        return id;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public String getEntityName() {
        return name;
    }

    public float getScale() {
        return scale;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }
}
