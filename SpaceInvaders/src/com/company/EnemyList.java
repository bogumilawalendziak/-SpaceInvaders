package com.company;

import com.company.Objects.Enemy;

import java.awt.*;
import java.util.LinkedList;

public class EnemyList {
    public LinkedList<Enemy> object = new LinkedList<Enemy>();


    public void add(Enemy object) {
        this.object.add(object);
    }

    public void remove(Enemy object) {
        this.object.remove(object);
    }


    public void update() {
        for (int i = 0; i < object.size(); i++) {
            Enemy tempObject = object.get(i);
            tempObject.update();
        }

    }

    public void render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            Enemy tempObject = object.get(i);
            tempObject.render(g);

        }
    }

}
