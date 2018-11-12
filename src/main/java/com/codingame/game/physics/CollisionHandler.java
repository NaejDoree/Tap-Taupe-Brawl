package com.codingame.game.physics;

public interface CollisionHandler {
    void handleCollision(HitBox yourCollider, HitBox otherCollider);
}
