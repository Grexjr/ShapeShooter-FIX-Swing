package com.java.gui;

import com.java.game.GUIManager;
import com.java.game.ShapeShooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsPanel extends JPanel {

    private final GUIManager manager;

    public InstructionsPanel(GUIManager manager){
        // Reference to game for sizing
        this.manager = manager;

        // Set the layout to box layout to layer text area above back button
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Customize the panel
        setBackground(GUIConstants.INSTRUCTIONS_PANEL_BACKGROUND);

        // Build and add the text to the panel
        JTextArea instructionsText = buildInstructionsText();
        add(instructionsText);

        // Build and add the back button to the panel
        JButton backButton = buildBackButton();
        add(backButton);
    }

    private JTextArea buildInstructionsText(){
        JTextArea textSpot = new JTextArea();
        initializeTextArea(textSpot);
        customizeTextArea(textSpot);
        return textSpot;
    }

    private void initializeTextArea(JTextArea textArea){
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(false); //Unsure which to do
        textArea.setText(GUIConstants.INSTRUCTIONS_TEXT);
    }

    private void customizeTextArea(JTextArea textArea){
        textArea.setBackground(GUIConstants.TRANSPARENT);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font(GUIConstants.DEFAULT_FONT,Font.BOLD,GUIConstants.NON_HEADER_TEXT_SIZE));
    }

    private JButton buildBackButton(){
        JButton backButton = new JButton(GUIConstants.BACK_BUTTON_STRING);
        // Set alignment to center
        backButton.setAlignmentX(CENTER_ALIGNMENT);
        // TODO: Do customizations here
        // Add the action listener
        backButton.addActionListener(onBack());
        return backButton;
    }

    private ActionListener onBack(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //DEBUG
                System.out.println(this.getClass().getName() + "=pressed;");
                    // call game to do hide instructions
                manager.hideInstructions();
            }
        };
    }




}
