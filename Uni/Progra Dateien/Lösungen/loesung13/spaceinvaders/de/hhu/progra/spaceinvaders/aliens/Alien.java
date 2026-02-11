package de.hhu.progra.spaceinvaders.aliens;

import de.hhu.progra.spaceinvaders.projectiles.AlienProjectile;
import de.hhu.progra.spaceinvaders.projectiles.Projectile;
import de.hhu.progra.math.Bounded;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;
import edu.princeton.cs.draw.Draw;

public abstract class Alien implements Bounded {
    Vector position;
    
    private final static int TURN_EVERY_MOVES = 50;
    final static int CHANGE_SHAPE_EVERY_MOVES = 40;
    
    int movesSoFar = 0;
    private Vector velocity = new Vector(0.6, -0.04);
    
    public Alien(Vector position) {
        this.position = position;
    }
    
    public abstract void draw(Draw canvas);
    
    public void move() {
        movesSoFar++;
        if(movesSoFar % TURN_EVERY_MOVES == 0) {
            velocity = new Vector(velocity.x() * -1, velocity.y());
        }
        position = position.plus(velocity);
    }
    
    protected abstract double getHeight();
    
    public Projectile shoot() {
        return new AlienProjectile(position.plus(new Vector(0, -getHeight())));
    }
}
