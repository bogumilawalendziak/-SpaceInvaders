package com.company;

import com.company.Objects.Enemy;

import java.awt.*;
import java.util.LinkedList;
/*
* Creating LinkedList for Enemy in Game.
*/
public class EnemyList {
    public LinkedList<Enemy> object = new LinkedList<Enemy>();


    public void add(Enemy object) {
        this.object.add(object);
    }

    public void remove(Enemy object) {
        this.object.remove(object);
    }

// update parameters of Enemy
    public void update() {
        for (int i = 0; i < object.size(); i++) {
            Enemy tempObject = object.get(i);
            tempObject.update();
        }

    }
// Repainting Enemy
    public void render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            Enemy tempObject = object.get(i);
            tempObject.render(g);

        }
    }

}
