package com.company.Objects;

import com.company.EnemyList;
import com.company.Game;
import com.company.Mode.GameMode;
import com.company.Mode.GameOverMode;
import com.company.ObjectList;
import com.company.Window;

import java.awt.*;

public class Player extends GameObject {
    static int lifeBar = 5;
    ObjectSheet objectSheet;
    ObjectList objectList;
    EnemyList enemyList;
    Game game;
    int life;

    public Player(ObjectID objectId, int x, int y, ObjectSheet objectSheet, ObjectList objectList, EnemyList enemyList, Game game) {
        super(objectId, x, y);
        this.enemyList = enemyList;
        this.objectSheet = objectSheet;
        this.objectList = objectList;
        this.game = game;
        setLife(lifeBar);
    }

    public void render(Graphics g) {

        g.drawImage(ObjectSheet.player, x, y, null);
        g.setColor(Color.gray);
        g.fillRect(10, 10, 20 * lifeBar + 2, 20);
        g.setColor(Color.red);
        g.fillRect(11, 11, 20 * getLife(), 18);

    }

    @Override
    public void update() {
        x += VX;
        y += VY;

        moveRange();
        collision();

    }

    public void moveRange() {
        if (x >= 385) x = 385;
        else if (x <= 190) x = 190;
        if (y >= Window.HEIGHT - 2 * ObjectSheet.height) y = Window.HEIGHT - 2 * ObjectSheet.height;
        else if (y <= 350) y = 350;
    }

    public void collision() {
        for (int i = 0; i < objectList.object.size(); i++) {
            GameObject temObj = objectList.object.get(i);
            if (temObj.getObjectId() == ObjectID.EnemyShoot)
                if (getBounds().intersects(temObj.getBounds())) {
                    objectList.remove(temObj);
                    setLife(getLife() - 1);
                }
            if (getLife() == 0) {
                GameMode.setActualMode(new GameOverMode(game, objectList, enemyList, objectSheet));
            }
        }
    }


    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}



