package com.java.objects;

import com.java.objects.components.Position;
import com.java.objects.components.Velocity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Entity extends JComponent {

    private final BufferedImage sprite;
    private final String name;
    private final double scale;

    private int maxHealth,health,absX,absY;
    private Position position;
    private Velocity velocity;
    private Rectangle2D rectangle;

    public Entity(BufferedImage sprite, String name, double scale, int maxHealth){
        this.sprite = sprite;
        this.name = name;
        this.scale = scale;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.position = new Position(0,0);
        this.velocity = new Velocity(0,0);
        this.rectangle = new Rectangle();
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public Rectangle2D getRectangle() {
        return rectangle;
    }

    public String getEntityName() {
        return name;
    }

    public double getScale() {
        return scale;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAbsX() {
        return absX;
    }

    public int getAbsY() {
        return absY;
    }

    public Position getPosition() {
        return position;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAbsX(int absX) {
        this.absX = absX;
    }

    public void setAbsY(int absY) {
        this.absY = absY;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public void setRectangle(Rectangle2D rectangle) {
        this.rectangle = rectangle;
    }
}
