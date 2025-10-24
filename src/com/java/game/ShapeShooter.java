package com.java.game;

import com.java.gui.*;
import com.java.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;

public class ShapeShooter {

    // Controller Objects
    private final ObjectManager objectManager;

    // GUI Objects
    private final GUIManager guiManager;

    public ShapeShooter(){
        // Initialize the utilities
        SpriteLoader.init();

        // Initialize the mini-controllers
        objectManager = new ObjectManager(this);
        guiManager = new GUIManager(this);


        // Set everything visible
        guiManager.showGame();
    }

    public ObjectManager getObjectManager(){return objectManager;}
    public GUIManager getGuiManager(){return guiManager;}

    /// Runs on start up of the game to initialize things like the first screen, etc.
    public void initializeGame(){
        guiManager.initializeGUI();
    }

    /// Runs the game start logic for when main menu start button is clicked
    public void startGame(){
        //DEBUG
        System.out.println(this.getClass().getSimpleName() + "=started;");
        // Set the game screen to be the one shown
        guiManager.changeScreen(guiManager.getGameScreen());
        //DEBUG
        System.out.println(guiManager.getGameScreen().getClass().getSimpleName() + "=added;");
    }

    /// Restarts the game from the game over screen
    public void restartGame(){
        // TODO!!!
        //DEBUG
        System.out.println(guiManager.getGameOverScreen().getClass().getSimpleName() + "=hidden;");
    }

}
