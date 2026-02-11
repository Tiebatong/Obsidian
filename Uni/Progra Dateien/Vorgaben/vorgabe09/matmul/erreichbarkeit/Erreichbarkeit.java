/**
 * Durch wie viele Türen muss man mindestens gehen, um vom Eingang 25.12 nach 25.12.O1.18 zu kommen?
 *
 * Türen werden im folgenden Bild durch Großbuchstaben dargestellt:
 *
 * EG:
 *                     S Eingang 25.12 - Start
 *                     |
 *                     A Tür Windfang 25.12
 *    ---- B ---- C ---|
 *            🪜1      |
 *                     |
 *                     |
 *                     D Tur zwischen 25.12 und 25.22
 *            🪜2      |
 *    ---- E ---- F ---|
 *                     |
 *                     |
 *                     |
 *                     G Tür zwischen 25.12 und 25.32
 *
 * OG:
 *                     |
 *                     |
 *                     |
 *    ---- H ---- I ---|
 *            🪜1      |
 *                     |
 *                     |
 *                     J Tür zwischen 25.12 und 25.22
 *            🪜2      |
 *    ---- K ---- L ---|Z Ziel
 */

public class Erreichbarkeit {

    // Folgende Matrix gibt an, welche Türen jeweils direkt miteinander verbunden sind:
    // S mit A
    // A mit C, D
    // B mit C, H, I
    // C mit D, H, I
    // D mit F, G
    // E mit F, K, L
    // F mit G, K, L
    // H mit I
    // I mit J
    // J mit Z
    // K mit L
    // L mit Z
    // (und jeweils andersherum)
    private final static Matrix ADJAZENZ_MATRIX = new Matrix(new int[][]{
               //von: S A B C D E F G H I J K L Z      nach:
                    { 0,1,0,0,0,0,0,0,0,0,0,0,0,0}, // S (0)
                    { 1,0,0,1,1,0,0,0,0,0,0,0,0,0}, // A
                    { 0,0,0,1,0,0,0,0,1,1,0,0,0,0}, // B
                    { 0,1,1,0,1,0,0,0,1,1,0,0,0,0}, // C
                    { 0,1,0,1,0,0,1,1,0,0,0,0,0,0}, // D
                    { 0,0,0,0,0,0,1,0,0,0,0,1,1,0}, // E
                    { 0,0,0,0,1,1,0,1,0,0,0,1,1,0}, // F
                    { 0,0,0,0,1,0,1,0,0,0,0,0,0,0}, // G
                    { 0,0,1,1,0,0,0,0,0,1,0,0,0,0}, // H
                    { 0,0,1,1,0,0,0,0,1,0,1,0,0,0}, // I
                    { 0,0,0,0,0,0,0,0,0,1,0,0,0,1}, // J
                    { 0,0,0,0,0,1,1,0,0,0,0,0,1,0}, // K
                    { 0,0,0,0,0,1,1,0,0,0,0,1,0,1}, // L
                    { 0,0,0,0,0,0,0,0,0,0,1,0,1,0}, // Z (13)
            });

    public static void main(String[] args) {
        // Durch wiederholtes Multiplizieren der Adjazenz-Matrix mit sich selbst können wir prüfen, nach wie vielen
        // Schritten wir von S aus Z erreichen. Sobald in Spalte S in Zeile Z eine Zahl größer 0 steht, haben
        // wir Z von S aus erreicht.
        // Die Anzahl der benötigten Multiplikationen gibt an, wie viele Türen wir (exakt) passiert haben.
        // Die konkrete Zahl an dieser Matrixposition gibt die Anzahl der Wege an, die es mit dieser Anzahl Türen von S
        // nach Z gibt.

        int anzahlTueren = 0;
        int anzahlWege;
        Matrix fortschrittsMatrix = ADJAZENZ_MATRIX;
        do {
            fortschrittsMatrix = fortschrittsMatrix.multiply(ADJAZENZ_MATRIX);
            anzahlWege = fortschrittsMatrix.get(13, 0);
            anzahlTueren++;
        } while(anzahlWege == 0);

        System.out.println("Um von S nach Z zu kommen, muss durch mindestens " + anzahlTueren + " Türen gegangen werden.");
        System.out.println("Es gibt genau " + anzahlWege + " Wege von S nach Z, bei denen genau " + anzahlTueren + "-mal durch eine Tür gegangen wird.");
    }

}
