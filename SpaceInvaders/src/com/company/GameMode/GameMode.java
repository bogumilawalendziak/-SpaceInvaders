package com.company.GameMode;

import com.company.EnemyList;
import com.company.Game;
import com.company.ObjectList;
import com.company.Objects.ObjectSheet;

import java.awt.*;
/*
* Base class for Game Modes
*/
public class GameMode extends Frame {
    static GameMode actualMode = null;
    ObjectList objectList;
    EnemyList enemyList;
    ObjectSheet objectSheet;
    Game game;

    public GameMode(ObjectList objectList, EnemyList enemyList, ObjectSheet objectSheet, Game game) {
        this.objectList = objectList;
        this.enemyList = enemyList;
        this.objectSheet = objectSheet;
        this.game = game;

    }

    public static GameMode getActualMode() {
        return actualMode;
    }

    public static void setActualMode(GameMode mode) {
        actualMode = mode;
    }

    public void render(Graphics g) {

    }

    public void update() {

    }

    public ObjectList getObjectList() {
        return objectList;
    }

    public void setObjectList(ObjectList objectList) {
        this.objectList = objectList;
    }

    public EnemyList getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(EnemyList enemyList) {
        this.enemyList = enemyList;
    }

    public ObjectSheet getObjectSheet() {
        return objectSheet;
    }

    public void setObjectSheet(ObjectSheet objectSheet) {
        this.objectSheet = objectSheet;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
