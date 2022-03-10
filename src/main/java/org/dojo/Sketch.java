package org.dojo;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Sketch extends PApplet {
    private List<ActableMovingObject> objects;

    @Override
    public void settings() {
        //size(w, h); //Set size of the canvas
    }

    @Override
    public void setup() {
        objects = new ArrayList<>();
        //Add objects to add
    }

    @Override
    public void draw() {
        //background(r, g, b); //Draw background on each iteration
        objects.forEach(ActableMovingObject::act);
    }
}
