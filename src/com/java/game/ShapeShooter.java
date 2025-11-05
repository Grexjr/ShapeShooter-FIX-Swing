package com.java.game;

import com.java.util.SpriteLoader;

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

    protected GUIManager getGuiManager(){return guiManager;}


    /// Calculates the scale ratio between the logical game world and the gui game screen: width
    protected double calculateScaleRatioX(){
        return (double)guiManager.getContent().getWidth()/objectManager.getWorld().getWidth();
    }

    /// Calculates the scale ratio between the logical game world and the gui game screen: height
    protected double calculateScaleRatioY(){
        return (double)guiManager.getContent().getHeight()/objectManager.getWorld().getHeight();
    }


    public void movePlayer(String direction){
        objectManager.translatePlayer(direction);
    }

    public void shootBullet(String direction){}
























    /// Runs on start up of the game to initialize things like the first screen, etc.
    public void initializeGame(){
        guiManager.initializeGUI();
    }

    /// Runs the game start logic for when main menu start button is clicked
    public void startGame(){
        //DEBUG
        System.out.println(this.getClass().getSimpleName() + "=started;");
        // Set the game screen to be the one shown
        guiManager.showGameGUI();

        //DEBUG
        System.out.println(guiManager.getGameScreen().getClass().getSimpleName() + "=added;");
    }

    /// Play game method
    public void playGame(){

    }


    /// Restarts the game from the game over screen
    public void restartGame(){
        // TODO!!!
        //DEBUG
        System.out.println(guiManager.getGameOverScreen().getClass().getSimpleName() + "=hidden;");
    }

}
