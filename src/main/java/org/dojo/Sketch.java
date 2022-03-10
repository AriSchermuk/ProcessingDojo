package org.dojo;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Sketch extends PApplet {
    private List<ActableMovingObject> objects;

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        objects = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            objects.add(new Drop());
        }
    }

    @Override
    public void draw() {
        background(20, 20, 70);
        objects.forEach(ActableMovingObject::act);
    }

    public class Drop extends ActableMovingObject {

        public Drop() {
            restartPhysics();
        }

        private void restartPhysics() {
            this.x = random(width);
            this.y = random(-200, -100);
            this.z = random(1, 20);
            this.ySpeed = map(z, 1, 20, 0.5F, 3);
            this.yAccel = map(z, 1, 20, 0.2F, 1);
            this.weight = map(z, 1, 20, 1, 3);
            this.lenght = map(z, 1, 20, 7, 18);
        }

        private float weight, lenght;

        public void move() {
            super.move();
            if (y > height) {
                restartPhysics();
            }
        }

        public void show() {
            stroke(50, 50, 200);
            strokeWeight(weight);
            line(x, y, x, y - lenght);
        }
    }

}
