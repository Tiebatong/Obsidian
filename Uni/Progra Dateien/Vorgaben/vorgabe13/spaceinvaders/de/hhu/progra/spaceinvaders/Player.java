package de.hhu.progra.spaceinvaders;

import de.hhu.progra.math.Bounded;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;
import de.hhu.progra.spaceinvaders.projectiles.Projectile;
import de.hhu.progra.spaceinvaders.projectiles.PlayerProjectile;
import edu.princeton.cs.draw.Draw;

public class Player implements Bounded {

    private final static int WIDTH = 10;
    private final static int HEIGHT = 6;
    
    private final static double SECONDS_BETWEEN_SHOTS = 0.5;
    
    private Vector position;
    private long timeOfLastShot = 0;
    
    public Player(Vector initialPosition) {
        this.position = initialPosition;
    }
    
    public void draw(Draw canvas) {
        canvas.filledRectangle(position.x(), position.y() - HEIGHT / 4, WIDTH / 2, HEIGHT / 4);
        canvas.filledRectangle(position.x(), position.y() + HEIGHT / 4, WIDTH / 4, HEIGHT / 4);
    }
    
    public BoundingBox getBoundingBox() {
        return new BoundingBox(position, WIDTH, HEIGHT);
    }
    
    public Projectile shoot() {
        if(System.currentTimeMillis() - timeOfLastShot > 1000 * SECONDS_BETWEEN_SHOTS) {
            timeOfLastShot = System.currentTimeMillis();
            return new PlayerProjectile(position.plus(new Vector(0, HEIGHT)));
        }
        return null;
    }
    
    public void moveLeft() {
        this.position = position.plus(new Vector(-0.5, 0));
    }
    
    public void moveRight() {
        this.position = position.plus(new Vector(0.5, 0));
    }
}
