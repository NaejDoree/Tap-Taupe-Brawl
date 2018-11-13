package com.codingame.game.physics;

import com.codingame.game.Vector;

public interface CollisionHandler {
    Vector getAnchorPoint(HitBox collider);
    void handleCollision(HitBox yourCollider, HitBox otherCollider);
}
