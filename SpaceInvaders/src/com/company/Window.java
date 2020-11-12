package com.company;

import javax.swing.*;
import java.awt.*;
/* Creating window to display game and adding components */

public class Window extends JFrame {
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    Game game;

    public Window(Game game) {
        super("Game");
        this.game = game;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setFocusable(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        add(game);

    }


}