package de.hhu.progra.math;

public record BoundingBox(double x, double y, double width, double height) {
    /**
     * Constructs a new axis-aligned bounding boxes.
     * @param position: the center of the bounding box
     * @param width: total width of the bounding box
     * @param height: total height of the bounding box
     */
    public BoundingBox(Vector position, double width, double height) {
        this(position.x(), position.y(), width, height);
    }
    
    private boolean collidesWith(BoundingBox other) {
        // collision test for two axis-aligned bounding boxes
        // see https://developer.mozilla.org/en-US/docs/Games/Techniques/3D_collision_detection#aabb_vs._aabb
        return this.x - this.width / 2 <= other.x + other.width / 2 &&
            this.x + this.width / 2 >= other.x - other.width / 2 &&
            this.y - this.height / 2 <= other.y + other.height / 2 &&
            this.y + this.height / 2 >= other.y - other.height / 2;
    }
    
    public static boolean collides(Bounded object1, Bounded object2) {
        return object1.getBoundingBox().collidesWith(object2.getBoundingBox());
    }
}
