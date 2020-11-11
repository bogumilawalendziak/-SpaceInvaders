package com.company.Objects;

import com.company.ObjectList;
import com.company.Window;

import java.awt.*;

public class Shoot extends GameObject {
    ObjectSheet objectSheet;
    ObjectList objectList;
    int tick = 0;

    public Shoot(ObjectID objectId, int x, int y, ObjectSheet objectSheet, ObjectList objectList) {
        super(objectId, x, y);
        this.objectSheet = objectSheet;
        this.objectList = objectList;
    }


    public void render(Graphics g) {
        if (getObjectId() == ObjectID.PlayerShoot) {
            g.drawImage(objectSheet.playerShoot, x, y, null);
        } else if (getObjectId() == ObjectID.EnemyShoot) {
            g.drawImage(objectSheet.enemyShoot, x, y, null);
        }
    }

    @Override
    public void update() {
        if (getBounds().intersects(new Rectangle(0, com.company.Window.HEIGHT, Window.WIDTH, 10))) {
            objectList.remove(this);
        }
        tick++;
        if (tick == 2) {
            if (getObjectId() == ObjectID.PlayerShoot) {
                y = y - 8;
                tick = 0;
            } else if (getObjectId() == ObjectID.EnemyShoot) {
                y = y + 6;
                tick = 0;
            }
        }


    }
}


