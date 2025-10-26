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
            case (int) (KeyEvent.VK_W) -> manager.getGame().movePlayer("UP");
            case (int) (KeyEvent.VK_A) -> manager.getGame().movePlayer("LEFT");
            case (int) (KeyEvent.VK_S) -> manager.getGame().movePlayer("DOWN");
            case (int) (KeyEvent.VK_D) -> manager.getGame().movePlayer("RIGHT");
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
        actions.put(pressMapKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentInput = keyPress;
                //DEBUG
                System.out.println(keyPress+"=pressed;");
                startInputHoldTimer();
            }
        });
        actions.put(releaseMapKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println(keyPress+"=released;");
                stopInputHoldTimer();
            }
        });
    }

    private void buildSInput(){

    }

    private void buildDInput(){

    }

    private void buildQInput(){

    }

    private void buildEInput(){

    }

    private void buildUpInput(){

    }

    private void buildLeftInput(){

    }

    private void buildRightInput(){

    }

    private void buildDownInput(){

    }


    private void startInputHoldTimer(){
        holdTimer.start();
    }

    private void stopInputHoldTimer(){
        holdTimer.stop();
    }



}
