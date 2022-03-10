package org.dojo;

public abstract class ActableMovingObject {
    protected float x, y, z;
    protected float xSpeed, ySpeed, zSpeed;
    protected float xAccel, yAccel, zAccel;

    public void act() {
        move();
        show();
    }

    public void move() {
        x += xSpeed;
        xSpeed += xAccel;
        y += ySpeed;
        ySpeed += yAccel;
        z += zSpeed;
        zSpeed += zAccel;
    }

    public abstract void show();
}
