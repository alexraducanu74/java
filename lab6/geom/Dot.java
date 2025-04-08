package org.example.geom;

import java.awt.*;
import java.io.Serializable;

public class Dot implements Serializable {
    public int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point toPoint() {
        return new Point(x, y);
    }

    public boolean contains(Point p, int radius) {
        return p.distance(x, y) <= radius;
    }
    public double distanceTo(Dot other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}
