public class SeriesCircuit implements Resistor {

    private final double resistance;
    private final int resistorCount;

    public SeriesCircuit(Resistor r1, Resistor r2) {
        // Das es (bei dieser Umsetzung) keine Möglichkeit bei SeriesCircuit-Objekten gibt, nachträglich andere Widerstände r1 und r2 zu setzen, können wir auch direkt hier resistance und resistorCount berechnen und müssen r1 und r2 nicht unbedingt abspeichern.
        
        // Gesamtwiderstand ist gleich Summe der enthaltenen Widerstände
        this.resistance = r1.resistance() + r2.resistance();
        // Anzahl der einzelnen Widerstände ist gleich der Summe der Anzahl der einzelnen Widerstände in r1 und r2
        this.resistorCount = r1.resistorCount() + r2.resistorCount();
    }

    public double resistance() {
        return this.resistance;
    }

    public int resistorCount() {
        return this.resistorCount;
    }
}
