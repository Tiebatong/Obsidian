public class Ship {

    // 2D-Transformationen können mit Matrizen beschrieben werden.
    // Die Spalten in den Transformations-Matrizen geben jeweils an, auf welche Vektoren die Standardnormalbasis abgebildet wird.
    // siehe z. B. https://www.youtube.com/watch?v=kYB8IZa5AuE&list=PLZHQObOWTQDPD3MizzM2xVFitgF8hE_ab&index=3
    // Da Translationen (Verschiebungen) in 2D keine lineare Transformation sind, können sie nicht mit 2D-Matrizen abgebildet werden.
    // Allerdings sind sie in 3D als lineare Transformation darstellbar, siehe z. B. https://www.youtube.com/watch?v=E3Phj6J287o
    private final static Matrix SKALIEREN_FAKTOR_2_X = new Matrix(new int[][]{
        {2, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    });
    
    private final static Matrix SKALIEREN_FAKTOR_2_Y = new Matrix(new int[][]{
        {1, 0, 0},
        {0, 2, 0},
        {0, 0, 1}
    });
    
    private final static Matrix SCHERUNG_X = new Matrix(new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {0, 0, 1}
    });
    
    private final static Matrix SCHERUNG_Y = new Matrix(new int[][]{
        {1, 1, 0},
        {0, 1, 0},
        {0, 0, 1}
    });
    
    private final static Matrix BEWEGEN_X = new Matrix(new int[][]{
        { 1, 0, 0},
        { 0, 1, 0},
        { 1, 0, 1}
    });
    
    private final static Matrix BEWEGEN_Y = new Matrix(new int[][]{
        { 1, 0, 0},
        { 0, 1, 0},
        { 0, 1, 1}
    });
    
    private final static Matrix ROTATION_90 = new Matrix(new int[][]{
        {0, -1, 0},
        {1,  0, 0},
        {0, 0, 1}
    });
    
    private final static Matrix SPIEGELN = new Matrix(new int[][]{
        {-1, 0, 0},
        { 0, 1, 0},
        { 0, 0, 1}
    });
    
    private final static Matrix[] TRANSFORMATIONEN = {SKALIEREN_FAKTOR_2_X, SKALIEREN_FAKTOR_2_Y, SCHERUNG_X, SCHERUNG_Y, BEWEGEN_X, BEWEGEN_Y, ROTATION_90, SPIEGELN};
    
    private final static String[] TRANSFORMATIONEN_NAMEN = {"Skalierung um Faktor 2 in x-Richtung", "Skalierung um Faktor 2 in y-Richtung", "Scherung in x-Richtung", "Scherung in y-Richtung", "Verschiebung in x-Richtung", "Verschiebung in y-Richtung", "Rotation um 90°", "Spiegelung um x-Achse"};

    private final static int ANZAHL_ECKPUNKTE_SCHIFF = 11; // 1 weniger als SCHIFF Einträge hat, weil erster und letzter Punkt gleich
    
    private final static Matrix SCHIFF = new Matrix(new int[][] {
        {-2,-1, 1}, // Rumpf
        { 1,-1, 1}, // Mast
        { 1, 0, 1},
        {-1, 0, 1}, // Segel
        { 1, 3, 1},
        { 1, 1, 1},
        { 1, 0, 1}, // Mast
        { 1,-1, 1},
        { 3,-1, 1}, // Rest Rumpf
        { 2,-2, 1},
        {-1,-2, 1},
        {-2,-1, 1}  // = Anfangspunkt
    });

    public static void main(String args[]) {
        StdDraw.setScale(-15, 15);
        
        Matrix aktuellesBild = SCHIFF;
        
        System.out.println("Geben Sie hier in der Konsole die Nummer einer Transformation ein und drücken Sie Enter, um diese auf das aktuelle Bild anzuwenden.");
        System.out.println("0: Schiff zurücksetzen");
        for(int i = 0; i < TRANSFORMATIONEN_NAMEN.length; i++) {
            System.out.println((i+1) + ": " + TRANSFORMATIONEN_NAMEN[i]);
        }
        
        // Wie das interaktive Einlesen von der Konsole funktioniert, gucken wir uns später noch an.
        java.util.Scanner stdin = new java.util.Scanner(System.in);
    
        zeichnen(aktuellesBild, ANZAHL_ECKPUNKTE_SCHIFF);
        
        while(stdin.hasNext()) {
            String eingabe = stdin.nextLine();
            
            if(eingabe.equals("0")) {
                aktuellesBild = SCHIFF;
            } else {
                try { // was try-catch macht, besprechen wir später noch
                    int index = Integer.parseInt(eingabe) - 1;
                    if(index >= 0 && index < TRANSFORMATIONEN.length) {
                        aktuellesBild = aktuellesBild.multiply(TRANSFORMATIONEN[index]);
                    } else {
                        System.out.println("»" + eingabe + "« ist keine gültige Eingabe");
                    }
                } catch(NumberFormatException e) {
                    System.out.println("»" + eingabe + "« ist keine gültige Eingabe");
                }
            }
        
            StdDraw.clear();

            zeichnen(aktuellesBild, ANZAHL_ECKPUNKTE_SCHIFF);
        }
    }
    
    private static void zeichnen(Matrix eckpunkte, int anzahlEckpunkte) {
        // zeichnet 2D-Projektion auf die xy-Ebene
        for(int i = 0; i < anzahlEckpunkte; i++) {
            StdDraw.line(eckpunkte.get(i, 0), eckpunkte.get(i, 1), eckpunkte.get(i+1, 0), eckpunkte.get(i+1, 1));
        }
    }
}
