package com.java.ShapeShooter.view;

import com.java.ShapeShooter.constants.GUIConstants;
import com.java.ShapeShooter.constants.GameConstants;
import com.java.ShapeShooter.controller.ScreenController;
import com.java.ShapeShooter.controller.ShapeShooter;
import com.java.ShapeShooter.view.abstracta.AbstractScreen;
import com.java.ShapeShooter.view.abstracta.ButtonHolder;
import com.java.ShapeShooter.view.guiutils.ComponentBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MenuScreen extends AbstractScreen implements ButtonHolder {

    private final ScreenController manager;
    private final ActionListener buttonListener;

    private final ArrayList<JButton> buttons;
    private final ArrayList<Rectangle2D> shapes;

    private final JPanel buttonPanel;

    //TODO: Find some way to make the buttons still grow in size, stay centered, and all have the same width.

    public MenuScreen(ScreenController manager){
        super(null);
        this.manager = manager;
        buttonListener = buildButtonListener();
        buttons = new ArrayList<>();
        shapes = new ArrayList<>();

        //TODO: Set the layout to null and create a box layout button panel in the center
        setLayout(null);
        buttonPanel = new JPanel();

        buttonPanel.setBackground(GUIConstants.TRANSPARENT);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));

        add(buttonPanel);

        // Add all buttons to arraylist for access and formatting
        buttons.add(buildMenuButton(GUIConstants.START_STRING,Color.GREEN));
        buttons.add(buildMenuButton(GUIConstants.SETTINGS_STRING,Color.BLUE));
        buttons.add(buildMenuButton(GUIConstants.CONTROLS_STRING,Color.RED));
        buttons.add(buildMenuButton(GUIConstants.CREDITS_STRING,Color.ORANGE));

        // Add the main title to the menu screen
        addMenuTitle();

        // Add all buttons to the menu screen
        addButtons();

        // Add the copyright string
        addCopyright();
    }

    @Override
    public void init(){
        doLayout();
    }

    @Override
    public void render(Graphics2D g2){

    }

    @Override
    public void doLayout(){
        super.doLayout();
        buttonPanel.setBounds(
                0,
                0,
                this.getWidth(),
                this.getHeight()
        );
    }

    @Override
    public void onButtonPress(ActionEvent e){
        switch(e.getActionCommand()){
            case GUIConstants.START_STRING -> {
                manager.unloadScreen(GUIConstants.MAIN_MENU);
                manager.loadScreen(GUIConstants.GAME_SCREEN);
                manager.setCurrentScreen(manager.get(GUIConstants.GAME_SCREEN));
            }
            case GUIConstants.SETTINGS_STRING -> System.out.println("Settings pressed!");
            case GUIConstants.CONTROLS_STRING -> System.out.println("Controls pressed!");
            case GUIConstants.CREDITS_STRING -> System.out.println("Credits pressed!");
        }
    }

    private JButton buildMenuButton(String menuOption, Color textColor){
        return (JButton) new ComponentBuilder<>(new JButton())
                .setText(menuOption)
                .setBGColor(Color.WHITE)
                .setFGColor(textColor)
                .setFont(GUIConstants.MAIN_MENU_FONT)
                .setBorder(GUIConstants.M_BUTTON_BORDER)
                .setListener(buttonListener)
                .configure(b -> {
                    b.setAlignmentX(CENTER_ALIGNMENT);
                    b.setFocusable(false);
                })
                .build();
    }


    /* Find a way to use this to set the sizing properly; nested panels of buttons, perhaps
    private Dimension configurePreferredSize(){
        int uniformWidth = 0;
        int uniformHeight = 0;

        for(JButton b : buttons){
            Dimension d = b.getPreferredSize();
            uniformWidth = Math.max(uniformWidth,d.width);
            uniformHeight = Math.max(uniformHeight,d.height);
        }
        return new Dimension(uniformWidth,uniformHeight);
    }*/
    private JLabel buildMenuLabel(String text,Color textColor,Font font){
        return (JLabel) new ComponentBuilder<>(new JLabel())
                .setText(text)
                .setFGColor(textColor)
                .setFont(font)
                .configure(l -> {
                    l.setAlignmentX(CENTER_ALIGNMENT);
                })
                .build();
    }

    private void addButtons(){
        for(JButton b: buttons){
            buttonPanel.add(b);
            buttonPanel.add(Box.createVerticalGlue());
            buttonPanel.add(Box.createHorizontalGlue());
        }
    }

    private void addMenuTitle(){
        buttonPanel.add(buildMenuLabel(GUIConstants.GAME_TITLE,Color.BLACK,GUIConstants.MAIN_TITLE_FONT));
        buttonPanel.add(Box.createVerticalGlue());
    }

    private void addCopyright(){
        buttonPanel.add(buildMenuLabel(GUIConstants.COPYRIGHT_STRING,Color.BLACK,GUIConstants.COPYRIGHT_FONT));
        buttonPanel.add(Box.createVerticalGlue());
    }







}
