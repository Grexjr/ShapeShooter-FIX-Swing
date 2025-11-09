package com.java.ShapeShooter.controller;

import com.java.ShapeShooter.constants.GUIConstants;

public class ShapeShooter extends AbstractGame {

    public ShapeShooter(){

    }

    @Override
    public void onStart(){
        showMainMenu();
    }

    private void showMainMenu(){
        gui.loadScreen(GUIConstants.MAIN_MENU);
        gui.setCurrentScreen(gui.get(GUIConstants.MAIN_MENU));
    }

    @Override
    public void update(){
        // Must call the super method -- covers rendering the current screen
        super.update();
        //Then define custom update logic

    }






}
