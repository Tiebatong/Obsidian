package de.hhu.progra.spaceinvaders.projectiles;

import de.hhu.progra.spaceinvaders.aliens.Alien;
import de.hhu.progra.spaceinvaders.Player;
import de.hhu.progra.math.Bounded;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;
import edu.princeton.cs.draw.Draw;

public abstract class Projectile implements Bounded {
    private static final double WIDTH = 1;
    private static final double HEIGHT = 6;

    private Vector position;
    
    public Projectile(Vector position) {
        this.position = position;
    }
    
    public void draw(Draw canvas) {
        canvas.filledRectangle(position.x(), position.y(), WIDTH / 2, HEIGHT / 2);
    }
    
    public void move() {
        position = position.plus(getVelocity());
    }
    
    public boolean isInvisible() {
        return position.y() < 0;
    }
    
    public BoundingBox getBoundingBox() {
        return new BoundingBox(position, WIDTH, HEIGHT);
    }
    
    protected abstract Vector getVelocity();
    
    abstract boolean isKilling(Player player);
    
    abstract boolean isKilling(Alien alien);
} 
