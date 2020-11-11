package com.company.Objects;

import java.awt.*;

public abstract class GameObject {
    protected ObjectID objectId;
    protected int x, y, VY, VX;
    boolean exist = false;

    public GameObject(ObjectID objectId, int x, int y) {
        this.objectId = objectId;
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public ObjectID getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectID objectId) {
        this.objectId = objectId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVY() {
        return VY;
    }

    public void setVY(int VY) {
        this.VY = VY;
    }

    public int getVX() {
        return VX;
    }

    public void setVX(int VX) {
        this.VX = VX;
    }


}
