static int[] ziehung(int n, int m) {
    // Idee: Speichere in einem boolean-Array, welche Kugeln schon gezogen wurden.
    // Wenn z. B. an Array-Position 0 ein true steht, dann wurde die Kugel 1 schon gezogen.
    // Zur Erinnerung: Ein frisch erstelltes boolean-Array enthält überall den Wert false.
    boolean[] kugelGezogen = new boolean[m];
    
    int[] gezogeneKugeln = new int[n];
    
    // n viele Kugeln ziehen
    for(int i = 0; i < n; i++) {
        // Zufallszahl x zwischen 1 und m bestimmen
        int kugelNummer;
        do {
            kugelNummer = (int)(m * Math.random() + 1);
        } while(kugelGezogen[kugelNummer - 1]); // falls die kugelNummer schon mal gezogen wurde, eine neue zufällige Kugel wählen

        // neue Kugel speichern
        gezogeneKugeln[i] = kugelNummer;
        // speichern, dass diese Kugel bereits gezogen wurde
        kugelGezogen[kugelNummer - 1] = true;
    }
    
    return gezogeneKugeln;
}

// zum Testen (sinnvoll, aber nicht von Aufgabe verlangt)
static void main() {
    printArray(ziehung(6, 49));
}

static void printArray(int[] array) {
    for(int value: array) {
        System.out.print(value + " ");
    }
    System.out.println();
}
