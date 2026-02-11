package de.hhu.progra.spaceinvaders.projectiles;

import de.hhu.progra.spaceinvaders.Player;
import de.hhu.progra.spaceinvaders.aliens.Alien;
import java.util.List;
import java.util.LinkedList;
import edu.princeton.cs.draw.Draw;

public class ProjectileList {
    private List<Projectile> projectiles = new LinkedList<>();

    public void moveAll() {
        projectiles.forEach(Projectile::move);
    }

    void drawAll(Draw canvas) {
        projectiles.forEach(projectile -> projectile.draw(canvas));
    }
    
    public void add(Projectile projectile) {
        if(projectile != null) {
            projectiles.add(projectile);
        }
    }
    
    boolean anyIsKilling(Player player) {
        return projectiles.stream().anyMatch(projectile -> projectile.isKilling(player));
    }
    
    public boolean anyIsKilling(Alien alien) {
        return projectiles.stream().anyMatch(projectile -> projectile.isKilling(alien));
    }
    
    public void removeWhichIsKilling(Alien alien) {
        for(int i = 0; i < projectiles.size(); i++) {
            if(projectiles.get(i).isKilling(alien)) {
                projectiles.remove(i);
                i--;
            }
        }
    }
}
