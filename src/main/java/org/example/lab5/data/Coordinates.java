package org.example.lab5.data;

public class Coordinates {
    private double x; //Значение поля должно быть больше -952
    private long y;

    public Coordinates() {}

    public Coordinates(double x, long y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
