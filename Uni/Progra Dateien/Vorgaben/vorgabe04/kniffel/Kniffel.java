// Die Methoden für jede Kategorie erhält eine kurze Erklärung.
// Hinter @param steht, welche Parameter die Methode bekommt. Bei uns ist das immer „gewürfelte Augenzahlen, aufsteigend sortiert“.
// Hinter @return steht, wie der Rückgabewert berechnet werden soll.

/**
 * Einser
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 1 zeigen
 */
static int aces(int[] dice) {
    return -1;
}

/**
 * Zweier
 * Achtung: Multiplikation mit der Augenzahl nicht vergessen: 1 2 2 2 3 gibt 2×3=6 Punkte.
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 2 zeigen
 */
static int twos(int[] dice) {
    return -1;
}

/**
 * Dreier
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 3 zeigen
 */
static int threes(int[] dice) {
    return -1;
}

/**
 * Vierer
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 4 zeigen
 */
static int fours(int[] dice) {
    return -1;
}

/**
 * Fünfer
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 5 zeigen
 */
static int fives(int[] dice) {
    return -1;
}

/**
 * Sechser
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 6 zeigen
 */
static int sixes(int[] dice) {
    return -1;
}

/**
 * Dreierpasch
 * Anmerkung: Jeder Viererpasch ist auch ein Dreierpasch.
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return Summe aller Augenzahlen, wenn mind. 3 gleiche Zahlen vorhanden, ansonsten 0 Punkte
 */
static int threeOfAKind(int[] dice) {
    return -1;
}

/**
 * Viererpasch
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return Summe aller Augenzahlen, wenn mind. 4 gleiche Zahlen vorhanden, ansonsten 0 Punkte
 */
static int fourOfAKind(int[] dice) {
    return -1;
}

/**
 * Full House
 * Anmerkung: Ein Kniffel zählt nicht als Full House.
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 25 Punkte bei drei gleichen und zwei gleichen Zahlen, ansonsten 0 Punkte
 */
static int fullHouse(int[] dice) {
    return -1;
}

/**
 * Kleine Straße
 * Beispiel: Aus den Würfeln 1, 2, 2, 3, 4 lässt sich die kleine Straße 1, 2, 3, 4 bilden.
 * Gegenbsiepiel: Aus den Würfeln 1, 2, 4, 5, 6 und 1, 2, 2, 3, 5 lässt sich keine kleine Straße bauen.
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 30 Punkte, wenn vier (direkt) aufeinanderfolgenden Augenzahlen existieren (die fünfte Augenzahl ist beliebig), ansonsten 0 Punkte
 */
static int smallStraight(int[] dice) {
    return -1;
}

/**
 * Große Straße
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 40 Punkte bei fünf (direkt) aufeinanderfolgenden Augenzahlen, ansonsten 0 Punkte
 */
static int largeStraight(int[] dice) {
    return -1;
}

/**
 * Kniffel
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 50 Punkte bei fünf gleichen Zahlen, ansonsten 0 Punkte
 */
static int kniffel(int[] dice) {
    return -1;
}

/**
 * Chance
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return Summe aller Augenzahlen
 */
static int chance(int[] dice) {
    return -1;
}

static void main() {
    // Ausgabe zum Testen
    
    // gewürfelte Augenzahlen
    // (Sie dürfen die Zahlen zum Testen verändern.)
    int[] dice = {1, 1, 1, 1, 1};
    
    // Array sortieren (machen wir noch später in der Vorlesung)
    Arrays.sort(dice);

    // Ausgaben zum Testen der Methoden
    System.out.println("Einser: " + aces(dice));
    System.out.println("Zweier: " + twos(dice));
    System.out.println("Dreier: " + threes(dice));
    System.out.println("Vierer: " + fours(dice));
    System.out.println("Fünfer: " + fives(dice));
    System.out.println("Sechser: " + sixes(dice));
    System.out.println("Dreierpasch: " + threeOfAKind(dice));
    System.out.println("Viererpasch: " + fourOfAKind(dice));
    System.out.println("Full House: " + fullHouse(dice));
    System.out.println("Kleine Straße: " + smallStraight(dice));
    System.out.println("Große Straße: " + largeStraight(dice));
    System.out.println("Kniffel: " + kniffel(dice));
    System.out.println("Chance: " + chance(dice));
}
