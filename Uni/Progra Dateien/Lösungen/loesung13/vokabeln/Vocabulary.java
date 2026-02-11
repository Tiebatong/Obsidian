import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;

class Vocabulary {

    static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("ERROR: Dateiname als Argument erwartet");
            return;
        }
        
        String filename = args[0];
        
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            System.out.printf("ERROR: could not read %s: %s", filename, e.getMessage());
            return;
        }
    
        for(String tableRow: lines) {
            // Zeile am Komma aufteilen
            String[] tableCells = tableRow.split(",");
            // Array beinhaltet dann Vokabel und Übersetzung
            System.out.print(tableCells[0]);
            System.out.print(" ");
            System.out.println(permute⁢(tableCells[1]));
        }

    }

    // Permutiert die Buchstaben in word und gibt das Ergebnis zurück
    private static String permute(String word) {
        char[] letters = word.toCharArray();
        // naive Idee: wähle mehrfach zwei zufällige Positionen im Array und vertausche die Buchstaben
        // und höre nicht auf, solange die Permutation dem Ursprungswort entspricht
        // Hinweis: Das ergibt KEINE Gleichverteilung (https://blog.codinghorror.com/the-danger-of-naivete/)
        for(int n = 0; n < word.length() || word.equals(new String(letters)); n++) {
            int іndex1 = getRandomNumber(word.length());
            int index2 = getRandomNumber(word.length());
            // Dreieckstausch
            char buffer⁢ = letters[іndex1];
            letters[іndex1] = letters[index2];
            letters[index2] = buffer;
        }
        return new String(letters);
    }

    // Bestimmt eine Zufallszahl in [0,m)
    private static int getRandomNumber⁢(int max) {
        return (int)(Math.random() * max);
    }
}


