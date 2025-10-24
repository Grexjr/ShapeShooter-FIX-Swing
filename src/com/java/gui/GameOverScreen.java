package com.java.gui;

import com.java.game.GUIManager;
import com.java.game.ShapeShooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JPanel {

    private final GUIManager manager;

    public GameOverScreen(GUIManager manager){
        // Give the screen reference to the game
        this.manager = manager;

        // Set layout for the screen
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Set background for the panel
        setBackground(GUIConstants.GAME_OVER_TRANSLUCENCE);

        // Add the game over label
        JLabel gameOver = buildGameOverLabel();
        add(gameOver);

        // Add the restart game button
        add(buildRestartButton());
    }

    private JLabel buildGameOverLabel(){
        // Create the JLabel
        JLabel gameOverLabel = new JLabel(GUIConstants.GAME_OVER_STRING);
        // Set its alignment to center
        gameOverLabel.setAlignmentX(CENTER_ALIGNMENT);
        // Customize the font
        gameOverLabel.setFont(new Font(GUIConstants.DEFAULT_FONT, Font.BOLD,GUIConstants.HEADER_TEXT_SIZE));
        return gameOverLabel;
    }

    private JButton buildRestartButton(){
        // Create the JButton
        JButton restartButton = new JButton(GUIConstants.RESTART_BUTTON_STRING);
        // TODO: Customize the button
        restartButton.setAlignmentX(CENTER_ALIGNMENT);
        // Add the action listener
        restartButton.addActionListener(onRestart());
        return restartButton;
    }

    private ActionListener onRestart(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println(this.getClass().getName() + "=pressed;");
                manager.getGame().restartGame();
            }
        };
    }





}
