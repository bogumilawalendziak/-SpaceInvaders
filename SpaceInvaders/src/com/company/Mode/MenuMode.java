package com.company.Mode;

import com.company.EnemyList;
import com.company.Game;
import com.company.ObjectList;
import com.company.Objects.ObjectSheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuMode extends GameMode implements MouseListener {

    static int playX = 240;
    static int playY = 180;
    static int boxWidth = 100;
    static int boxHeight = 50;

    public MenuMode(EnemyList enemyList, ObjectList objectList, ObjectSheet objectSheet, Game game) {
        super(objectList, enemyList, objectSheet, game);

        game.addMouseListener(this);

    }


    public static GameMode getActualMode() {
        return actualMode;
    }

    public static void setActualMode(GameMode mode) {
        actualMode = mode;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 32);
        g.setColor(Color.black);
        g.fillRect(0, 0, 650, 440);
        g2d.setFont(font);
        g.setColor(Color.yellow);
        g.drawRect(playX, playY, boxWidth, boxHeight);
        g.setColor(Color.green);
        g2d.drawString("PLAY", 248, 214);
    }

    public void update() {

    }

    public Rectangle getBounds() {
        return new Rectangle(playX, playY, boxWidth, boxHeight);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (getBounds().contains(x, y)) {
            game.removeMouseListener(this);
            GameMode.setActualMode(new PlayMode(enemyList, objectList, objectSheet, game, game.getKeyAdapter()));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
