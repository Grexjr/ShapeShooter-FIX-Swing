package com.java.ShapeShooter.constants;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUIConstants {

    // COLORS
    public static final Color TRANSPARENT = new Color(0,0,0,0);

    //DEFAULTS
    public static final String DEFAULT_TEXT = "DEFAULT";
    public static final int DEFAULT_TEXT_SIZE = 12;
    public static final int DEFAULT_POS = 0;
    public static final int DEFAULT_BOUNDS = 10;
    public static final Color DEFAULT_COLOR = Color.MAGENTA;
    public static final Color DEFAULT_COLOR_2 = Color.BLACK;
    public static final String DEFAULT_BACKGROUND_FILE = "";
    public static final Font DEFAULT_FONT = new Font("Arial",Font.PLAIN,DEFAULT_TEXT_SIZE);

    // General Constants
    public static final Font STANDARD_FONT = new Font("Consolas",Font.PLAIN,DEFAULT_TEXT_SIZE);

    // General Screen Constants
    public static final String MAIN_MENU = "MainMenu";
    public static final String GAME_SCREEN = "GameScreen";

    // GUI Applet Constants
    public static final String GAME_TITLE = "SHAPE SHOOTER";
    public static final String ICON_FILE = "";

    public static final Dimension SCREEN_MINIMUM = new Dimension(800,600);


    // Menu Screen Constants
    public static final String START_STRING = "START";
    public static final String SETTINGS_STRING = "SETTINGS";
    public static final String CONTROLS_STRING = "CONTROLS";
    public static final String CREDITS_STRING = "CREDITS";
    public static final String COPYRIGHT_STRING = "\u00a9 2025 GrexGameStudios";
    public static final Border M_BUTTON_BORDER = new BevelBorder(0,Color.BLACK,Color.GRAY);
    public static final Font MAIN_TITLE_FONT = new Font("Courier New",Font.BOLD,75);
    public static final Font MAIN_MENU_FONT = new Font("Courier New",Font.BOLD,40);
    public static final Font COPYRIGHT_FONT = new Font("Courier New",Font.BOLD,18);











}
