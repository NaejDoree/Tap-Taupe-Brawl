package com.codingame.game.physics;

import com.codingame.game.Vector;

public class HitBox {
    private Vector anchor;
    private Vector dimensions;
    private boolean trigger = false;
    //TODO : add collider tag
    //TODO : add collision layer
    //TODO : add parent reference and interface (CollisionHandler interface)

    public HitBox(Vector anchor,Vector dimensions){
        this.anchor = anchor;
        this.dimensions = dimensions;
    }

    public boolean isPointInBox(Vector point){
        return point.getX()>=anchor.getX() &&
                point.getX()<=(anchor.getX()+dimensions.getX()) &&
                point.getY()>=anchor.getY() &&
                point.getY()<=(anchor.getY()+dimensions.getX());
    }
    public boolean isInBox(HitBox other){
        return other.isPointInBox(anchor) ||
                other.isPointInBox(Vector.add(anchor,dimensions)) ||
                other.isPointInBox(Vector.add(anchor,new Vector(0,dimensions.getY()))) ||
                other.isPointInBox(Vector.add(anchor,new Vector(dimensions.getX(),0)));
    }

    public static boolean isColliding(HitBox a,HitBox b){
        return a.isInBox(b) || b.isInBox(a);
    }

    public Vector getDimensions() {
        return dimensions;
    }

    public void setDimensions(Vector dimensions) {
        this.dimensions = dimensions;
    }
    public Vector getAnchor() {
        return anchor;
    }

    public void setAnchor(Vector anchor) {
        this.anchor = anchor;
    }

    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }
}
