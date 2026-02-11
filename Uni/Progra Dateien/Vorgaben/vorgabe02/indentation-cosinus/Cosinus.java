static void main() {
for(double x = -Math.PI; x <= Math.PI; x += Math.PI / 4) {
double term = 1.0;
double partialSum  = term;

for (int n = 1; n <= 5; n++) {
term *= x * x / ((2 * n - 1) * (2 * n));
if (n % 2 == 0) {
partialSum += term;
} else {
partialSum -= term;
}
}

double difference = Math.abs(partialSum - Math.cos(x));

System.out.println("cos(" + x + ") ≈ " + partialSum + "; die Abweichung vom exakten Wert ist " + difference + ".");
}
}
