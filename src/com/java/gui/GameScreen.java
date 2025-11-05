package com.java.gui;

import com.java.game.GUIManager;
import com.java.objects.Player;
import com.java.util.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import static java.awt.event.KeyEvent.VK_A;

public class GameScreen extends JPanel {

    private GUIManager manager;

    private final Player player;

    private final Timer holdTimer;
    private final InputMap inputs;
    private final ActionMap actions;

    private int currentInput;

    public GameScreen(GUIManager manager){
        // Set layout to null for exact positioning of entities on the screen
        super(null);
        // Reference to gui manager object
        this.manager = manager;
        player = manager.getGame().getObjectManager().getPlayer();
        // Create the hold timer
        holdTimer = createHoldTimer();
        // Initialize current input to null

        inputs = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        actions = getActionMap();

        addKeyInputs();
    }

    // RUNS EVERY TIME THE WINDOW IS RESIZED OR MANUALLY CALLED!!!
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Create the player rectangle when repainted
        player.getRectangle().setRect( new Rectangle(
                        manager.scalePositionX(player),
                        manager.scalePositionY(player),
                        manager.scaleDimension(player),
                        manager.scaleDimension(player)));

        // Draw the player at the same place as their rectangle
        g2.drawImage(
                player.getSprite(),
                (int)player.getRectangle().getX(),
                (int)player.getRectangle().getY(),
                (int)player.getRectangle().getWidth(),
                (int)player.getRectangle().getHeight(),
                null
        );

    }

    private Timer createHoldTimer(){
        return new Timer(
                16,
                _ -> {
                    runInput();
                });
    }

    private void runInput(){
        switch(currentInput){
            //TODO: a paint method in gui manager that paints a specific screen
            //TODO: methods in gui manager that moves player
            case (int) (KeyEvent.VK_W) -> manager.getGame().movePlayer("UP");
            case (int) (KeyEvent.VK_A) -> manager.getGame().movePlayer("LEFT");
            case (int) (KeyEvent.VK_S) -> manager.getGame().movePlayer("DOWN");
            case (int) (KeyEvent.VK_D) -> manager.getGame().movePlayer("RIGHT");

            case (int) (KeyEvent.VK_UP) -> {
                //TODO: Will need to start a timer for bullet movement. Repaint in that
                //TODO: Will need to add the bullet to bullets list somewhere and access that bullets list.
                //TODO: Add in the repaint method to draw all the bullets in the list. Don't worry about memory rn.
                //TODO: Should have a central timer rather than individual ones...
            }
            case (int) (KeyEvent.VK_LEFT) -> {

            }
            case (int) (KeyEvent.VK_DOWN) -> {

            }
            case (int) (KeyEvent.VK_RIGHT) -> {

            }
            default -> {}
        }
    }

    private void addKeyInputs(){
        for(int i : CommonConstants.GAME_SCREEN_KEY_INPUTS){
            buildInput(i,0);
        }
    }

    private void buildInput(int keyPress, int mask){
        KeyStroke press = KeyStroke.getKeyStroke(keyPress,mask,false);
        KeyStroke release = KeyStroke.getKeyStroke(keyPress,mask,true);

        String pressMapKey = "press_" + keyPress;
        String releaseMapKey = "release_" + keyPress;

        inputs.put(press,pressMapKey);
        inputs.put(release,releaseMapKey);
        actions.put(pressMapKey, createPress(keyPress));
        actions.put(releaseMapKey, createRelease(keyPress));
    }

    private AbstractAction createPress(int keyPress){
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Stop the timer so it doesn't override into the restart
                stopInputHoldTimer();
                currentInput = keyPress;
                //DEBUG
                System.out.println(keyPress+"=pressed;");
                startInputHoldTimer();
            }
        };
    }

    private AbstractAction createRelease(int keyPress){
        return new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println(keyPress+"=released;");
                stopInputHoldTimer();
            }
        };
    }


    private void startInputHoldTimer(){
        holdTimer.start();
    }

    private void stopInputHoldTimer(){
        holdTimer.stop();
    }



}
