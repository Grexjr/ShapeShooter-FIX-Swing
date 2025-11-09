package com.java.ShapeShooter.controller;

public abstract class AbstractGame {

    // ScreenController object, ObjectManager object, Game Loop object
    protected final ScreenController gui;
    protected final ObjectManager objects;
    protected final GameLoop loop;

    public AbstractGame(){
        gui = new ScreenController();
        objects = new ObjectManager();
        loop = new GameLoop(this);
        init();

        onStart();
    }

    public void update(){
        gui.getCurrentScreen().repaint();
    }

    private void init(){
        gui.init();
        objects.init();
    }

    public abstract void onStart();

}
