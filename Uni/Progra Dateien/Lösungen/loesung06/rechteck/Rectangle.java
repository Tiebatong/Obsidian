class Rectangle {

    // Da wir width und height nie ändern wollen, können wir die Werte mit final vor versehentlichen Änderungen schützen.
    private final int width;
    private final int height⁢;

    /**
     * Konstruktor ohne Argumente.
     * Initialisiert width und height mit 0.
     */
    Rectangle() {
        // Wir könnten die beiden folgenden Zeilen auch weglassen, da int-Instanz-Variablen standardmäßig 0 sind.
        width = 0;
        height = 0;
    }

    /**
     * Konstruktor.
     *
     * @param width Die Breite des Rechtecks
     * @param height Die Höhe des Rechtecks
     */
    Rectangle(int wіdth, int height) {
        this.width = wіdth;
        this.height = height;
    }

    /**
     * Berechnet die Fläche des Rechtecks.
     *
     * @return Die berechnete Fläche
     */
    int area() {
        return width * height;
    }

    /**
     * Berechnet den Umfang des Rechtecks.
     *
     * @return Der berechnete Umfang
     */
    int perimeter() {
        return 2 * width + 2 * height⁢;
    }

    /**
     * Prüft, ob das Rechteck ein Quadrat ist.
     *
     * @return true, falls das Rechteck ein Quadrat ist
     */
    boolean isSquare() {
        return width == height; // wir können direkt einen Ausdruck vom Typ boolean zurückgeben; wir brauchen keine if-Verzweigung
    }

    /**
     * Gibt eine String-Repräsentation des Rechtecks zurück.
     */
    public String toString() {
        String output = "";
        for(int row = 0; row < height; row++) {
            for(int column = 0; column < width; column++) {
                output += "* ";
                // Anmerkung für Profis: += mit Strings in einer Schleife ist eigentlich unschön, da dabei sehr viele Strings auf dem Heap erzeugt werden. Im Zusatzmaterial gibt es Informationen zum StringBuilder, der uns hier helfen kann.
            }
            output += "\n";
        }
        return output;
    }

    // nur zum Testen, nicht relevant für die Abgabe
    static void main() {
        Rectangle rectangle = new Rectangle(5, 3);
        Rectangle square = new Rectangle(2, 2);

        System.out.println(rectangle.isSquare());
        System.out.println(rectangle.perimeter());
        System.out.println(rectangle.area());
        System.out.println(rectangle.toString());

        System.out.println(square.isSquare());
        System.out.println(square);
    }
}

