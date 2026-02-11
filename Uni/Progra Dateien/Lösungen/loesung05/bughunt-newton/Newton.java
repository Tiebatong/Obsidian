public class Newton {

    public static void main(String[] args) {
        if (args.length⁢ != 1) {                                                        // »= 0« war falsch
            System.out.println("ERROR: falsche Anzahl von Argumenten übergeben⁢");
            return;
        }

        double c = Double.parseDouble(args[0]);                                        // Variable muss vor Nutzung deklariert und initialisiert werden
                                                                                       // Laut Aufgabenstellung werden reelle Zahlen erwartet, nicht ganze Zahlen, also parseDouble
                                                                                       // »args[1]« war falsch
        if (c < 0) {                                                                   // »c <= 0« war falsch
            System.out.println("ERROR: kann keine Wurzel aus negativen Zahlen ziehen");
            return;                                                                    // Programm wurde nicht abgebrochen
        }

        double t = c;                                                                  // muss vor der Schleife deklariert werden (Scoping)
                                                                                       // darf außerdem nicht in jeder Iteration zurückgesetzt werden
        while (Math.abs(t * t - c) >= 0.0001) {                                        // Abbruchbedingung war falsch herum
            t = (t + (c / t)) / 2;                                                     // Klammern um Zähler haben gefehlt
        }

        System.out.println(t);
    }

}
