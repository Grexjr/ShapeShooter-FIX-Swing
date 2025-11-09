package com.java.ShapeShooter.view;

import com.java.ShapeShooter.constants.GUIConstants;
import com.java.ShapeShooter.view.abstracta.AbstractScreen;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(){
        setTitle(GUIConstants.GAME_TITLE);
        setMinimumSize(GUIConstants.SCREEN_MINIMUM);
        setPreferredSize(GUIConstants.SCREEN_MINIMUM);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage();
    }

    public void init(){
        setVisible(true);
    }

    public void swapScreen(AbstractScreen screen){
        setContentPane(screen);
        refresh();
    }

    public void refresh(){
        repaint();
        revalidate();
    }





}
