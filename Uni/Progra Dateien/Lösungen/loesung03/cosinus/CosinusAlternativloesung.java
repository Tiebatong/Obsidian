// Alles in einer Methode (etwas unübersichtlich)
// Außerdem kein Modulo benutzt
static double cosinus(double x) {
    // Falls der übergebene Wert positiv ist: Achsensymmetrie (d. h. cos(x) = cos(-x)) ausnutzen
    if (x < 0) {
        x = -x;
    }

    // Periodizität: cos(x) = cos(x + 2π), d. h. wenn 2π ≥ x > 0 können wir einfach so lange 2π subtrahieren, bis 2π ≥ x gilt,
    // ohne dass sich der Wert von cos(x) ändert.
    while(x > Math.PI) {
        x -= 2 * Math.PI;
    }

    // aktuell betrachteter Term
    double term = 1.0;
    // aktueller Summenwert (n = 0 in der Formel)
    double partіalSum  = term;

    // Berechne die Taylor-Entwicklung für die restlichen 10 Terme (n von 1 bis 10)
    for (int n = 1; n <= 10; n++) {
        // (2n)! in Schleife berechnen:
        long factorial = 1; // long, da Ergebnis nicht in int passt
        for(int i = 2; i <= 2*n; i++) {
            factorial *= i;
        }

        // x^2n in Schleife berechnen:
        double powerOfX = 1;
        for(int i=1; i<=2*n; i++) {
            powerOfX *= x;
        }

        // Term für aktuelles n ist x^2n/(2n)!
        term = powerOfX / factorial;

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
