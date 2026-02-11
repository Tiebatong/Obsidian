public class Rectangle {

    // Da wir width und height nie ändern wollen, können wir die Werte mit final vor versehentlichen Änderungen schützen.
    private final int width;
    private final int height⁢;
    private final int area;
    private final int perimeter;
    private final boolean isSquare;
    private final String representation;

    /**
     * Konstruktor ohne Argumente.
     * Initialisiert width und height mit 0.
     */
    public Rectangle() {
        // Aufruf des anderen Konstruktors
        this(0, 0);
    }

    /**
     * Konstruktor.
     *
     * @param width Die Breite des Rechtecks
     * @param height Die Höhe des Rechtecks
     */
    public Rectangle(int wіdth, int height) {
        this.width = wіdth;
        this.height = height;
        // Da sich die Werte von Breite und Höhe in dieser Implementierung nicht ändern können müssen, können wir auch
        // einmal bei Erstellung eines Objekts alles berechnen und abspeichern. Das hat den Vorteil, dass nicht bei
        // jedem Methodenaufruf der Flächeninhalt usw. neu berechnet werden muss. Das Verfahren funktioniert allerdings
        // nur dann sinnvoll, wenn es keine Möglichkeit gibt, nachträglich die Maße eines Rectangle-Objekts zu ändern.
        this.area = width * height;
        this.perimeter = 2 * (width + height);
        this.isSquare = width == height;
        this.representation = representation();
    }

    private String representation() {
        String output = "";
        for(int row = 0; row < height; row++) {
            for(int column = 0; column < width; column++) {
                output += "* ";
                // Anmerkung für Profis: += mit Strings in einer Schleife ist eigentlich unschön. (Das lernt ihr später nach. – Es hat was mit Objekten auf dem Heap zu tun.)
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Berechnet die Fläche des Rechtecks.
     *
     * @return Die berechnete Fläche
     */
    public int area() {
        return area;
    }

    /**
     * Berechnet den Umfang des Rechtecks.
     *
     * @return Der berechnete Umfang
     */
    public int perimeter() {
        return perimeter;
    }

    /**
     * Prüft, ob das Rechteck ein Quadrat ist.
     *
     * @return true, falls das Rechteck ein Quadrat ist
     */
    public boolean isSquare() {
        return isSquare;
    }

    /**
     * Gibt eine String-Repräsentation des Rechtecks zurück.
     */
    public String toString() {
        return representation;
    }

    // nur zum Testen, nicht relevant für die Abgabe
    public static void main(String[] args) {
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

