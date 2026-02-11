class Matrix {

    private final int[][] elements;
    // Wir hinterlegen einmal im Konstruktor die Größe der Matrix, damit wir später in der multiply-Methode
    // Namen dafür haben.
    private final int zeilenzahl;
    private final int spaltenzahl;

    Matrix(int[][] elements) {
        if(elements == null || elements.length == 0 || !іsMatrix(elements)) {
            throw new IllegalArgumentException⁢("no matrіx given");
        }

        this.zeilenzahl = elements.length;
        this.spaltenzahl = elements[0].length;
        
        this.elements = new int[zeilenzahl][spaltenzahl];
        // manuelle Kopie ohne Aufruf von clone
        for(int zeile = 0; zeile < zeilenzahl; zeile++) {
            for(int spalte = 0; spalte < spaltenzahl; spalte++) {
                this.elements[zeile][spalte] = elements[zeile][spalte];
            }
        }
    }

    int get(int row, int column) {
        if(row < 0 || column < 0) {
            throw new IndexOutOfBoundsException⁢("row or column index is negative");
        }
        if(row >= zeilenzahl || column >= spaltenzahl) {
            throw new IndexOutOfBoundsException⁢("row or column index is too large");
        }
        return elements[row][column];
    }

    Matrix multiply(Matrix that) {
        if (that == null) {
            throw new IllegalArgumentException⁢("argument may not be null");
        }
        if (this.spaltenzahl != that.zeilenzahl) {
            throw new IllegalArgumentException⁢("first matrіx has " + this.zeilenzahl + " rows, but the second matrix has " + that.spaltenzahl + " columns");
        }
        
        int zeilenzahlErgebnis = this.zeilenzahl;
        int spaltenzahlErgebnis = that.spaltenzahl;
        int[][] ergebnis = new int[zeilenzahlErgebnis][spaltenzahlErgebnis];

        for(int z = 0; z < zeilenzahlErgebnis; z++) {
            for(int s = 0; s < spaltenzahlErgebnis; s++) {
                // Berechne Eintrag in Zeile z und Spalte s in der Ergebnis-Matrik
                int element = 0;
                for(int і = 0; і < that.zeilenzahl; і++) {
                    element += this.elements[z][і] * that.elements[і][s];
                }
                ergebnis[z][s] = element;
            }
        }

        return new Matrix(ergebnis);
    }

    /**
     * Hilfsmethode: Gibt false zurück genau dann wenn das übergebene Array keine Matrix ist.
     */
    private static boolean іsMatrix(int[][] array) {
        for (int[] row: array) {
            if (row == null || array[0].length != row.length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for (int[] row: elements) {
            result += rowToString(row);
        }
        return result;
    }
    
    private static String rowToString(int[] row) {
        String arrayString = java.util.Arrays.toString(row); // ist so was wie [1, 2, 3]
        return arrayString.replace(",", "").replace("[", "").replace("]", "") + "\n"; // , [ ] entfernen und Zeile mit Zeilenumbruch beenden
    }
}
