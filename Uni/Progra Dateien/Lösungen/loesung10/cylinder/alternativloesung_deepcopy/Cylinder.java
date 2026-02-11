record Cylinder(double radius, double height) {
    double volume() {
        return Math.pow(radius, 2) * height * Math.PI;
    }
    
    static Cylinder[] sorted(Cylinder[] cylinders) {
        // Kopiere Zylinder in neues Array. Das neue Array wird sortiert, das alte bleibt unverändert.
        // Im Gegensatz zum anderen Lösungsvorschlag werden hier nicht nur die Referenzen kopiert, sondern auch Kopien
        // der Cylnder-Objekte im Heap erstellt (sog. Deep Copy). Wenn die Cylinder-Objekte sowieso unveränderlich
        // (alle Eigenschaften final) deklariert sind, hat die Deep Copy keinen Vorteil (und den Nachteil, dass mehr
        // Speicherplatz gebraucht wird).
        Cylinder[] sortedCylinders = new Cylinder[cylinders.length]; // Die geforderte NullPointerException würde hier automatisch geworfen werden.
        for(int i = 0; i < cylinders.length; i++) {
            // Hinweis: Der direkte Zugriff auf die privaten Variablen radius und height ist hier möglich, da wir
            // innerhalb des Records Cylinder sind.
            sortedCylinders[i] = new Cylinder(cylinders[i].radius, cylinders[i].height); // Die geforderte NullPointerException würde hier automatisch geworfen werden.
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

