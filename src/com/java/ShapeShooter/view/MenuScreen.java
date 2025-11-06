package com.java.ShapeShooter.view;

import com.java.ShapeShooter.constants.GUIConstants;
import com.java.ShapeShooter.view.abstracta.AbstractScreen;
import com.java.ShapeShooter.view.abstracta.ButtonHolder;
import com.java.ShapeShooter.view.guiutils.ComponentBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends AbstractScreen implements ButtonHolder {

    private final ActionListener buttonListener;

    public MenuScreen(){
        super(null);
        buttonListener = buildButtonListener();

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(buildStartButton());
    }

    @Override
    public void render(Graphics2D g2){

    }

    @Override
    public void onButtonPress(ActionEvent e){
        switch(e.getActionCommand()){
            case GUIConstants.START_STRING -> System.out.println("Start pressed!");
        }
    }

    private JButton buildStartButton(){
        //TODO: Find way to fix casting, probably...
        return (JButton) new ComponentBuilder<>(new JButton())
                .setText(GUIConstants.START_STRING)
                .setBGColor(Color.WHITE)
                .setFGColor(Color.GREEN)
                //TODO Set icon
                .setFont(GUIConstants.STANDARD_FONT)
                .setListener(buttonListener)
                .configure(b -> {
                    b.setAlignmentX(CENTER_ALIGNMENT);
                })
                .build();
    }







}
