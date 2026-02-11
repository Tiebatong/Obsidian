package de.hhu.progra.spaceinvaders.aliens;

import de.hhu.progra.math.Bounded;
import de.hhu.progra.math.BoundingBox;
import de.hhu.progra.math.Vector;
import edu.princeton.cs.draw.Draw;

public class NormalAlien extends Alien {
    private final static double THICKNESS = 1.0;
    private final static double WIDTH = 8 * THICKNESS;
    private final static double HEIGHT = 7 * THICKNESS;
    
    public NormalAlien(Vector position) {
        super(position);
    }
    
    @Override
    public void draw(Draw canvas) {
        // horizontals body
        canvas.filledRectangle(position.x(), position.y(), WIDTH / 2, THICKNESS / 2);
        canvas.filledRectangle(position.x(), position.y() + THICKNESS * 3, WIDTH / 2, THICKNESS / 2);
        // verticals body
        canvas.filledRectangle(position.x() - WIDTH / 2 + THICKNESS / 2, position.y() + 1.5, THICKNESS / 2, 2 * THICKNESS);
        canvas.filledRectangle(position.x() + WIDTH / 2 - THICKNESS / 2, position.y() + 1.5, THICKNESS / 2, 2 * THICKNESS);
        // nose/mouth
        canvas.filledRectangle(position.x(), position.y() + THICKNESS / 2, THICKNESS, 2.5 * THICKNESS);
        if(movesSoFar % (2 * CHANGE_SHAPE_EVERY_MOVES) > CHANGE_SHAPE_EVERY_MOVES) {
            // left arm
            canvas.filledRectangle(position.x() - WIDTH / 2 + THICKNESS / 2, position.y() - 2.5 * THICKNESS, THICKNESS / 2, THICKNESS);
            canvas.filledRectangle(position.x() - WIDTH / 2 + 1.5 * THICKNESS, position.y() - 1.5 * THICKNESS, THICKNESS / 2, THICKNESS);
            // right arm
            canvas.filledRectangle(position.x() + WIDTH / 2 - THICKNESS / 2, position.y() - 2.5 * THICKNESS, THICKNESS / 2, THICKNESS);
            canvas.filledRectangle(position.x() + WIDTH / 2 - 1.5 * THICKNESS, position.y() - 1.5 * THICKNESS, THICKNESS / 2, THICKNESS);
        } else {
            // left arm
            canvas.filledRectangle(position.x() - WIDTH / 2 + 1.5 * THICKNESS, position.y() - 2.5 * THICKNESS, THICKNESS / 2, THICKNESS);
            canvas.filledRectangle(position.x() - WIDTH / 2 + THICKNESS / 2, position.y() - 1.5 * THICKNESS, THICKNESS / 2, THICKNESS);
            // right arm
            canvas.filledRectangle(position.x() + WIDTH / 2 - 1.5 * THICKNESS, position.y() - 2.5 * THICKNESS, THICKNESS / 2, THICKNESS);
            canvas.filledRectangle(position.x() + WIDTH / 2 - THICKNESS / 2, position.y() - 1.5 * THICKNESS, THICKNESS / 2, THICKNESS);
        }
    }
    
    @Override
    protected double getHeight() {
        return HEIGHT;
    }
    
    @Override
    public BoundingBox getBoundingBox() {
        return new BoundingBox(position, WIDTH, HEIGHT);
    }
}
