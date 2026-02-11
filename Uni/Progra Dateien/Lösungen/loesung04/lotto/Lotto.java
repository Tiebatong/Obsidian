static int[] ziehung(int n, int m) {
    // Speichere in einem Array, welche Zahlen bisher gezogen wurden.
    int[] numbersDrawn = new int[n];

    // für jede Position, die gezogen werden muss ...
    for (int position = 0; position < n; position++) {
        boolean numberTwice;
        int numberDrawn;
        // ... bestimmte eine zufällige Lottozahl, so lange wir diese Zahl nicht schon einmal gezogen haben
        do {
            // ziehe eine zufällige Zahl aus [1, m]
            numberDrawn = (int)(Math.random() * m + 1);

            // prüfe, ob diese Zahl gleich einer vorherigen Zahl ist
            numberTwice = false;
            for (int otherPosition = 0; otherPosition < position; otherPosition++) {
                if (numbersDrawn[otherPosition] == numberDrawn) {
                    numberTwice = true;
                }
            }
        } while(numberTwice);
        // speichere die gezogene Zahl im Array
        numbersDrawn[position] = numberDrawn;
    }
    
    return numbersDrawn;
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


