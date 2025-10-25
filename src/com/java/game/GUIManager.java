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

    public int rescaleObjectXPositions(Entity object){
        return Math.toIntExact(Math.round(object.getPositionScaleX() * getContent().getWidth()));
    }

    public int rescaleObjectYPositions(Entity object){
        return Math.toIntExact(Math.round(object.getPositionScaleY() * getContent().getHeight()));
    }

    public void initializeGameScreen(){
        // Change to the game screen
        changeScreen(gameScreen);
        // Initialize all game objects on to the screen
        game.getObjectManager().initializePlayer();
    }

    public void resizeScreen(Container screen){
        // would need a list of all entities on the screen... just use object manager list for now
        game.getObjectManager().calculatePositionRatio(game.getObjectManager().getPlayer(),screen);
        // enemies list as well
    }

    protected void changeScreen(JPanel newScreen){
        //DEBUG
        System.out.println("Screen changed!");
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
