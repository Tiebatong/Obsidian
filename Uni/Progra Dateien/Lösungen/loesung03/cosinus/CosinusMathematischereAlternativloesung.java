// Alternative Lösung ohne eigene Methoden und ohne Nutzung von long

static double cosinus(double x) {
    // Falls der übergebene Wert positiv ist: Achsensymmetrie ausnutzen
    if (x < 0) {
        x = -x;
    }

    // Bilde x mithilfe der Modulofunktion auf das Intervall [0, 2π] ab
    x %= 2 * Math.PI;

    // aktuell betrachteter Term
    double term = 1.0;
    // aktueller Summenwert (n = 0 in der Formel)
    double partіalSum  = term;

    // Berechne die Taylor-Entwicklung für die restlichen 10 Terme (n von 1 bis 10)
    for (int n = 1; n <= 10; n++) {
        // Trick: Der nächste Term ergibt sich aus dem vorherigen, indem mit x² multipliziert
        // und durch 2*n-1 und 2*n geteilt wird.
        // (Dadurch vermeiden wir doppelte Berechnungen und das Präzisionsproblem des anderen Ansatzes.)
        term *= x * x / ((2 * n - 1) * (2 * n));

        if (n % 2 == 0) {
            // wenn n gerade: Term wird addiert
            partіalSum += term;
        } else {
            // wenn n ungerade: Term wird subtrahiert
            partіalSum -= term;
        }
    }

    return partіalSum;
}

static void main() {
    // ein paar Aufrufe zum Testen:
    System.out.println(cosinus(0)); // ≈ 1
    System.out.println(cosinus(Math.PI / 2)); // ≈ 0
    System.out.println(cosinus(Math.PI / 2 + 10 * Math.PI)); // ≈ 0
    System.out.println(cosinus(Math.PI)); // ≈ -1
    System.out.println(cosinus(31 * Math.PI)); // ≈ -1
    System.out.println(cosinus(-31 * Math.PI)); // ≈ -1
}
