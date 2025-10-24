package com.java.gui;

import com.java.game.ShapeShooter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JPanel {

    private ShapeShooter shapeShoot;

    public MainMenuScreen(ShapeShooter game){
        // Reference to the game object to call upon start methods etc
        shapeShoot = game;

        // Set the layout of this panel; box panel for vertical stacking of components
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Set the background color of this label to plain black
        setBackground(Color.BLACK);

        // Add the main title label
        addTitleLabel();

        // Add the start game button
        addStartButton();

        // Add a rigid area between buttons
        addButtonSpace();

        // Add the instructions button
        addInstructionsButton();

        // Add a rigid area between buttons
        addButtonSpace();

        // Add the settings button
        addSettingsButton();
    }

    private void addTitleLabel(){
        // Create the title label
        JLabel titleLabel = new JLabel(GUIConstants.TITLE_STRING);
        // Set the preferred size of the title label
        titleLabel.setPreferredSize(GUIConstants.TITLE_PREFERRED_SIZE);
        // Set the alignment of the title label in the box layout
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        // Create the font for the main title label | TODO: Custom robotic font from internet?
        titleLabel.setFont(new Font(GUIConstants.DEFAULT_FONT,Font.BOLD,GUIConstants.GAME_TITLE_SIZE));
        // Set the color of the font to white | TODO: Do a cool color, maybe a cool effect if you can manage it
        titleLabel.setForeground(Color.WHITE);
        // Add the spacer
        titleLabel.setBorder(createSpacer());
        // Add the title label
        add(titleLabel);

        // Interestingly, I never set this visible, and yet it still shows up
    }

    private void addStartButton(){
        // Create the button
        JButton startButton = new JButton(GUIConstants.START_BUTTON_STRING);

        // Set the dimensions of the button
        setDimensions(startButton);

        // Set the alignment of the button in the box layout
        startButton.setAlignmentX(CENTER_ALIGNMENT);
        // TODO: Font for the start button text?
        // TODO: Custom color for the start button itself?
        // TODO: Find a way to add a space between the buttons as well

        // Add the Action Listener to the start button
        startButton.addActionListener(onStart());

        // Add the start button
        add(startButton);
    }

    private void addInstructionsButton(){
        // Create the button
        JButton instructionsButton = new JButton(GUIConstants.INSTRUCTIONS_BUTTON_STRING);

        // Set the dimensions of the button
        setDimensions(instructionsButton);

        // Set the alignment of the button in the box layout
        instructionsButton.setAlignmentX(CENTER_ALIGNMENT);

        // Add the Action Listener
        instructionsButton.addActionListener(onInstructions());

        // Add the instructions button
        add(instructionsButton);

    }

    private void addSettingsButton(){
        // Create the button
        JButton settingsButton = new JButton(GUIConstants.SETTINGS_BUTTON_STRING);

        // set the dimensions of the button
        setDimensions(settingsButton);

        // Set the alignment of the button in the box layout
        settingsButton.setAlignmentX(CENTER_ALIGNMENT);

        // Add the action Listener
        settingsButton.addActionListener(onSettings());

        // Add the settings button
        add(settingsButton);
    }

    private ActionListener onStart(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG | TODO: May be better with a custom button class, but that's okay; would be overkill for now
                System.out.println(this.getClass().getName() + "=pressed;");
                // Start the game
                shapeShoot.startGame();
            }
        };
    }

    private ActionListener onInstructions(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println(this.getClass().getName() + "=pressed");
                // Show the instructions panel
                shapeShoot.showInstructions();
            }
        };
    }

    private ActionListener onSettings(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println(this.getClass().getName() + "=pressed");
                // Show the settings screen
                shapeShoot.goToSettings();
            }
        };
    }

    private EmptyBorder createSpacer(){
        return new EmptyBorder(
                GUIConstants.TITLE_SPACER[0],
                GUIConstants.TITLE_SPACER[1],
                GUIConstants.TITLE_SPACER[2],
                GUIConstants.TITLE_SPACER[3]
        );
    }

    private void setDimensions(JButton button){
        // Set the preferred size of the button
        button.setPreferredSize(GUIConstants.BUTTON_PREFERRED_SIZE);
        // Set the minimum size allowed for the button
        button.setMinimumSize(GUIConstants.BUTTON_MINIMUM_SIZE);
        // Set the maximum size allowed for the button to allow it to fill the space
        button.setMaximumSize(GUIConstants.BUTTON_MAX_SIZE);
    }

    private void addButtonSpace(){
        add(Box.createRigidArea(GUIConstants.BUTTON_SPACER));
    }



}
