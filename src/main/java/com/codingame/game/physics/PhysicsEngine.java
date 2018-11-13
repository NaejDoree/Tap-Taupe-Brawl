package com.codingame.game.physics;

import java.util.ArrayList;
import java.util.HashSet;

import com.codingame.game.Vector;

public class PhysicsEngine {
    private static PhysicsEngine singleton = null;
    private ArrayList<PhysicalEntity> entities;
    //TODO : add the collision layer system
    private ArrayList<HitBox> hitboxes;
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
    
    void addHitBox(HitBox e) {
        hitboxes.add(e);
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
    private void computeCollisions() {
        //TODO : layers handling
        HashSet<Collision> collisions = new HashSet<>();
        for (HitBox b : hitboxes) {
            for (HitBox other : hitboxes) {
                if (b!=other) {
                    if (HitBox.isColliding(b, other)) {
                        collisions.add(new Collision(b,other));
                    }
                }
            }
        }
        //TODO : apply collisions effects
        for (Collision c: collisions) {
            if (!c.a.isTrigger() && !c.b.isTrigger()) {
              //apply physical collisions
            }
            //call both handlers
        }
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
