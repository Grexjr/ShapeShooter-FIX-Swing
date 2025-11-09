package com.java.ShapeShooter.controller;

import com.java.ShapeShooter.constants.GameConstants;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GameLoop {

    private final AbstractGame game;
    private final Timer loop;

    public GameLoop(AbstractGame game){
        this.game = game;
        loop = new Timer(1000/ GameConstants.TARGET_FPS,onUpdate());
    }

    public void start(){
        loop.start();
    }

    public void stop(){
        loop.stop();
    }

    public void restart(){
        loop.restart();
    }

    private ActionListener onUpdate(){
        return e -> {
            game.update();
        };
    }




}
