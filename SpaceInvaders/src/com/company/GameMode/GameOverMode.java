package com.company.GameMode;

import com.company.EnemyList;
import com.company.Game;
import com.company.ObjectList;
import com.company.Objects.ObjectSheet;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameOverMode extends GameMode implements MouseListener {


    static int playX = 195;
    static int playY = 275;
    static int boxWidth = 200;
    static int boxHeight = 50;

    public GameOverMode(Game game, ObjectList objectList, EnemyList enemyList, ObjectSheet objectSheet) {
        super(objectList, enemyList, objectSheet, game);

        game.addMouseListener(this);
        // remove object from list enemyList and objectList
        enemyList.object.remove();
        enemyList.object.clear();
        objectList.object.remove();
        objectList.object.clear();
    }


    public void render(Graphics g) {
//Painting GAME OVER word
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 52);
        g.setColor(Color.black);
        g.fillRect(0, 0, 650, 440);
        g2d.setFont(font);
        g.setColor(Color.blue);
        g2d.drawString("GAME OVER", 170, 210);

//Painting MENU word
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
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

// checking if clicked on "MENU" word(box)
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
