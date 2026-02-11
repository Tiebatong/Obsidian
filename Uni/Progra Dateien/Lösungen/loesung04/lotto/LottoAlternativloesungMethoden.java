static int[] ziehung(int n, int m) {
    // Speichere in einem Array, welche Zahlen bisher gezogen wurden.
    int[] numbersDrawn = new int[n]; // zur Erinnerung: zu Beginn alle Werte = 0

    // für jede Position, die gezogen werden muss ...
    for (int position = 0; position < n; position++) {
        boolean numberTwice;
        int numberDrawn;
        // ... bestimmte eine zufällige Lottozahl, so lange wir diese Zahl nicht schon einmal gezogen haben
        do {
            // ziehe eine zufällige Zahl aus [1, m]
            numberDrawn = randomInt(1, m);
        } while(contains(numbersDrawn, numberDrawn));
        // speichere die gezogene Zahl im Array
        numbersDrawn[position] = numberDrawn;
    }
    
    return numbersDrawn;
}

/**
 * bestimmt eine Zufallszahl aus dem Intervall [min, max]
 */
static int randomInt(int min, int max) {
    return (int)(Math.random() * (max - min + 1) + min);
}

/**
 * gibt true zurück genau dann wenn nadel in array enthalten ist
 */
static boolean contains(int[] array, int needle) {
    for (int value: array) {
        if (value == needle) {
            return true;
        }
    }
    return false;
}
    
// zum Testen (sinnvoll, aber nicht von Aufgabe verlangt)
static void main() {
    int n = 6;
    int m = 49;

    int[] gezogeneZahlen = ziehung(n, m);

    printArray(gezogeneZahlen);
}

static void printArray(int[] array) {
    for(int value: array) {
        System.out.print(value + " ");
    }
    System.out.println();
}


