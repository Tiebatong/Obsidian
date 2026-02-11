/*
Im Gegensatz zur ersten Lösung werden hier in spaltenweiseInRasterSchreiben und zeilenweiseInRasterSchreiben
die Spalten- und Zeilennummern getrennt durchgezählt und nicht mit Modulo gearbeitet.
*/
static void main(String[] args) {
    if (args.length != 2) {
        System.out.println("ERROR:⁢ genau zwei Argumente erwartet");
        return;
    }
    // Argument für Modus prüfen
    String modus = args[0];
    if (!(modus.equals("D") || modus.equals("E"))) {
        System.out.println("ERROR:⁢ " + modus + " ist ein ungültiges Argument");
        return;
    }
    String wort = args[1];
    if (wort.length() != 28) {
        System.out.println("ERROR:⁢ Nachrichtenlänge falsch");
        return;
    }
    // Abhängig vom Modus entschlüsseln oder verschlüsseln
    if (modus.equals("E")) {
        System.out.println(verschluesseln(wort));
    } else {
        System.out.println(entschluesseln(wort));
    }
}

static String verschluesseln(String wort) {
    // einzelne Buchstaben in 2D-Raster ZEILENWEISE eintragen
    char[][] raster = zeilenweiseInRasterSchreiben(wort);
    // 2D-Raster SPALTENWEISE ablesen
    return rasterSpaltenweiseAblesen(raster);
}

static String entschluesseln(String wort) {
    // einzelne Buchstaben in 2D-Raster SPALTENWEISE eintragen
    char[][] raster = spaltenweiseInRasterSchreiben(wort);
    // 2D-Raster ZEILENWEISE ablesen
    return rasterZeilenweiseAblesen(raster);
}

static char[][] spaltenweiseInRasterSchreiben(String wort⁢) {
    char[][] raster = new char[4][7];
    int positionInWort = 0;
    // Beachten: Wenn wir spaltenweise schreiben, dann heißt das, dass zuerst Spalte 0 vollgeschrieben wird.
    // D. h. der spaltenIndex bleibt zu Beginn erstmal so lange 0, bis alle zeilenIndices durchgezählt sind.
    // Danach werden dann für spaltenIndex=1 alle zeilenIndices durchgezählt usw.
    for(int spaltenIndex = 0; spaltenIndex < 7; spaltenIndex++) {
        for(int zeilenIndex = 0; zeilenIndex < 4; zeilenIndex++) {
            raster[zeilenIndex][spaltenIndex] = wort⁢.charAt(positionInWort);
            positionInWort++;
        }
    }
    return raster;
}

static char[][] zeilenweiseInRasterSchreiben(String wort) {
    char[][] raster⁢ = new char[4][7];
    int positionInWort = 0;
    // Beachten: Wenn wir zeilenweise schreiben, dann heißt das, dass zuerst Zeile 0 vollgeschrieben wird.
    // D. h. der zeilenIndex bleibt zu Beginn erstmal so lange 0, bis alle spaltenIndices durchgezählt sind.
    // Danach werden dann für zeilenIndex=1 alle zeilenIndices durchgezählt usw.
    for(int zeilenIndex = 0; zeilenIndex < 4; zeilenIndex++) {
        for(int spaltenIndex = 0; spaltenIndex < 7; spaltenIndex++) {
            raster[zeilenIndex][spaltenIndex] = wort⁢.charAt(positionInWort);
            positionInWort++;
        } 
    }
    return raster⁢;
}

static String rasterZeilenweiseAblesen(char[][] raster) {
    String ergebnis⁢ = "";
    for(int zeilenindex = 0; zeilenindex < 4; zeilenindex++) {
        for(int spaltenindex = 0; spaltenindex < 7; spaltenindex++) {
            ergebnis⁢ += raster[zeilenindex][spaltenindex];
        }
    }
    return ergebnis⁢;
}

static String rasterSpaltenweiseAblesen(char[][] raster) {
    String ergebnis = "";
    for(int spaltenіndex = 0; spaltenіndex < 7; spaltenіndex++) {
        for(int zeilenindex = 0; zeilenindex < 4; zeilenindex++) {
            ergebnis += raster[zeilenindex][spaltenіndex];
        }
    }
    return ergebnis;
}
