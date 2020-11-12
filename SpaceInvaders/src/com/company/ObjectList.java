package com.company;

import com.company.Objects.GameObject;
import com.company.Objects.ObjectID;

import java.awt.*;
import java.util.LinkedList;
/*
* Class for any object that isn't Enemy - shoot from player, shoot from enemy and Player.
* Objects are in LinkedList
* */
public class ObjectList {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void add(GameObject object) {
        this.object.add(object);
    }

    public void remove(GameObject object) {
        this.object.remove(object);
    }

    // checking if any object in LinkedList has to be removed, else in for loop update actual parameters
    public void update() {
        object.removeIf(o->o.getObjectId() == ObjectID.EnemyShoot & o.getBounds().intersects(new Rectangle(0,Window.HEIGHT,Window.WIDTH,10)));
        object.removeIf(o->o.getObjectId() == ObjectID.PlayerShoot & o.getBounds().intersects(new Rectangle(0,Window.HEIGHT,Window.WIDTH,10)));
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.update();
        }
    }
    // repainting every object in LinkedList with updated parameters
    public void render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
}
