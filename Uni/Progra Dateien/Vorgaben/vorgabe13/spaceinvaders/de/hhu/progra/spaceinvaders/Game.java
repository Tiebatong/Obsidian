package de.hhu.progra.spaceinvaders;

import de.hhu.progra.spaceinvaders.aliens.AlienList;
import de.hhu.progra.spaceinvaders.aliens.NormalAlien;
import de.hhu.progra.spaceinvaders.projectiles.Projectile;
import de.hhu.progra.spaceinvaders.projectiles.ProjectileList;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;
import edu.princeton.cs.draw.Draw;

class Game implements KeyboardListener {
    private final static int FPS = 25;
    private final static double ALIEN_SHOT_PROBABILITY = 0.5 / FPS;
    private final static double CANVAS_HEIGHT = 100;
    private final static double CANVAS_WIDTH = CANVAS_HEIGHT;
    
    private final Player player;
    private final ProjectileList projectiles = new ProjectileList();
    private final AlienList aliens = new AlienList();
    private final Draw canvas = new Draw();

    static void main() {
        new Game();
    }

    Game() {
        addAliens();

        player = new Player(new Vector(CANVAS_WIDTH / 2, .05 * CANVAS_HEIGHT));
        
        canvas.addKeyboardListener(this);
        canvas.setXscale(0, CANVAS_WIDTH);
        canvas.setYscale(0, CANVAS_HEIGHT);
        
        gameloop();
    }
    
    private void addAliens() {
        for(int column = 0; column <= 8; column++) {
            aliens.add(new AngryAlien(new Vector(10 * column, CANVAS_HEIGHT)));
            aliens.add(new NormalAlien(new Vector(10 * column, CANVAS_HEIGHT * 0.9)));
        }
    }
    
    private void gameloop() {
        canvas.enableDoubleBuffering();
        while(!isGameOver()) {
            canvas.clear();
            
            player.draw(canvas);
            
            aliens.moveAll();
            aliens.drawAll(canvas);
            aliens.removeHitAliens(projectiles);
            aliens.randomAlienShot(ALIEN_SHOT_PROBABILITY).ifPresent(projectile -> projectiles.add(projectile));
            
            projectiles.moveAll();
            projectiles.drawAll(canvas);
            
            canvas.show();
            canvas.pause((int)(1000. / FPS));
        }
        
        canvas.text(50, 50, "GAME OVER");
        canvas.show();
        canvas.pause(100);
    }
    
    private boolean isGameOver() {
        return projectiles.anyIsKilling(player);
    }
    
    public void keyTyped(char c) {
        if(c == ' ' || c == 's') {
            projectiles.add(player.shoot());
        } else if(c == 'a') {
            player.moveLeft();
        } else if(c == 'd') {
            player.moveRight();
        }
    }
} 
