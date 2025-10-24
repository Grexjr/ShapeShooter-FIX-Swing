package com.java.gui;

import com.java.game.GUIManager;
import com.java.game.ShapeShooter;
import com.java.objects.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreen extends JPanel {

    private GUIManager manager;

    private float scale;

    public GameScreen(GUIManager manager){
        // Set layout to null for exact positioning of entities on the screen
        super(null);
        // Reference to gui manager object
        this.manager = manager;
        // Initialize action and input map
        initializeInputs();
        initializeActions();

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        // Get one scaling factor that comes from the smaller of the width or the height to keep the aspect ratio
        scale = Math.min(manager.getContent().getWidth(),manager.getContent().getHeight());

        // Draw the player
        g2.drawImage(
                manager.getGame().getObjectManager().getPlayer().getSprite(),
                manager.getGame().getObjectManager().getPlayer().getX(),
                manager.getGame().getObjectManager().getPlayer().getY(),
                calculateScale(manager.getGame().getObjectManager().getPlayer()),
                calculateScale(manager.getGame().getObjectManager().getPlayer()),
                null
                );
    }

    /**
     * Calculates the real size of the drawable entity on screen based on the screen size
     * @param drawable the entity to be drawn
     * @return the actual size (width and height)
     */
    public int calculateScale(Entity drawable){
        return Math.toIntExact(Math.round(drawable.getScale() * scale));
    }

    private void initializeInputs(){
        KeyStroke w = KeyStroke.getKeyStroke("W");
        KeyStroke a = KeyStroke.getKeyStroke("A");
        KeyStroke s = KeyStroke.getKeyStroke("S");
        KeyStroke d = KeyStroke.getKeyStroke("D");

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(w,GUIConstants.MOVE_UP);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(a,GUIConstants.MOVE_LEFT);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(s,GUIConstants.MOVE_RIGHT);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(d,GUIConstants.MOVE_DOWN);
    }

    private void initializeActions(){
        getActionMap().put(GUIConstants.MOVE_UP,moveUp());
    }

    private AbstractAction moveUp(){
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println("Player moved");
                System.out.println(manager.getGame().getObjectManager().getPlayer().getYPos());
                System.out.println(manager.getGame().getObjectManager().getPlayer().getY());
                manager.getGame().getObjectManager().movePlayerUp();
            }
        };
    }



}
