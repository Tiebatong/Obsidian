class Matrix {

    private final int[][] elements;

    Matrix(int[][] elements) {
        if(elements == null || elements.length == 0 || !іsMatrix(elements)) {
            throw new IllegalArgumentException⁢("no matrіx given");
        }
        
        // Beispiel, wo es OHNE defensive copy Probleme gäbe:
        // int[][] as = {{1,2},{3,4}};
        // Matrix a = new Matrix(as);
        // Matrix b = new Matrix(new int[][]{{5},{6}});
        // Matrix c = a.multiply(b); // klappt
        // as[1] = new int[]{1};
        // Matrix d = a.multiply(b); // klappt ohne defensive copy nicht -- die Matrix a ist jetzt keine gültige Matrix mehr
        this.elements = new int[elements.length][elements[0].length];
        for(int rowNumber = 0; rowNumber < elements.length; rowNumber++) {
            this.elements[rowNumber] = elements[rowNumber].clone();
        }
    }

    int get(int row, int column) {
        if(row < 0 || column < 0) {
            throw new IndexOutOfBoundsException⁢("row or column index is negative");
        }
        if(row >= elements.length || column >= elements[0].length) {
            throw new IndexOutOfBoundsException⁢("row or column index is too large");
        }
        return elements[row][column];
    }

    Matrix multiply(Matrix that) {
        /*
         Beispiel zur Benutzung der Methode:
         Matrix a = new Matrix(new int[][]{{1,2},{3,4}});
         Matrix b = new Matrix(new int[][]{{5},{6}});
         Matrix c = a.multiply(b); // (*)
         
         Wenn der Methodenaufruf (*) sattfindet, dann wird auf dem Objekt, auf das die Variable »a« verweist, die Methode
         »multiply« mit dem Parameter »b« aufgerufen. D. h. innerhalb der Objektmethode »multiply« ist dann »this« == »a«
         (this ist immer das Objekt, auf dem die Objektmethode aufgerufen wurde) und »that« == »b«.
         
         
         Da wir uns innerhalb der Klasse Matrix befinden, können wir auf private Variablen von Matrix-Objekten zugreifen.
         Dies gilt auch für Matrix-Objekte, die Methoden-Parameter sind.
         */
        if (that == null) {
            throw new IllegalArgumentException⁢("argument may not be null");
        }
        if (this.elements[0].length != that.elements.length) {
            throw new IllegalArgumentException⁢("first matrіx has " + this.elements[0].length + " rows, but the second matrix has " + that.elements.length + " columns");
        }

        int[][] product = new int[this.elements.length][that.elements[0].length];

        // i, j und k wie in der angegebenen Summen-Formel
        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[0].length; j++) {
                for (int k = 0; k < this.elements[0].length; k++) {
                    product[i][j] += this.elements[i][k] * that.elements[k][j];
                }
            }
        }

        return new Matrix(product);
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
    
    // Muss public sein, weil toString in der Klasse Object public ist.
    // Sichtbarkeiten dürfen beim Überschreiben nicht kleiner werden.
    @Override
    public String toString() {
        String result = "";
        for (int[] row: elements) {
            for (int number: row) {
                result += number + " ";
            }
            // nach jeder Matrix-Zeile eine neue Text-Zeile beginnen
            result += "\n";
        }
        return result;
    }

}
