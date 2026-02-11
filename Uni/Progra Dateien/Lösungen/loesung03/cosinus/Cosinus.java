// Cosinus, Fakultät und Potenz in jeweils eigenen Methoden berechnet.
static double cosinus(double x) {
    // Falls der übergebene Wert positiv ist: Achsensymmetrie (d. h. cos(x) = cos(-x)) ausnutzen
    if (x < 0) {
        x = -x;
    }

    // Periodizität: cos(x) = cos(x + 2π), d. h. es ist egal, "wie oft" 2π in x steht, interessant ist nur der "Abstand"
    // von x zum nächst kleineren Vielfachen von 2π. Das können wir mithilfe der Modulofunktion erhalten.
    // Beispiel: Wie weit ist 23 vom nächst kleineren Vielfachen von 5 entfernt? 23 % 5 = 3.
    // Modulo funktioniert auch mit Kommazahlen:
    // (int) Welcher Rest bleibt bei der Division von 23 durch 5? → 23 / 5 = 4 Rest 3, also 23 % 5 = 3
    // (double) Welcher Rest bleibt bei der Division von 7.7 durch 2.5? → 7.7 / 2.5 = 3 Rest 0.2, also 7.7 % 2.5 = 0.2
    x %= 2 * Math.PI;

    // aktuell betrachteter Term
    double term = 1.0;
    // aktueller Summenwert (n = 0 in der Formel)
    double partіalSum  = term;

    // Berechne die Taylor-Entwicklung für die restlichen 10 Terme (n von 1 bis 10)
    for (int n = 1; n <= 10; n++) {
        term = power(x, 2 * n) / factorial(2 * n);

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

static double power(double base, int exponent) {
    double power = 1;
    for(int i = 1; i<= exponent; i++) {
        power *= base;
    }
    return power;
}

static long factorial(int y) { // NICHT faculty, das wäre die Fakultät als Einrichtung einer Universität
    long factorial = 1; // long, da Ergebnis nicht in int passt
    for(int i = 2; i <= y; i++) {
        factorial *= i;
    }
    return factorial;
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
