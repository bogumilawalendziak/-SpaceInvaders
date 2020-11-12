package com.company.GameMode;

import com.company.Control.KeyAdapter;
import com.company.EnemyList;
import com.company.Game;
import com.company.ObjectList;
import com.company.Objects.Enemy;
import com.company.Objects.ObjectID;
import com.company.Objects.ObjectSheet;
import com.company.Objects.Player;

import java.awt.*;


public class PlayMode extends GameMode {


    public PlayMode(EnemyList enemyList, ObjectList objectList, ObjectSheet objectSheet, Game game, KeyAdapter keyAdapter) {
        super(objectList, enemyList, objectSheet, game);
// Creating and adding Enemy to Enemy List
// 4 row, 7 columns
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                enemyList.add(new Enemy(ObjectID.Enemy, 190 + 32 * i, 100 + 32 * j, objectSheet, objectList, enemyList, false, game));
            }
        }
        // setting first row to be able to shoot
        for (int c = 3; c < enemyList.object.size(); c = c + 4) {
            enemyList.object.get(c).setFire(true);
        }
        //adding one player
        objectList.add(new Player(ObjectID.Player, 300, 380, objectSheet, objectList, enemyList, game));
    }


    public static GameMode getActualMode() {
        return actualMode;
    }

    public static void setActualMode(GameMode mode) {
        actualMode = mode;
    }

    public void render(Graphics g) {
        //painting enemy list, object list and background
        g.setColor(Color.black);
        g.fillRect(0, 0, 650, 440);
        enemyList.render(g);
        objectList.render(g);
    }

    public void update() {
        if (enemyList.object.size() <= 0) GameMode.setActualMode(new WinMode(enemyList, objectList, objectSheet, game));
        enemyList.update();
        objectList.update();
    }
}
