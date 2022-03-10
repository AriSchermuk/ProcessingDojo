package org.dojo;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Sketch extends PApplet {
    private List<Drop> drops;

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        drops = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            drops.add(new Drop(this));
        }
    }

    @Override
    public void draw() {
        background(20,20,70);
        drops.forEach(getDropConsumer());
    }

    private Consumer<Drop> getDropConsumer() {
        return d -> {
            d.move();
            d.show();
        };
    }
}
