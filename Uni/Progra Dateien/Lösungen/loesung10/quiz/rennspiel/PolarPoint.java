final class PolarPoint implements Point {
    private final double radius;
    private final double theta;
    
    PolarPoint(double radius, double theta) {
        this.radius = radius;
        this.theta = theta;
    }
    
    @Override
    public double getX() {
        return radius * Math.cos(theta);
    }
    
    @Override
    public double getY() {
        return radius * Math.sin(theta);
    }

    @Override
    public PolarPoint subtract(Point otherPoint) { // NOTE Datentyp des Parameters war falsch
        double newX = this.getX() - otherPoint.getX();
        double newY = this.getY() - otherPoint.getY();
        CartesianPoint newPoint = new CartesianPoint(newX, newY);
        return new PolarPoint(newPoint.getRadius(), newPoint.getTheta());
    }

    // NOTE add ist keine Methode eines Obertyps, also kein @Override
    PolarPoint add(Point otherPoint) {
        double newX = this.getX() + otherPoint.getX();
        double newY = this.getY() + otherPoint.getY();
        CartesianPoint newPoint = new CartesianPoint(newX, newY);
        return new PolarPoint(newPoint.getRadius(), newPoint.getTheta());
    }
    
    PolarPoint increaseRadius(double length) {
        return new PolarPoint(radius + length, theta);
    }
    
    PolarPoint times(double length) {
        return new PolarPoint(radius * length, theta);
    }
    
    PolarPoint normalized() {
        return this.times(1 / this.radius);
    }
    
    PolarPoint increaseAngle(double deltaTheta) {
        return new PolarPoint(radius, theta + deltaTheta);
    }
    
    @Override
    public String toString() {
        return getX() + " " + getY();
    }
    
    @Override
    public double getRadius() {
        return radius;
    }
    
    @Override
    public double getTheta() {
        return theta;
    }

}
