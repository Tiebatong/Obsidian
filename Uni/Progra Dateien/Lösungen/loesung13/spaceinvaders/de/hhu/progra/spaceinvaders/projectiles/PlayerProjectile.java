package de.hhu.progra.spaceinvaders.projectiles;

import de.hhu.progra.spaceinvaders.aliens.Alien;
import de.hhu.progra.spaceinvaders.Player;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;

public class PlayerProjectile extends Projectile {
    public PlayerProjectile(Vector position) {
        super(position);
    }
    
    @Override
    protected Vector getVelocity() {
        return new Vector(0, +1.2);
    }
    
    @Override
    public boolean isKilling(Player player) {
        return false;
    }
    
    @Override
    public boolean isKilling(Alien alien) {
        return BoundingBox.collides(this, alien);
    }
}
