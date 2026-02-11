static void main(String[] args) {
    // Überprüfe die Anzahl der Argumente
    if(args.length < 1) {
        System.out.println("ERROR:⁢ Bitte mindestens eine Zahl als Argument übergeben!");
        return; // Guard-Muster: Erst Fehlerfälle abfangen und Methode frühzeitig beenden.
                // Alternativ kann man auch mit else arbeiten, das führt bei mehreren Fehlerabfragen aber zu tief
                // geschachteltem Code, der schwieriger verständlich ist.
    }

    // Idee: Speichere das erste Argument als potentielles Minimum und Maximum ab.
    // Gehe dann einmal über alle Argumente:
    // Ist eine Zahl größer als das bisher gesehene Maximum, ersetze das Maximum durch diese größere Zahl.
    // Ist eine Zahl kleiner als das bisher gesehene Minimum, ersetze das Minimum durch diese kleinere Zahl.
    
    // Erzeuge Variablen zum Speichern des Minimums und Maximums, initalisiert mit dem ersten Argument
    int min = Integer.parseInt(args[0]);
    int max = min;

    // Laufe in einer Schleife über alle Argumente
    for(String arg: args) {
        // Interpretiere den String arg als int
        int number = Integer.parseInt(arg);

        // Überprüfe ob 'number' größer als das aktuell gespeicherte Maximum ist
        if(number > max) {
            // Ersetze die bisher gesehene größte Zahl durch die größere Zahl 'number'
            max = number;
        }

        // Überprüfe ob 'number' kleiner als das aktuell gespeicherte Minimum ist
        if (number < min) {
            // Ersetze die bisher gesehene kleinste Zahl durch die kleinere Zahl 'number'
            min = number;
        }
    }

    // Ergebnisse ausgeben
    System.out.println(min);
    System.out.println(max);
}
