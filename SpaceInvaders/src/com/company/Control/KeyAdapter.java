package com.company.Control;


import com.company.EnemyList;
import com.company.Mode.GameOverMode;
import com.company.ObjectList;
import com.company.Objects.GameObject;
import com.company.Objects.ObjectID;
import com.company.Objects.ObjectSheet;
import com.company.Objects.Shoot;

import java.awt.event.KeyEvent;


public class KeyAdapter extends java.awt.event.KeyAdapter {
    ObjectList objectList;
    ObjectSheet objectSheet;
    EnemyList enemyList;

    public KeyAdapter(ObjectList objectList, ObjectSheet objectSheet, EnemyList enemyList) {
        this.objectList = objectList;
        this.objectSheet = objectSheet;
        this.enemyList = enemyList;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < objectList.object.size(); i++) {
            GameObject tempObj = objectList.object.get(i);
            if (tempObj.getObjectId() == ObjectID.Player) {
                if (key == KeyEvent.VK_RIGHT) tempObj.setVX(4);
                else if (key == KeyEvent.VK_LEFT) tempObj.setVX(-4);
                else if (key == KeyEvent.VK_DOWN) tempObj.setVY(4);
                else if (key == KeyEvent.VK_UP) tempObj.setVY(-4);

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        for (int i = 0; i < objectList.object.size(); i++) {
            GameObject tempObj = objectList.object.get(i);
            if (tempObj.getObjectId() == ObjectID.Player) {
                if (key == KeyEvent.VK_RIGHT) tempObj.setVX(0);
                else if (key == KeyEvent.VK_LEFT) tempObj.setVX(0);
                else if (key == KeyEvent.VK_DOWN) tempObj.setVY(0);
                else if (key == KeyEvent.VK_UP) tempObj.setVY(0);
                else if (key == KeyEvent.VK_SPACE) {
                    objectList.add(new Shoot(ObjectID.PlayerShoot, tempObj.getX(), tempObj.getY(), objectSheet, objectList));
                }
            }
        }
    }
}