package com.java.ShapeShooter.view;

import com.java.ShapeShooter.controller.ScreenController;
import com.java.ShapeShooter.view.abstracta.AbstractScreen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameScreen extends AbstractScreen {

    public GameScreen(ScreenController manager){
        super(null);
        System.out.println("Game!");
    }

    @Override
    public void refresh() {
        super.refresh();
    }

    @Override
    public void init() {

    }

    @Override
    public void render(Graphics2D g2) {

    }
}
