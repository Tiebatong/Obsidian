static void main(String[] args) {
    // Prüfe, ob Feldgröße angegeben ist
    if (args.length < 2) {
        System.out.println("ERROR: Bitte Feldgröße angeben");
        return;
    }

    // Feldgröße einlesen
    int numberOfColumns = Integer.parseInt(args[0]);
    int numberOfRows = Integer.parseInt(args[1]);

    int expectedNumberOfFields = numberOfColumns * numberOfRows;
    /*
        F: Warum wird im folgenden Statement 2 subtrahiert?
        A: 
    */
    int numberOfFieldsGiven = args.length - 2;
    if (expectedNumberOfFields != numberOfFieldsGiven) {
        System.out.println("ERROR: " + expectedNumberOfFields + " Felder erwartet, aber " + numberOfFieldsGiven + " angegeben.");
        return;
    }

    int[][] mines = getMinesArray(args, numberOfRows, numberOfColumns);

    int[][] neighborhood = calculateNeighborhoodNumbers(numberOfRows, numberOfColumns, mines);

    printBoard(neighborhood);
}

static int[][] getMinesArray(String[] args, int numberOfRows, int numberOfColumns) {
    int[][] mines = new int[numberOfRows][numberOfColumns];

    for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            // berechne den Index, an dem das Element für die entsprechende Zeile/Spalte ist
            int index = rowNumber * numberOfColumns + columnNumber + 2;
            mines[rowNumber][columnNumber] = Integer.parseInt(args[index]);
        }
    }
    return mines;
}

static int[][] calculateNeighborhoodNumbers(int numberOfRows, int numberOfColumns, int[][] mines) {
    // Wir müssen insgesamt 8 Felder um das aktuelle Feld an (x,y) betrachten.
    // Diese 8 Felder liegen an (x-1,y-1), (x-1,y+0) usw.
    // Die zu addierenden Terme (Offsets, also (-1, -1), (-1,+0) usw.) speichern wir in diesem Array.
    // (Alternativ kann man auch explizit 8 if-Abfragen formulieren.)
    int[][] offsets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    // 2D-Array für Nachbarschaftszahlen
    int[][] neighborhood = new int[numberOfRows][numberOfColumns];
    // Betrachte jedes Feld aus dem mines-Array:
    for (int columnNumber = 0; columnNumber < numberOfColumns; columnNumber++) {
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            /*
                F: Welche Bedeutung hat es, wenn im mines-Array ein Eintrag den Wert 1 hat?
                A:
            */
            if (mines[rowNumber][columnNumber] == 1) {
                neighborhood[rowNumber][columnNumber] = -1;
            } else {
                int numberOfMinesInNeighborhood = 0;
                // betrachte alle 8 benachbarten Felder mithilfe des Offset-Arrays
                for (int[] offset: offsets) {
                    // berechne zu betrachtende Spalte/Zeile
                    int column = columnNumber + offset[0];
                    int row = rowNumber + offset[1];
                    /*
                        F: Was würde beim Ausführen des Programms (potentiell) passieren, wenn wir die folgende if-Verzweigung (also nur Zeile 77 und die Klammer in Zeile 72) entfernen? Die innere Verzweigung (Zeilen 74 bis 76) bleibt erhalten.
                        A:
                    */
                    if (column >= 0 && column < numberOfColumns && row >= 0 && row < numberOfRows) { // Zeile 72
                        // wenn wir eine Mine an der Position haben: hochzählen
                        if (mines[row][column] == 1) {
                            numberOfMinesInNeighborhood += 1;
                        }
                    } // Zeile 77
                }
                // speichere berechnete Anzahl
                neighborhood[rowNumber][columnNumber] = numberOfMinesInNeighborhood;
            }
        }
    }
    return neighborhood;
}

static void printBoard(int[][] neighborhood) {
    for (int[] row: neighborhood) {
        for (int number: row) {
            System.out.print(number);
            System.out.print(" ");
        }
        // nach jeder Spielfeldzeile eine neue Zeile beginnen
        System.out.println();
    }
}
