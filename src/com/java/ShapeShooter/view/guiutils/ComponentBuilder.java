package com.java.ShapeShooter.view.guiutils;

import com.java.ShapeShooter.constants.GUIConstants;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class ComponentBuilder<T extends JComponent> {

    private final T component;

    //TODO: BORDER!!! -- find out how to do this because it's like building in a builder...

    public ComponentBuilder(T component){
        this.component = component;
    }

    public ComponentBuilder<T> setText(String text){
        if(component instanceof AbstractButton button){
            button.setText(text);
        } else if(component instanceof JLabel label){
            label.setText(text);
        } else if(component instanceof JTextComponent tComp){
            tComp.setText(text);
        } else {
            throw new IllegalArgumentException(
                    component.getClass().getSimpleName()+" does not support setText()"
            );
        }
        return this;
    }

    public ComponentBuilder<T> setBounds(int x, int y, int width, int height){
        component.setBounds(x,y,width,height);
        return this;
    }

    public ComponentBuilder<T> setMinimumSize(Dimension minimumSize){
        component.setMinimumSize(minimumSize);
        return this;
    }

    public ComponentBuilder<T> setPreferredSize(Dimension preferredSize){
        component.setPreferredSize(preferredSize);
        return this;
    }

    public ComponentBuilder<T> setMaximumSize(Dimension maximumSize){
        component.setMaximumSize(maximumSize);
        return this;
    }

    public ComponentBuilder<T> setBGColor(Color bgColor){
        component.setBackground(bgColor);
        return this;
    }

    public ComponentBuilder<T> setFGColor(Color fgColor){
        component.setForeground(fgColor);
        return this;
    }

    public ComponentBuilder<T> setIcon(ImageIcon icon){
        if(component instanceof JLabel label){
            label.setIcon(icon);
        } else if(component instanceof AbstractButton button){
            button.setIcon(icon);
        } else {
            throw new IllegalArgumentException(
                    component.getClass().getSimpleName()+" does not support setIcon()"
            );
        }
        return this;
    }

    public ComponentBuilder<T> setFont(Font font){
        component.setFont(font);
        return this;
    }

    public ComponentBuilder<T> setListener(ActionListener listener){
        if(component instanceof AbstractButton button){
            button.addActionListener(listener);
        } else if(component instanceof JComboBox<?> box){
            box.addActionListener(listener);
        } else if(component instanceof JTextField field){
            field.addActionListener(listener);
        } else {
            throw new IllegalArgumentException(
                    component.getClass().getSimpleName()+" does not support setListener()"
            );
        }
        return this;
    }

    /**
     * Configuration variables -- individual things like set enabled, editable, line wrap, etc., adding text
     * @param configurator the lambda that configures the component
     * @return the builder for chaining
     */
    public ComponentBuilder<T> configure(Consumer<T> configurator){
        configurator.accept(component);
        return this;
    }

    /**
     * Build method for the builder class
     * @return the component
     */
    public JComponent build(){
        return component;
    }





}
