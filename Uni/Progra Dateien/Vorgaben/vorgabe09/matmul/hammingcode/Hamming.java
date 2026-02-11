/* Tool zur Generierung und Prüfung von (7,4)-Hamming-Code (bekannt aus der Rechnerarchitektur) */
public class Hamming {

    private static final int DATENWORT_LAENGE = 4;
    private static final int CODEWORT_LAENGE = 7;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Genau ein Argument erwartet: entweder ein Codewort (7 Bit) oder ein Datenwort (4 Bit)");
            return;
        }
        if(!istBinaerzahl(args[0])) {
            System.out.println("Das Argument muss eine Binärzahl sein.");
            return;
        }
        if(args[0].length() == DATENWORT_LAENGE) {
            System.out.println("Codewort: " + codewortBerechnen(args[0]));
        } else if(args[0].length() == CODEWORT_LAENGE) {
            System.out.println("Codewort gültig?: " + codewortPruefen(args[0]));
        } else {
            System.out.println("Das Argument muss entweder ein Datenwort (7 Bit) oder ein Codewort (4 Bit) sein.");
        }
    
    }

    private static boolean istBinaerzahl(String zahl) {
        for(int i = 0; i < zahl.length(); i++) {
            if(zahl.charAt(i) != '0' && zahl.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

    private static String codewortBerechnen(String datenwort) {
        int[][] datenwortVektor = new int[DATENWORT_LAENGE][1];
        for(int i = 0; i < DATENWORT_LAENGE; i++) {
            datenwortVektor[i][0] = Integer.parseInt(datenwort.substring(i, i + 1));
        }

        Matrix datenwortMatrix = new Matrix(datenwortVektor);

        Matrix generatorMatrix = new Matrix(new int[][]{
            {1, 1, 0, 1},
            {1, 0, 1, 1},
            {1, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        });

        Matrix codewortMatrix = generatorMatrix.multiply(datenwortMatrix);

        String codewort = "";
        for(int i = 0; i < CODEWORT_LAENGE; i++) {
            codewort += codewortMatrix.get(i, 0) % 2;
        }

        return codewort;
    }

    private static boolean codewortPruefen(String codewort) {
        int[][] codewortVektor = new int[CODEWORT_LAENGE][1];
        for(int i = 0; i < CODEWORT_LAENGE; i++) {
            codewortVektor[i][0] = Integer.parseInt(codewort.substring(i, i + 1));
        }

        Matrix codewortMatrix = new Matrix(codewortVektor);

        Matrix kontrollMatrix = new Matrix(new int[][]{
            {1, 0, 1, 0, 1, 0, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {0, 0, 0, 1, 1, 1, 1}
        });

        Matrix fehlerMatrix = kontrollMatrix.multiply(codewortMatrix);

        for(int i = 0; i < 3; i++) {
            if((fehlerMatrix.get(i, 0) % 2) != 0) {
                return false;
            }
        }

        return true;
    }
}
