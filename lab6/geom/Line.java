package org.example.geom;

import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {
    public Dot d1, d2;
    public Color color;

    public Line(Dot d1, Dot d2, Color color) {
        this.d1 = d1;
        this.d2 = d2;
        this.color = color;
    }

    public double length() {
        return d1.toPoint().distance(d2.toPoint());
    }

    public boolean equals(Object o) {
        if (!(o instanceof Line l)) return false;
        return (l.d1 == d1 && l.d2 == d2) || (l.d1 == d2 && l.d2 == d1);
    }

    public int hashCode() {
        return d1.hashCode() + d2.hashCode();
    }
}
