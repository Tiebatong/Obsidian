record Cylinder(double radius, double height) {
    double volume() {
        return Math.pow(radius, 2) * height * Math.PI;
    }
    
    static Cylinder[] sorted(Cylinder[] cylinders) {
        java.util.Objects.requireNonNull(cylinders);
        // Kopiere Zylinder in neues Array. Das neue Array wird sortiert, das alte bleibt unverändert.
        Cylinder[] sortedCylinders = new Cylinder[cylinders.length];
        for(int i = 0; i < cylinders.length; i++) {
            sortedCylinders[i] = java.util.Objects.requireNonNull(cylinders[i]);
        }

        // Insertion Sort, basierend auf den Vorlesungsfolien
        for(int currentIndex = 1; currentIndex < sortedCylinders.length; currentIndex++) {
            Cylinder currentCylinder = sortedCylinders[currentIndex];
            int newPosition = currentIndex;
            while(newPosition > 0 && sortedCylinders[newPosition - 1].volume() > currentCylinder.volume()) {
                sortedCylinders[newPosition] = sortedCylinders[newPosition - 1];
                newPosition--;
            }
            sortedCylinders[newPosition] = currentCylinder;
        }

        return sortedCylinders;
    }
}

