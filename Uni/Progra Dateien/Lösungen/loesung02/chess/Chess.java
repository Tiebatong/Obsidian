static void main() {
    int size = 15;

    // Verwende zwei verschachtelte Schleifen, um ein Schachbrettmuster auszugeben
    // Idee: Wenn die Summe von Spalten- und Zeilenindex gerade ist, muss ein * gesetzt werden.
    // Dadurch ergeben sich abwechselnd pro Zeile und Spalte Sterne und Leerzeichen.
    for (int rowIndex = 0; rowIndex < size; rowIndex++) {
        for (int columnIndex = 0; columnIndex < size; columnIndex++) {
            if ((rowIndex + columnIndex) % 2 == 0) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }

        // Erzeuge einen Zeilenumbruch am Ende einer Zeile
        System.out.println();
    }
}
