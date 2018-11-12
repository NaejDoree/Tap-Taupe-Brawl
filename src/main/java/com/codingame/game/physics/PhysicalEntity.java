package com.codingame.game.physics;
import com.codingame.game.Vector;
import com.codingame.gameengine.module.entities.Entity;;
public class PhysicalEntity{
    private Entity graphicalEntity;
    
    private Vector position;
    private Vector nextPosition;
    private Vector nextSpeed;
    private Vector speed = new Vector();
    private Vector acceleration = new Vector();
    //TODO : add hitboxes
    private boolean stillObject = false;
    private boolean floating = false;

    public PhysicalEntity(Entity e) {
        position = new Vector(e.getX(),e.getY());
        setGraphicalEntity(e);
        PhysicsEngine.getInstance().addEntity(this);
    }

    public Entity getGraphicalEntity() {
        return graphicalEntity;
    }

    public void setGraphicalEntity(Entity graphicalEntity) {
        this.graphicalEntity = graphicalEntity;
        syncGraphicalEntity();
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
        syncGraphicalEntity();
    }

    protected void syncGraphicalEntity() {
        graphicalEntity.setX(position.getX());
        graphicalEntity.setY(position.getY());
    }

    public Vector getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(Vector nextPosition) {
        this.nextPosition = nextPosition;
    }
    void applyNextPosition() {
        setPosition(nextPosition);
    }

    public Vector getSpeed() {
        return speed;
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    public boolean isStillObject() {
        return stillObject;
    }

    public void setStillObject(boolean stillObject) {
        this.stillObject = stillObject;
    }

    public boolean isFloating() {
        return floating;
    }

    public void setFloating(boolean floating) {
        this.floating = floating;
    }

    public Vector getNextSpeed() {
        return nextSpeed;
    }

    public void setNextSpeed(Vector nextSpeed) {
        this.nextSpeed = nextSpeed;
    }
    public void applyNextSpeed() {
        this.setSpeed(nextSpeed);
    }
    
}
