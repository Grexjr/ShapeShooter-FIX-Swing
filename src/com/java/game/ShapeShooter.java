package com.java.game;

import com.java.gui.*;
import com.java.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;

public class ShapeShooter {

    // Controller Objects
    private final ObjectManager objectManager;

    // GUI Objects
    private final GameFrame frame;
    private final MainMenuScreen mainMenu;
    private final GameScreen gameScreen;
    private final GameOverScreen gameOverScreen;
    private final SettingsPanel settings;

    private final InstructionsPanel instructionsPanel;

    public ShapeShooter(){
        // Initialize the utilities
        SpriteLoader.init();

        // Initialize the mini-controllers
        objectManager = new ObjectManager();

        // Initialize the gui objects
        frame = new GameFrame();
        mainMenu = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);
        gameOverScreen = new GameOverScreen(this);
        instructionsPanel = new InstructionsPanel(this);
        settings = new SettingsPanel(this);

        // Set everything visible
        frame.setVisible(true);
    }

    public ObjectManager getObjectManager(){return objectManager;}
    public Container getContent(){return frame.getContentPane();}

    // TODO: Create smaller controller classes; score manager, screen manager

    /// Runs on start up of the game to initialize things like the first screen, etc.
    public void initializeGame(){
        // No need to set visible since components are by default set to visible
        changeScreen(mainMenu);
        //DEBUG
        System.out.println(mainMenu.getClass().getSimpleName() + "=added;");
    }

    /// Runs the game start logic for when main menu start button is clicked
    public void startGame(){
        //DEBUG
        System.out.println(this.getClass().getSimpleName() + "=started;");
        // Set the game screen to be the one shown
        changeScreen(gameScreen);
        //DEBUG
        System.out.println(gameScreen.getClass().getSimpleName() + "=added;");
    }

    /// Restarts the game from the game over screen
    public void restartGame(){
        // TODO!!!
        //DEBUG
        System.out.println(gameOverScreen.getClass().getSimpleName() + "=hidden;");
    }

    /// Shows the instructions panel with the text describing how the game works
    public void showInstructions(){
        //DEBUG
        System.out.println(instructionsPanel.getClass().getSimpleName() + "=shown;");
        changeScreen(instructionsPanel);
    }

    /// Hides the instructions panel and returns to the main menu
    public void hideInstructions(){
        //DEBUG
        System.out.println(instructionsPanel.getClass().getSimpleName() + "=hidden;");
        changeScreen(mainMenu);
    }

    ///  Goes to the settings screen with all the options there
    public void goToSettings(){
        //DEBUG
        System.out.println(settings.getClass().getSimpleName() + "=shown;");
        // Set as the screen
        changeScreen(settings);
    }

    /// Hides the settings screen when the back button is pressed
    public void hideSettings(){
        //DEBUG
        System.out.println(settings.getClass().getSimpleName() + "=hidden;");
        // Change screen back
        changeScreen(mainMenu);
    }

    // Might be helpful to have a wrapper class for this
    private void changeScreen(JPanel newScreen){
        //DEBUG
        System.out.println("Screen changed!");
        // Set the screen to be the new screen
        frame.setContentPane(newScreen);
        // Repaint the frame to update
        frame.repaint();
        // Revalidate the frame to update the layouts
        frame.revalidate();
    }





}
