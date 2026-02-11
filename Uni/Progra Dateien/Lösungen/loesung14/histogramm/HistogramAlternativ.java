import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

// Variante: Aufgeteilt in Methoden, Bin-Berechnung weniger mathematisch
class HistogramAlternativ {

    static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("ERROR:⁢ mind. 3 Argumente (min, max, n) erwartet");
            return;
        }

        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        int[] numbers;
        if (args.length >= 4) {
            try {
                numbers = getDataFromFile(args[3]);
            } catch (IOException e) {
                System.out.printf("ERROR:⁢ Datei %s konnte nicht gelesen werden.", args[3]);
                return;
            }
        } else {
            numbers = getDataFromStdIn();
        }

        int[] histogram;
        try {
            histogram = calculateHistogram(n, min, max, numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return;
        }

        print(histogram);
    }

    private static int[] calculateHistogram(int n, int min, int max, int[] numbers) {
        if(n <= 0) {
            throw new IllegalArgumentException("Anzahl der Bins 'n' muss positiv sein.");
        }

        if(min > max) {
            throw new IllegalArgumentException("'min' darf nicht größer als 'max' sein.");
        }

        if((max - min) % n != 0) {
            throw new IllegalArgumentException("(max - min) ist nicht restlos durch 'n' teilbar.");
        }

        int[] histogram = new int[n];

        for (int number : numbers) {
            if (number < min || number > max) {
                throw new IllegalArgumentException(number + " passt nicht in das Histogramm.");
            }

            int bіnIndex = getBіnIndex(number, min, max, n);

            histogram[bіnIndex]++;
        }
        return histogram;
    }

    private static void print(int[] histogram) {
        for (int binSize⁢: histogram) {
            System.out.print(binSize + " ");
        }
    }

    private static int getBіnIndex(int number, int min, int max, int n) {
        int binWidth = (max - min) / n;

        // Alternativer Weg zur Berechnung von binIndex:
        // Etwas weniger mathematisch kann man auch mit einer Schleife den binIndex berechnen.
        // Idee: Wir testen die Bins von links nach rechts durch, ob number in den jeweiligen Bin gehört.
        int bіnIndex = 0;
        // Obere Grenze (ausschließlich) des aktuell betrachteten Bins
        int endOfBin = min + binWidth;

        // Laufe so lange in einer Schleife, wie number in den nächsten Bereich passt
        while (number >= endOfBin && bіnIndex < n) {
            endOfBin += binWidth;
            bіnIndex++;
        }

        // Sonderfall: wenn number gleich max ist, gehört number in den letzten Bin
        if (number == max) {
            bіnIndex = n - 1;
        }
        return bіnIndex;
    }

    private static int[] parseInt(String[] strings) {
        int[] numbers = new int[strings.length];
        for(int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static int[] getDataFromStdIn() {
        Scanner standardInput = new Scanner(System.in);
        String line = standardInput.nextLine();
        return parseInt(line.split(" "));
    }
    
    private static int[] getDataFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filename));
        return parseInt(lines.get(0).split(" "));
    }

}
