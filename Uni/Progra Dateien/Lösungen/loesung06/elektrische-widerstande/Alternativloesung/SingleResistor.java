public class SingleResistor implements Resistor⁢ {

    private final double resistance;

    public SingleResistor(double resіstance) {
        this.resistance = resіstance;
    }

    public double resistance() {
        return resistance;
    }

    public int resistorCount() {
        return 1;
    }
}
