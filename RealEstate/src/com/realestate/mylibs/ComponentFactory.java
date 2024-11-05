package com.realestate.mylibs;

// ComponentFactory.java
import javax.swing.*;

public class ComponentFactory {

    public static JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        return textField;
    }

    public static JPasswordField createPasswordField(int columns) {
        JPasswordField passwordField = new JPasswordField(columns);
        return passwordField;
    }

    public static JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        return label;
    }
}
