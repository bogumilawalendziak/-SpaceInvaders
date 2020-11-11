package com.company;

import com.company.Objects.GameObject;
import com.company.Objects.ObjectID;

import java.awt.*;
import java.util.LinkedList;

public class ObjectList {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void add(GameObject object) {
        this.object.add(object);
    }

    public void remove(GameObject object) {
        this.object.remove(object);
    }


    public void update() {
        object.removeIf(o->o.getObjectId() == ObjectID.EnemyShoot & o.getBounds().intersects(new Rectangle(0,Window.HEIGHT,Window.WIDTH,10)));
        object.removeIf(o->o.getObjectId() == ObjectID.PlayerShoot & o.getBounds().intersects(new Rectangle(0,Window.HEIGHT,Window.WIDTH,10)));
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.update();
        }
    }

    public void render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
}
