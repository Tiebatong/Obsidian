class Racecar implements Drawable {
    private PolarPoint velocity = new PolarPoint(0, 0); // NOTE Datentyp war falsch
    private PolarPoint position;
    private Color color = Draw.BLACK;
    
    Racecar() {
        position = new PolarPoint(Math.random(), Math.PI / 2);
    }
    
    Racecar(Color color) {
        this();
        this.color = color;
    }

    void accelerate(double value) {
        if(value > 0) {
            velocity = velocity.increaseRadius(value);
        }
    }

    void decelerate(double value) {
        if(value > 0) {
            velocity = velocity.increaseRadius(-value);
        }
    }

    void turnLeft(double theta) {
        if(theta > 0) {
            velocity = velocity.increaseAngle(theta);
        }
    }

    void turnRight(double theta) {
        if(theta > 0) {
            velocity = velocity.increaseAngle(-theta);
        }
    }

    void drive(double sec) {
        position = position.add(velocity.times(sec));
    }

    @Override
    public String toString() { // NOTE Tippfehler im Methodenname
        return color + ", Velocity: " + velocity + ", Position: " + position;
    }

    @Override
    public void draw(Draw canvas) { // NOTE Sichtbarkeit war falsch (Methoden aus Interfaces sind immer öffentlich)
        canvas.setPenColor(color);
        PolarPoint firstWheel = position;
        PolarPoint secondWheel = position.add(velocity.normalized().times(0.03));
        canvas.circle(Math.abs(firstWheel.getX() % 1), Math.abs(firstWheel.getY() % 1), 0.02);
        if(velocity.getRadius() != 0) {
            canvas.circle(Math.abs(secondWheel.getX() % 1), Math.abs(secondWheel.getY() % 1), 0.02);
        }
    }

}

