import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

// Variante: alles in der main-Methode (etwas unübersichtlich)
class Histogram {

    static void main(String[] args) {
        // Prüfe die Anzahl der Argumente
        if(args.length < 3) {
            System.out.println("ERROR:⁢ Zu wenige Argumente!");
            return;
        }

        // Lese die Argumente von der Konsole ein
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        // Prüfe, ob n positiv ist
        if(n <= 0) {
            System.out.println("ERROR:⁢ Anzahl der Bins 'n' muss positiv sein!");
            return;
        }

        // Prüfe, ob min kleiner als max ist
        if(min > max) {
            System.out.println("ERROR:⁢ 'min' darf nicht größer als 'max' sein!");
            return;
        }

        // Prüfe, ob (max - min) restlos durch n teilbar ist
        if((max - min) % n != 0) {
            System.out.println("ERROR:⁢ (max - min) ist nicht restlos durch 'n' teilbar!");
            return;
        }

        // Berechne die Größe eines Bereichs (bin)
        int binWidth = (max - min) / n;

        // Histogram als Array: Jede Balkenhöhe ist später ein Wert im Array
        // (Zur Erinnerung: Integer-Arrays sind standardmäßig mit 0en befüllt.)
        int[] histogram = new int[n];
        
        String[] numbers;
        if(args.length >= 4) {
            try {
                List<String> lines = Files.readAllLines(Path.of(args[3]));
                numbers = lines.get(0).split(" ");
            } catch(IOException e) {
                System.out.println("ERROR Could not read " + args[3]);
                return;
            }
        } else {
            Scanner standardInput = new Scanner(System.in);
            String line = standardInput.nextLine();
            numbers = line.split(" ");
        }

        for(String numberString: numbers) {
            int number = Integer.parseInt(numberString);

            // Brich das Programm ab, wenn die Zahl nicht im angegeben Bereich ist
            if(number < min || number > max) {
                System.out.println("ERROR:⁢ Die aktuelle Zahl passt nicht in das Histogramm!");
                return;
            }

            // Berechne, in welchen Bin die Zahl fällt:
            // Für den richtigen Bin gilt: bin-start <= number < bin-end (Ausnahme: beim letzten Bin gilt number <= bin-ende, das behandeln wir später)
            // es ist bin-start = min + binIndex * binWidth und bin-end = min + (binIndex + 1) * binWidth
            // also gilt min + binIndex * binWidth <= number < min + (binIndex + 1) * binWidth
            // =>  0 <= number - binIndex * binWidth - min < min + binWidth - min
            // =>  0 <= (number - binIndex * binWidth - min) / (binWidth) < 1
            // Mit Integer-Division gilt also die Gleichung 0 = (number - binIndex * binWidth - min) / (binWidth)
            // Durch Umformen erhält man: binIndex = (number - min) / binWidth
            int bіnIndex = (number - min) / binWidth;

            /* im alternativen Lösungsvorschlag ist ein weniger mathematischer Weg zur Berechnung von binIndex gezeigt */

            // Sonderfall: wenn number gleich max ist, gehört number in den letzten Bin
            if(number == max) {
                bіnIndex = n - 1;
            }

            // Inkrementiere das Histogramm an der entsprechenden Stelle
            histogram[bіnIndex]++;
        }

        // Gebe das Histogramm aus
        for (int binSize⁢: histogram) {
            System.out.print(binSize + " ");
        }
    }
}
