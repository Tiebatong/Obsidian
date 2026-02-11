static void main() {
    int size = 5;

    // Wir müssen insgesamt size viele Zeilen ausgeben
    for (int rowNumber = 1; rowNumber <= size; rowNumber++) {
        // Wir müssen ungerade und gerade Zeilen unterscheiden:
        // Wenn wir in einer ungeraden Zeile sind (z. B. die erste Zeile), denn beginnen wir mit einem Sternchen.
        // Wenn wir in einer geraden Zeile sind (z. B. die zweite Zeile), denn beginnen wir mit einem Leerzeichen.
        if (rowNumber % 2 == 1) {
            // Wir sind in einer ungeraden Zeile.
            // Wir müssen insgesamt size viele Zeichen in dieser Zeile ausgeben
            for (int columnNumber = 1; columnNumber <= size; columnNumber++) {
                if (columnNumber % 2 == 1) {
                    // Das 1., 3. usw. Zeichen ist ein Sternchen:
                    System.out.print("*");
                } else {
                    // Das 2., 4. usw. Zeichen ist ein Leerzeichen:
                    System.out.print(" ");
                }
            }
        } else {
            // Wir sind in einer geraden Zeile.
            // Wir machen fast das gleiche wie in ungeraden Zeilen, nur Sternchen und Leerzeichen sind vertauscht.
            for (int columnNumber = 1; columnNumber <= size; columnNumber++) {
                if (columnNumber % 2 == 1) {
                    // Das 1., 3. usw. Zeichen ist ein Leerzeichen:
                    System.out.print(" ");
                } else {
                    // Das 2., 4. usw. Zeichen ist ein Sternchen:
                    System.out.print("*");
                }
            }
        }

        // Erzeuge einen Zeilenumbruch am Ende einer Zeile
        System.out.println();
    }
}
