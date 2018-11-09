package com.codingame.game;

public class Vector {
    private int x;
    private int y;

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector(Vector v) {
        this.x = v.getX();
        this.y = v.getY();
    }

    public Vector add(Vector v) {
        this.x = this.x + v.x;
        this.y = this.y + v.y;
        return this;
    }

    public static Vector add(Vector a, Vector b) {
        return new Vector(a).add(b);
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

}
