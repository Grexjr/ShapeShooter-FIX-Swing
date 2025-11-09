package com.java.ShapeShooter.view.abstracta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ButtonHolder {

    default ActionListener buildButtonListener(){
        return this::onButtonPress;
    }

    void onButtonPress(ActionEvent e);

}
