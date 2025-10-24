package com.java.gui;

import com.java.game.ShapeShooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;

public class SettingsPanel extends JPanel {

    private ShapeShooter shapeShoot;

    public SettingsPanel(ShapeShooter game){
        // TODO: Figure out what settings to even add
        // Add the game reference
        shapeShoot = game;

        // Set the layout (border layout for now to stack settings things on top of each other)
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Set the background to black
        setBackground(Color.BLACK);

        //Add settings here
        //TODO: Volume

        // Add back button
        JButton button = buildBackButton();
        add(button);
    }

    private JButton buildBackButton(){
        // Create the button
        JButton backButton = new JButton(GUIConstants.BACK_BUTTON_STRING);
        // Set alignment
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        // Add ActionListener
        backButton.addActionListener(onBack());
        return backButton;
    }

    private ActionListener onBack(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DEBUG
                System.out.println(this.getClass().getName() + "=pressed;");
                // Call on game to hide the settings screen
                shapeShoot.hideSettings();
            }
        };
    }





}
