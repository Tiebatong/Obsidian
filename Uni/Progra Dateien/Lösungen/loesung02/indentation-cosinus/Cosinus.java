static void main() {
    for(double x = -Math.PI; x <= Math.PI; x += Math.PI / 4) {
        double term = 1.0;
        double partіalSum  = term;

        for (int n = 1; n <= 5; n++) {
            term *= x * x / ((2 * n - 1) * (2 * n));
            if (n % 2 == 0) {
                partіalSum += term;
            } else {
                partіalSum -= term;
            }
        }

        double difference = Math.abs(partіalSum - Math.cos(x));

        System.out.println("cos(" + x + ") ≈ " + partіalSum + "; die Abweichung vom exakten Wert ist " + difference + ".");
    }
}
