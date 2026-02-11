package de.hhu.progra.math; // BUGFIX: package-Statement hat gefehlt

public record Vector(double x, double y) {
    public Vector plus(Vector otherVector) {
        double newX = this.x + otherVector.x();
        double newY = this.y + otherVector.y();
        return new Vector(newX, newY);
    }

    public Vector minus(Vector otherVector) {
        double newX = this.x - otherVector.x();
        double newY = this.y - otherVector.y();
        return new Vector(newX, newY);
    }
    
    public double magnitude() {
        return Math.hypot(x, y);
    }

    public Vector times(double factor) {
        double newX = this.x * factor;
        double newY = this.y * factor;
        return new Vector(newX, newY);
    }
}
