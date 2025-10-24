package com.java.gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame(){
        super(GUIConstants.FRAME_TITLE);
        setMinimumSize(new Dimension(GUIConstants.GAME_MINIMUM_SIZE[0],GUIConstants.GAME_MINIMUM_SIZE[1]));
        setMaximumSize(new Dimension(GUIConstants.GAME_MAXIMUM_SIZE[0],GUIConstants.GAME_MAXIMUM_SIZE[1]));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }



}
