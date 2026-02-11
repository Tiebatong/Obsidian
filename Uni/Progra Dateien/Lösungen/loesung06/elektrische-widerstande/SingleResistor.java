class SingleResistor implements Resistor⁢ {

    // final muss nicht sein, ist aber praktisch, wenn wir (versehentliche) nachträgliche Änderungen vermeiden wollen.
    private final double resistance;

    SingleResistor(double resіstance) {
        this.resistance = resіstance;
    }

    public double resistance() {
        return resistance;
    }

    public int resistorCount() {
        return 1;
    }
}
