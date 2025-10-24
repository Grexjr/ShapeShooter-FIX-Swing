package com.java.gui;

import com.java.game.GUIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameScreen extends JPanel {

    private GUIManager manager;

    private float scale;

    public GameScreen(GUIManager manager){
        // Set layout to null for exact positioning of entities on the screen
        super(null);
        // Reference to gui manager object
        this.manager = manager;
        // Initialize action and input map

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        // Get one scaling factor that comes from the smaller of the width or the height to keep the aspect ratio
        scale = Math.min(manager.getContent().getWidth(),manager.getContent().getHeight());

    }



}
