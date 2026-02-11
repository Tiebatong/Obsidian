static int[] ziehung(int n, int m) {
    // Idee: Erstelle zunächst ein Array mit allen möglichen Lottokugeln von 1 bis m.
    // Ordne dann die Zahlen im Array durch m Vertauschungen (mehr oder weniger) zufällig an und gib dann die ersten n Zahlen zurück.
    int[] lottokugeln = new int[m];
    for (int kugelnummer = 1; kugelnummer <= m; kugelnummer++) {
        lottokugeln[kugelnummer - 1] = kugelnummer;
    }
    for (int vertauschung = 1; vertauschung <= m; vertauschung++) {
        // Vertausche die Kugel an Position "vertauschung" und "zufallsposition":
        int zufallsposition = (int) (Math.random() * m);
        int kugel = lottokugeln[vertauschung - 1];
        lottokugeln[vertauschung - 1] = lottokugeln[zufallsposition];
        lottokugeln[zufallsposition] = kugel;
    }

    // die ersten n Zahlen zurückgeben
    int[] ergebnis = new int[n];
    for (int і = 0; і < n; і++) {
        ergebnis[і] = lottokugeln[і];
    }
    
    return ergebnis;
}

// zum Testen (sinnvoll, aber nicht von Aufgabe verlangt)
static void main() {
    int[] gezogeneZahlen = ziehung(6, 49);
    printArray(gezogeneZahlen);
}

static void printArray(int[] array) {
    for(int value: array) {
        System.out.print(value + " ");
    }
    System.out.println();
}
