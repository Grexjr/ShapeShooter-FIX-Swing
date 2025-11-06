package com.java.ShapeShooter.main;

import com.java.ShapeShooter.view.GameFrame;
import com.java.ShapeShooter.view.MenuScreen;

import java.awt.*;

public class Main {

    public static void main(String[] args){
        GameFrame g = new GameFrame();
        g.init();
        g.swapScreen(new MenuScreen());
    }

}
