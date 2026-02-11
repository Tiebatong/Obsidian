static void main() {
    // Eingabewerte
    int untereGrenze = 10;
    int obereGrenze = 16;

    // 1. Erzeuge eine Zufallszahl zwischen 0 (einschließlich) und 1 (ausschließlich) mit Math.random(),
    //    also aus dem Intervall [0, 1).
    // 2. Multipliziere die erzeugte Zahl mit (obereGrenze - untereGrenze + 1) um den Wertebereich zu "strecken".
    //    Bsp.: untereGrenze = 2, obereGrenze = 5, Intervallbreite 5-2+1 = 4 --> Die erzeugte Zahl liegt im Interval [0, 4)
    // 3. Addiere die untere Grenze (untereGrenze) auf die erzeugte Zahl.
    //    Für das obige Beispiel ist der Wertebereich dann [2, 6).
    // 4. Caste das Ergebnis in einen Integer.
    //    Im Beispiel erhalten wir dann durch das Abschneiden der Nachkommastellen Zahlen aus [2, 5]
    int aufgenzahl = (int) (Math.random() * (obereGrenze - untereGrenze + 1) + untereGrenze⁢);

    // Gebe die erzeugte Zahl auf der Konsole aus
    System.out.println(aufgenzahl);
}
