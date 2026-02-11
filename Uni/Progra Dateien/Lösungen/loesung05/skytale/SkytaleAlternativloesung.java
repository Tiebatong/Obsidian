/*
Im Gegensatz zur ersten Lösung wird hier nicht die im Tipp vorgeschlagene Methodenaufteilung verwendet.
Stattdessen wird genutzt, dass Entschlüsseln quasi um 90° gedrehtes Verschlüsseln ist.
*/

/**
 * "Wickelt" die Nachricht um den Stab, wo auf dem Übungsblatt abgebildet.
 * Das 2D-Array entspricht der abgebildeten Buchstaben-Matrix.
 * @param n Anzahl Zeilen
 * @param m Anzahl Spalten
 */
static char[][] wrap⁢(String message⁢, int n, int m) {
    char[][] secret = new char[n][m];
    // Position des aktuell betrachteten Zeichens im String
    int positionInString = 0;
    // Wir müssen das char-Array Zeile für Zeile mit den Zeichen der Nachricht füllen.
    for (int rowIndex = 0; rowIndex < n; rowIndex++) {
        for (int columnIndex = 0; columnIndex < m; columnIndex++) {
            if (positionInString < message.length()) {
                // wenn wir im String sind: Character an der entsprechenden Stelle speichern
                secret[rowIndex][columnIndex] = message.charAt(positionInString);
                positionInString++;
            } else {
                // wenn wir das Ende des Strings erreicht haben, aber noch nicht alle Array-Felder befüllt:
                // Speichere ein Leerzeichen.
                secret[rowIndex][columnIndex] = ' ';
            }
        }
    }
    return secret;
}

static String encrypt(String secretMessage) {
    // Zuerst muss die Nachricht um den Stab gewickelt werden.
    char[][] skytale = wrap(secretMessage, 4, 7);
    // Dann können wir spaltenweise die verschlüsselte Nachricht lesen.
    return readColumns(skytale);
}

/**
 * Hilfsmethode zum spaltenweise Ablesen des "Stabs".
 */
static String readColumns(char[][] skytale⁢) {
    // Wir gehen Spalte für Spalte die Einträge im 2D-Array ab und speichern die Buchstaben in dieser Reihenfolge in einem String.
    String encryptedSecret = "";
    for (int columnIndex = 0; columnIndex < skytale[0].length; columnIndex++) {
        for (int rowIndex = 0; rowIndex < skytale.length; rowIndex++) {
            encryptedSecret += skytale[rowIndex][columnIndex];
        }
    }
    return encryptedSecret;
}

static String decrypt⁢(String encryptedMessage) {
    // Da wir die verschlüsselte Nachricht bekommen haben, müssen wir gedanklich den Stab um 90° drehen, also die Rollen von Zeilen und Spalten ggü. dem Verschlüsseln vertauschen.
    char[][] skytale = wrap(encryptedMessage, 7, 4);
    // Dann können wir spaltenweise die entschlüsselte Nachricht lesen. (Skizze machen!)
    return readColumns(skytale);
}

/**
 * Ausgabe ist abhängig davon, ob das erste Argument -E oder -D ist
 */
static void main(String[] args) {
    if (args.length != 2) {
        System.out.println("ERROR:⁢ genau zwei Argumente erwartet");
        return;
    }
    // Argument für Modus prüfen
    String mode = args[0];
    if (!(mode.equals("D") || mode.equals("E"))) {
        System.out.println("ERROR:⁢ " + mode + " ist ein ungültiges Argument");
        return;
    }
    String message = args[1];
    if (message.length() != 28) {
        System.out.println("ERROR:⁢ Nachrichtenlänge falsch");
        return;
    }
    // Abhängig vom Modus entschlüsseln oder verschlüsseln
    if (mode.equals("E")) {
        System.out.println(encrypt(message));
    } else {
        System.out.println(decrypt(message));
    }
}
