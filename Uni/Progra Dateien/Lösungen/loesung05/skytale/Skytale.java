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
    for(int i = 0; i < wort⁢.length(); i++) {
        raster[i%4][i/4] = wort⁢.charAt(i);
    }
    return raster;
}

static char[][] zeilenweiseInRasterSchreiben(String wort) {
    char[][] raster⁢ = new char[4][7];
    for(int i = 0; i < wort.length(); i++) {
        raster⁢[i/7][i%7] = wort.charAt(i);
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
