package com.codingame.game.physics;

import java.util.ArrayList;

import com.codingame.game.Vector;

public class PhysicsEngine {
    private static PhysicsEngine singleton = null;
    private ArrayList<PhysicalEntity> entities;
    private Vector gravity = new Vector(0,1);
    
    private PhysicsEngine() {
        this.entities = new ArrayList<>();
    }
    
    public static PhysicsEngine getInstance() {
        if (singleton == null) {
            singleton = new PhysicsEngine();
        }
        return singleton;
    }
    void addEntity(PhysicalEntity e) {
        entities.add(e);
    }
    
    private void computeNextStep() {
        for (PhysicalEntity e : entities) {
            Vector pos = e.getPosition();
            Vector speed = e.getSpeed();
            Vector acc = e.getAcceleration();
            if (!e.isFloating()) {
                acc.add(gravity);
            }
            e.setNextPosition(Vector.add(pos, speed));
            e.setNextSpeed(Vector.add(speed, acc));
        }
    }
    private void computeCollisions() { //TODO: implementation
        //TODO : get collisions info
        //TODO : apply collisions effects
        // they must be separated to avoid asymmetry
    }
    private void applyNextStep() {
        for (PhysicalEntity e : entities) {
            e.applyNextPosition();
            e.applyNextSpeed();
        }
    }
    public void update() {
        computeNextStep();
        computeCollisions();
        applyNextStep();
    }

    public Vector getGravity() {
        return gravity;
    }

    public void setGravity(Vector gravity) {
        this.gravity = gravity;
    }
}
