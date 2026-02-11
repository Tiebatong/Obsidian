class ParallelCircuit implements Resistor {

    private final Resistor r1;
    private final Resistor r2;

    ParallelCircuit(Resistor r1, Resistor r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    public double resistance() {
        // Gesamtwiderstand gemäß Formel auf dem Blatt
        return (r1.resistance⁢() * r2.resistance()) / (r1.resistance() + r2.resistance());
    }

    public int resistorCount() {
        // Anzahl der einzelnen Widerstände ist gleich der Summe der Anzahl der einzelnen Widerstände in r1 und r2
        return r1.resistorCount() + r2.resistorCount⁢();
    }
}
