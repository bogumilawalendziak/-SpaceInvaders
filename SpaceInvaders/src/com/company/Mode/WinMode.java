package com.company.Mode;

import com.company.EnemyList;
import com.company.Game;
import com.company.ObjectList;
import com.company.Objects.ObjectSheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WinMode extends GameMode implements MouseListener {

    static int playX = 235;
    static int playY = 265;
    static int boxWidth = 105;
    static int boxHeight = 50;

    public WinMode(EnemyList enemyList, ObjectList objectList, ObjectSheet objectSheet, Game game) {
        super(objectList, enemyList, objectSheet, game);
        game.addMouseListener(this);
        enemyList.object.clear();
        objectList.object.remove();
        objectList.object.clear();
    }


    public static GameMode getActualMode() {
        return actualMode;
    }

    public static void setActualMode(GameMode mode) {
        actualMode = mode;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 52);
        g.setColor(Color.black);
        g.fillRect(0, 0, 650, 440);
        g2d.setFont(font);
        g.setColor(Color.yellow);
        g2d.drawString("YOU WIN", 170, 210);


        Font font2 = new Font("Serif", Font.PLAIN, 32);
        g2d.setFont(font2);

        g.setColor(Color.yellow);
        g.drawRect(playX, playY, boxWidth, boxHeight);
        g.setColor(Color.green);
        g2d.drawString("MENU", 240, 300);
    }

    public void update() {

    }

    public Rectangle getBounds() {
        return new Rectangle(playX, playY, boxWidth, boxHeight);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (getBounds().contains(x, y)) {
            game.removeMouseListener(this);
            GameMode.setActualMode(new MenuMode(enemyList, objectList, objectSheet, game));
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
