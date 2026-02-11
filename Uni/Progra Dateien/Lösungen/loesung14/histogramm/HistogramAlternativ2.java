import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// Variante mit Stream-API zum Gruppieren 
// Dieser Teil der Stream-API ist für Programmierung NICHT klausurrelevant.
class HistogramAlternativ2 {

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

        Map<Integer, Long> histogram;
        try {
            histogram = calculateHistogram(n, min, max, numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return;
        }

        print(histogram);
    }

    private static Map<Integer, Long> calculateHistogram(int n, int min, int max, int[] numbers) {
        if(n <= 0) {
            throw new IllegalArgumentException("Anzahl der Bins 'n' muss positiv sein.");
        }

        if(min > max) {
            throw new IllegalArgumentException("'min' darf nicht größer als 'max' sein.");
        }

        if((max - min) % n != 0) {
            throw new IllegalArgumentException("(%d - %d) ist nicht restlos durch '%d' teilbar.".formatted(max, min, n));
        }

        int binWidth = (max - min) / n;

        if(Arrays.stream(numbers).anyMatch(x -> x < min || x > max)) {
            throw new IllegalArgumentException("Eine der Eingaben liegt außerhalb des Bereichs.");
        }

        Map<Integer, Long> histogram = new HashMap<>(Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(x -> (x - min) / binWidth, Collectors.counting())));

        // Sonderfall: letztes Intervall ist inklusive; falls ein Intervall mit Index n entstanden ist,
        // muss dessen Zähler zum Zähler vom Intervall mit Index n-1 addiert werden
        histogram.put(n - 1, histogram.getOrDefault(n - 1, 0L) + histogram.getOrDefault(n, 0L));
        histogram.remove(n);

        // nicht vorhandene Bins auf 0 setzen
        for(int i = 0; i < n; i++) {
            histogram.putIfAbsent(i, 0L);
        }

        return histogram;
    }

    private static void print(Map<Integer, Long> histogram) {
        histogram.keySet().stream()
                .sorted()
                .forEach(binNr -> System.out.print(histogram.get(binNr) + " "));
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
