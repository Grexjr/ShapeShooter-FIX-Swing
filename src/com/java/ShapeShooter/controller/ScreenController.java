package com.java.ShapeShooter.controller;

import com.java.ShapeShooter.constants.GUIConstants;
import com.java.ShapeShooter.view.GameFrame;
import com.java.ShapeShooter.view.GameScreen;
import com.java.ShapeShooter.view.MenuScreen;
import com.java.ShapeShooter.view.abstracta.AbstractScreen;

import java.awt.*;
import java.util.HashMap;

public class ScreenController {

    private final GameFrame frame;
    private final HashMap<String, AbstractScreen> loadedScreens;
    private AbstractScreen currentScreen;

    public ScreenController(){
        frame = new GameFrame();
        loadedScreens = new HashMap<>();
    }

    public AbstractScreen getCurrentScreen(){return currentScreen;}
    public void setCurrentScreen(AbstractScreen newScreen){
        currentScreen = newScreen;
        frame.swapScreen(currentScreen);
        currentScreen.init();
    }

    public AbstractScreen get(String key){
        return loadedScreens.get(key);
    }

    public void loadScreen(String key){
        switch(key){
            case GUIConstants.MAIN_MENU -> {loadedScreens.put(GUIConstants.MAIN_MENU,new MenuScreen(this));}
            case GUIConstants.GAME_SCREEN -> {loadedScreens.put(GUIConstants.GAME_SCREEN,new GameScreen(this));}
        }
    }

    public void unloadScreen(String key){
        switch(key){
            case GUIConstants.MAIN_MENU -> {loadedScreens.remove(GUIConstants.MAIN_MENU);}
            case GUIConstants.GAME_SCREEN -> {loadedScreens.remove(GUIConstants.GAME_SCREEN);}
        }
    }

    protected void init(){
        frame.init();
    }






}
