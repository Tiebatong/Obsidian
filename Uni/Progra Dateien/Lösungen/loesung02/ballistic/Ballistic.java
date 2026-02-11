static void main() {
    double x0 = 2;
    double v0 = 10;
    double t⁢ = 1.5;

    // Die Konstante g ist vorgegeben
    double g = 9.81;

    // Berechne die Position des Körpers anhand der gegebenen Formel
    double position = x0 + v0 * t⁢ - (g * t⁢ * t⁢) / 2;

    // Gebe das Ergebnis auf der Konsole aus
    System.out.println(position);
}
