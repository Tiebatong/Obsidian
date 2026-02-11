record Cylinder(double radius, double height) implements Comparable<Cylinder> {
    double volume() {
        return Math.pow(radius, 2) * height * Math.PI;
    }
    
    static Cylinder[] sorted(Cylinder[] cylinders) {
        Cylinder[] sortedCylinders = new Cylinder[cylinders.length];
        for(int i = 0; i < cylinders.length; i++) {
            sortedCylinders[i] = new Cylinder(cylinders[i].radius, cylinders[i].height);
        }

        // Insertion Sort aus der Vorlesung aufrufen
        SortObjects.sort(sortedCylinders);

        return sortedCylinders;
    }

    @Override
    public int compareTo(Cylinder other) {
        return Double.compare(this.volume(), other.volume());
    }
}

