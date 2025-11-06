package com.java.ShapeShooter.view.guiutils;

import com.java.ShapeShooter.constants.GUIConstants;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class ButtonBuilder {

    private String text = GUIConstants.DEFAULT_TEXT;
    private ActionListener listener;
    private int x = GUIConstants.DEFAULT_BOUNDS, y = GUIConstants.DEFAULT_BOUNDS, width = GUIConstants.DEFAULT_BOUNDS,
        height = GUIConstants.DEFAULT_BOUNDS;
    private Color bgColor = GUIConstants.DEFAULT_COLOR;
    private Color fgColor = GUIConstants.DEFAULT_COLOR_2;
    private BufferedImage bgImage; //TODO: define with sprite loader
    private Font font = GUIConstants.DEFAULT_FONT;

    public ButtonBuilder setText(String text){
        this.text = text;
        return this;
    }

    public ButtonBuilder setListener(ActionListener listener){
        this.listener = listener;
        return this;
    }

    public ButtonBuilder setBounds(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        return this;
    }

    public ButtonBuilder setBackground(Color bgColor){
        this.bgColor = bgColor;
        return this;
    }

    public ButtonBuilder setForeground(Color fgColor){
        this.fgColor = fgColor;
        return this;
    }

    public ButtonBuilder setBGImage(BufferedImage bgImage){
        this.bgImage = bgImage;
        return this;
    }

    public ButtonBuilder setFont(Font font){
        this.font = font;
        return this;
    }

}
