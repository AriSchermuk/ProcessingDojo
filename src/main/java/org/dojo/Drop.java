package org.dojo;

import processing.core.PApplet;

public class Drop {
    private PApplet p;

    public Drop(PApplet p) {
        this.p = p;
        restartPhysics();
    }

    private void restartPhysics() {
        this.x = p.random(p.width);
        this.y = p.random(-200, -100);
        this.z = p.random(1,20);
        this.xSpeed = 0;
        this.ySpeed = p.map(z,1,20,0.5F,3);
        this.yAccel = p.map(z,1,20,0.2F,1);
        this.weight = p.map(z,1,20,1,3);
        this.lenght = p.map(z,1,20,7,18);
    }

    private float x, y, z;
    private float xSpeed, ySpeed;
    private float yAccel;
    private float weight, lenght;

    public void move() {
        x += xSpeed;
        y += ySpeed;
        ySpeed += yAccel;
        if (y>p.height){
            splash();
            restartPhysics();
        }
    }

    private void splash() {
    }


    public void show() {
        p.stroke(50, 50, 200);
        p.strokeWeight(weight);
        p.line(x, y, x, y - lenght);
    }
}
