package com.java.game;

import com.java.gui.*;
import com.java.objects.Entity;

import javax.swing.*;
import java.awt.*;

public class GUIManager {

    private final ShapeShooter game;

    private final GameFrame frame;
    private final MainMenuScreen mainMenu;
    private final InstructionsPanel instructionsPanel;
    private final GameScreen gameScreen;
    private final GameOverScreen gameOverScreen;
    private final SettingsPanel settings;

    public GUIManager(ShapeShooter game){
        // Reference to the game controller class
        this.game = game; // Need to keep this for now, but will find a way to do things differently

        frame = new GameFrame();
        mainMenu = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);
        gameOverScreen = new GameOverScreen(this);
        instructionsPanel = new InstructionsPanel(this);
        settings = new SettingsPanel(this);
    }

    public Container getContent(){return frame.getContentPane();}

    public ShapeShooter getGame() {
        return game;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public GameOverScreen getGameOverScreen() {
        return gameOverScreen;
    }

    ///  Scales position of object from world coordinates to screen coordinates and returns that value: x
    public int scalePositionX(Entity object){
        return (int) Math.round(object.getAbsX() * game.calculateScaleRatioX());
    }

    ///  Scales position of object from world coordinates to screen coordinates and returns that value: y
    public int scalePositionY(Entity object){
        return (int) Math.round(object.getAbsY() * game.calculateScaleRatioY());
    }

    ///  Scales dimensions square-wise (same width and height) based on the smaller dimension of the GUI
    public int scaleDimension(Entity object){
        int scalar = Math.min(getContent().getWidth(),getContent().getHeight());
        return (int) Math.round(object.getScale() * scalar);
    }

    public void repaintScreen(){
        getContent().repaint();
    }






    public void showGameGUI(){
        changeScreen(gameScreen);
        frame.repaint();
        frame.revalidate();
    }
























    /// Sets the frame to be visible
    public void showGame(){
        frame.setVisible(true);
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

    protected void changeScreen(JPanel newScreen){
        // Set the screen to be the new screen
        frame.setContentPane(newScreen);
        // Repaint the frame to update
        frame.repaint();
        // Revalidate the frame to update the layouts
        frame.revalidate();
    }

    protected void initializeGUI(){
        changeScreen(mainMenu);
        //DEBUG
        System.out.println(mainMenu.getClass().getSimpleName() + "=added;");
    }



}
