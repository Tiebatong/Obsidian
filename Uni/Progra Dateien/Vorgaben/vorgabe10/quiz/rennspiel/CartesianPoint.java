final class CartesianPoint implements Point {
    private final double x;
    private final double y;
    
    CartesianPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public double getX() {
        return this.x;
    }
    
    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public Point subtract(Point otherPoint) {
        double newX = this.x - otherPoint.getX();
        double newY = this.y - otherPoint.getX();
        return new CartesianPoint(newX, newY);
    }
    
    @Override
    public String toString() {
        return x + " " + y;
    }
    
    @Override
    public double getRadius() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    @Override
    public double getTheta() {
        return Math.atan2(y, x);
    }

}
