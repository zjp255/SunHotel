package Ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    public MyButton(String text, ActionListener act, Font font,int x,int y) {
        super(text);
        addActionListener(act);
        setFont(font);
        setBounds(x,y,100,30);
        setBorderPainted(false);
        setFocusPainted(false);
    }
}
