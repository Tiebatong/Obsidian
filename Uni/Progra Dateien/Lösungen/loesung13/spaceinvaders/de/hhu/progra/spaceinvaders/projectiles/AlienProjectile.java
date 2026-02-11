package de.hhu.progra.spaceinvaders.projectiles;

import de.hhu.progra.spaceinvaders.aliens.Alien;
import de.hhu.progra.spaceinvaders.Player;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;

public class AlienProjectile extends Projectile {
    public AlienProjectile(Vector position) {
        super(position);
    }
    
    @Override
    protected Vector getVelocity() {
        return new Vector(0, -0.8);
    }
    
    @Override
    public boolean isKilling(Player player) {
        return BoundingBox.collides(this, player);
    }
    
    @Override
    public boolean isKilling(Alien alien) {
        return false;
    }
}
