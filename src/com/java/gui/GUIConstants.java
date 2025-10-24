package com.java.gui;

import java.awt.*;

public class GUIConstants {

    // TODO: Customize buttons more

    // General variables
    protected static final String BACK_BUTTON_STRING = "BACK";
    protected static final int HEADER_TEXT_SIZE = 50;
    protected static final int NON_HEADER_TEXT_SIZE = 25;
    protected static final Color TRANSPARENT = new Color(0,0,0,0);
    protected static final String DEFAULT_FONT = "Lucida Console";

    // Frame variables
    protected static final String FRAME_TITLE = "Shape Shooter";
    protected static final int[] GAME_MINIMUM_SIZE = {800,600};
    protected static final int[] GAME_MAXIMUM_SIZE = {1920,1240};

    // Main Menu Variables
    protected static final String TITLE_STRING = "SHAPE SHOOTER";
    protected static final int GAME_TITLE_SIZE = 75;
    protected static final Dimension TITLE_PREFERRED_SIZE = new Dimension(100,50);
    protected static final int[] TITLE_SPACER = {50,0,50,0};

    protected static final String START_BUTTON_STRING = "START GAME";
    protected static final String INSTRUCTIONS_BUTTON_STRING = "INSTRUCTIONS";
    protected static final String SETTINGS_BUTTON_STRING = "SETTINGS";

    protected static final Dimension BUTTON_MINIMUM_SIZE = new Dimension(50,25);
    protected static final Dimension BUTTON_PREFERRED_SIZE = new Dimension(50,25);
    protected static final Dimension BUTTON_MAX_SIZE = new Dimension(200,50);
    protected static final Dimension BUTTON_SPACER = new Dimension(0,25);

    // Instructions panel variables
    protected static final Color INSTRUCTIONS_PANEL_BACKGROUND = new Color(10,10,10,70);
    protected static final String INSTRUCTIONS_TEXT = "PLACEHOLDER";

    // Game Over Screen Variables
    protected static final String GAME_OVER_STRING = "GAME OVER!";
    protected static final Color GAME_OVER_TRANSLUCENCE = new Color(10,10,10,20);
    protected static final String RESTART_BUTTON_STRING = "RESTART";

    // Game Screen Variables
    protected static final String MOVE_UP = "moveUp";
    protected static final String MOVE_LEFT = "moveLeft";
    protected static final String MOVE_RIGHT = "moveRight";
    protected static final String MOVE_DOWN = "moveDown";

}
