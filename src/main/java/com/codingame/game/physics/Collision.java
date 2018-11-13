package com.codingame.game.physics;

class Collision {
    HitBox a;
    HitBox b;

    Collision(HitBox a, HitBox b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Collision)) {
            return false;
        } else {
            Collision o = (Collision) other;
            if ((this.a.equals(o.a) && this.b.equals(o.b)) ||
                (this.b.equals(o.a) && this.a.equals(o.b))) {
                return true;
            } else {
                return false;
            }
        }

    }

}
