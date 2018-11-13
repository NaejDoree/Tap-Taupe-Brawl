package com.codingame.game.physics;

import com.codingame.game.Vector;

public class HitBox {
    private Vector dimensions;
    private boolean trigger = false;
    private CollisionHandler handler;
    //TODO : add collider tag
    //TODO : add collision layer

    public HitBox(CollisionHandler handler,Vector dimensions){
        this.handler = handler;
        this.dimensions = dimensions;
    }

    public boolean isPointInBox(Vector point){
        return point.getX()>=getAnchor().getX() &&
                point.getX()<=(getAnchor().getX()+dimensions.getX()) &&
                point.getY()>=getAnchor().getY() &&
                point.getY()<=(getAnchor().getY()+dimensions.getX());
    }
    public boolean isInBox(HitBox other){
        return other.isPointInBox(getAnchor()) ||
                other.isPointInBox(Vector.add(getAnchor(),dimensions)) ||
                other.isPointInBox(Vector.add(getAnchor(),new Vector(0,dimensions.getY()))) ||
                other.isPointInBox(Vector.add(getAnchor(),new Vector(dimensions.getX(),0)));
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
        return handler.getAnchorPoint(this);
    }

    public boolean isTrigger() {
        return trigger;
    }

    public void setTrigger(boolean trigger) {
        this.trigger = trigger;
    }
}
