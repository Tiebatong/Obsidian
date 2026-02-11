package de.hhu.progra.spaceinvaders.aliens;

import de.hhu.progra.spaceinvaders.projectiles.Projectile;
import de.hhu.progra.spaceinvaders.projectiles.ProjectileList;
import java.util.List;
import java.util.LinkedList;
import java.util.Optional;
import edu.princeton.cs.draw.Draw;

public class AlienList {
    private List<Alien> aliens = new LinkedList<>();
    
    public void moveAll() {
        aliens.forEach(Alien::move);
    }

    public void drawAll(Draw canvas) {
        aliens.forEach(alien -> alien.draw(canvas));
    }
    
    public void add(Alien alien) {
        aliens.add(alien);
    }
    
    // Optional funktioniert analag zu MaybeInt, das wir auf einem Übungsblatt hatten
    public Optional<Projectile> randomAlienShot(double shotProbability) {
        if(Math.random() < shotProbability && aliens.size() > 0) { // BUGFIX: Größenprüfung hat gefehlt
            int alienIndex = (int)(Math.random() * aliens.size());
            return Optional.of(aliens.get(alienIndex).shoot());
        }
        return Optional.empty();
    }
    
    public void removeHitAliens(ProjectileList projectiles) {
        // Note: You may not remove an object from a collection from within a foreach loop while iterating over that collection, so we use an indexed loop instead.
        for(int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            if(projectiles.anyIsKilling(alien)) {
                aliens.remove(alien);
                i--;
                projectiles.removeWhichIsKilling(alien);
            }
        }
    }
}
