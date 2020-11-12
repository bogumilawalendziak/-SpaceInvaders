package com.company.Objects;

import com.company.Game;
import com.company.ObjectList;
import com.company.EnemyList;
import com.company.GameMode.GameMode;
import com.company.GameMode.WinMode;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject{
    Game game;
    ObjectSheet objectSheet;
    ObjectList objectList;
    EnemyList enemyList;
    boolean fire;
    int tick=0;
    Random rnd = new Random();
    int dx= 15;
    int numberOnShoot = 1;
    int speedOfShooting;


    public Enemy(ObjectID objectId, int x, int y, ObjectSheet objectSheet, ObjectList objectList, EnemyList enemyList, boolean fire, Game game){
        super(objectId,x,y);
        this.enemyList = enemyList;
        this.objectSheet = objectSheet;
        this.objectList = objectList;
        this.fire=fire;
        this.game=game;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,20,20);
    }

    public void render(Graphics g) {
        g.drawImage(objectSheet.enemy, x, y, null);

    }

    @Override
    public void update() {
        collision();
//calculate frequency of enemy's shooting
        if(enemyList.object.size() > 7) {
            speedOfShooting = enemyList.object.size();
        }else speedOfShooting =7;
            int randomShootTick = rnd.nextInt(100 * (speedOfShooting / 7));
            tick++;
            // checking if calculated random number is equal 1 (hardcoded value)
            if (fire & numberOnShoot == randomShootTick)
                objectList.add(new Shoot(ObjectID.EnemyShoot, getX(), getY(), objectSheet, objectList));

            // moving enemy from right to left
            if (tick == 60) {
                setX(x + dx);
            } else if (tick == 90) {
                setX(x - dx);
                tick = 0;
            }

    }

    public void collision(){
        //checking if enemy list is empty , or else if object was hit, then remove object and check if object behind him is able to start shooting
        if (enemyList.object.size() == 0) GameMode.setActualMode(new WinMode(enemyList, objectList, objectSheet, game));
        else if (objectList.object.removeIf(o -> o.getObjectId() == ObjectID.PlayerShoot & getBounds().intersects(o.getBounds()))){
            //assign actual enemy index to variable
            int indexOfShootedEnemy = enemyList.object.indexOf(this);
            //checking if index is >0 to avoid out of bounds exception, if is, then setFire
            if(indexOfShootedEnemy-1>0)
             enemyList.object.get(indexOfShootedEnemy-1).setFire(true);
            // remove object
             enemyList.object.remove(this);
        }


    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }


}




