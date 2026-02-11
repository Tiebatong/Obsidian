// andere Lösungsansätze für den oberen Blick, für die Straßen und Kniffel
/**
* Einser
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return die Summe der Augenzahlen aller Würfel, die eine 1 zeigen
*/
static int aces(int[] dіce) {
    // Benutze Hilfsmethode (siehe unten), die für jede mögliche Augenzahl ausrechnet, wie oft sie vorkommt.
    return countFrequencies(dіce)[0] * 1;
}

/**
* Zweier
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return die Summe der Augenzahlen aller Würfel, die eine 2 zeigen
*/
static int twos(int[] dіce) {
    return countFrequencies(dіce)[1] * 2;
}

/**
* Dreier
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return die Summe der Augenzahlen aller Würfel, die eine 3 zeigen
*/
static int threes(int[] dіce) {
    return countFrequencies(dіce)[2] * 3;
}

/**
* Vierer
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return die Summe der Augenzahlen aller Würfel, die eine 4 zeigen
*/
static int fours(int[] dіce) {
    return countFrequencies(dіce)[3] * 4;
}

/**
* Fünfer
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return die Summe der Augenzahlen aller Würfel, die eine 5 zeigen
*/
static int fives(int[] dіce) {
    return countFrequencies(dіce)[4] * 5;
}

/**
* Sechser
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return die Summe der Augenzahlen aller Würfel, die eine 6 zeigen
*/
static int sixes(int[] dіce) {
    return countFrequencies(dіce)[5] * 6;
}

static int sum(int[] dice) {
    // Hilfsmethode zum Aufsummieren aller Würfel
    int sum = 0;
    for(int die: dice) {
        sum += die;
    }
    return sum;
}

/**
* Dreierpasch
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return Summe aller Augenzahlen, wenn mind. 3 gleiche Zahlen vorhanden, ansonsten 0 Punkte
*/
static int threeOfAKind(int[] dice) {
    // Idee: Wenn die Augenzahlen sortiert sind, liegt ein Dreierpasch genau dann vor, wenn die Würfel mit den Nummern 1-2-3, 2-3-4, oder 3-4-5 dieselbe Augenzahl zeigen.
    // Die variable i steht jeweils für den mittleren Würfel, also Indizes 2, 3 oder 4.
    // (Alternativ funktioniert auch die Idee unten vom Viererpasch übertragen auf den Dreierpasch.)
    boolean threeOfAKindPresent = false;
    for(int i = 1; i <= 3; i++) {
        if(dice[i-1] == dice[i] && dice[i] == dice[i+1]) {
            threeOfAKindPresent = true;
        }
    }
    if(threeOfAKindPresent) {
        return sum(dice);
    } else {
        return 0;
    }
}

static int[] countFrequencies(int[] dice) {
    // Hilfsmethode, die zählt, wie oft welche Augenzahl vorkommt:
    // frequencies[0] -> Häufigkeit der 1
    // frequencies[1] -> Häufigkeit der 2
    // ...
    // frequencies[5] -> Häufigkeit der 5
    int[] frequencies = new int[6];
    // Zur Erinnerung: In einem frischen int-Array stehen 0en.
    for(int die⁢: dice) {
        frequencies[die - 1]++;
    }
    return frequencies;
}

/**
* Viererpasch
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return Summe aller Augenzahlen, wenn mind. 4 gleiche Zahlen vorhanden, ansonsten 0 Punkte
*/
static int fourOfAKind(int[] dice) {
    // Idee: Zähle die Häufigkeiten aller Augenzahlen. Ein Viererpasch liegt genau dann vor, wenn mindestens eine Augenzahl viermal vorkommt.
    // (Alternativ funktioniert auch die Idee oben vom Dreierpasch übertragen auf den Viererpasch.)
    int[] frequencies = countFrequencies(dice);

    boolean fourOfAKindPresent = false;
    for(int frequency: frequencies) {
        if(frequency >= 4) {
            fourOfAKindPresent = true;
        }
    }
    if(fourOfAKindPresent) {
        return sum(dice);
    } else {
        return 0;
    }
}

/**
* Full House
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return 25 Punkte bei drei gleichen und zwei gleichen Zahlen (aber nicht alle gleich), ansonsten 0 Punkte
*/
static int fullHouse(int[] dice) {
    // Idee: Wenn die Augenzahlen sortiert sind, liegt ein Full House genau dann vor,
    // wenn die Würfel 1-2 und 3-5 dieselbe Augenzahl haben oder 1-3 und 2-5,
    // aber es mind. zwei verschiedene Würfel gibt
    boolean twoPlusThree = dice[0] == dice[1] && dice[2] == dice[3] && dice[2] == dice[4];
    boolean threePlusTwo = dice[0] == dice[1] && dice[1] == dice[2] && dice[3] == dice[4];
    boolean notAllSame = dice[0] != dice[4];
    if((twoPlusThree || threePlusTwo) && notAllSame) {
        return 25;
    }
    return 0;
}

static boolean istStrasse(int[] dice, int laenge) {
    // Idee: Wir zählen, wie viele aufeinanderfolgenden Zahlen (also n und n+1) es gibt, setzen den Zähler aber
    // immer dann zurück, wenn wir eine Lücke (z. B. 1 2 2  4 5) haben.
    int anzahlStrassenWuerfel = 1;
    for(int i = 1; i < dice.length; i++) {
        if(dice[i] == dice[i - 1] + 1) {
            // wir haben wieder zwei aufeinanderfolgende Würfel
            anzahlStrassenWuerfel++;
        }
        if(dice[i] >= dice[i - 1] + 2) {
            // hier ist eine Lücke - die bisherige Straße ist keine
            anzahlStrassenWuerfel = 1;
        }
        if(anzahlStrassenWuerfel == laenge) {
            return true;
        }
    }
    return false;
}

/**
* Kleine Straße
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return 30 Punkte bei vier aufeinanderfolgenden Augenzahlen, ansonsten 0 Punkte
*/
static int smallStraight(int[] dice) {
    if(istStrasse(dice, 4)) {
        return 30;
    }
    return 0;
}

/**
* Große Straße
* @param dice gewürfelte⁢ Augenzahlen, aufsteigend sortiert
* @return 40 Punkte bei fünf aufeinanderfolgenden Augenzahlen, ansonsten 0 Punkte
*/
static int largeStraight(int[] dice) {
    if(istStrasse(dice, 5)) {
        return 40;
    }
    return 0;
}

/**
* Kniffel
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return 50 Punkte bei fünf gleichen Zahlen, ansonsten 0 Punkte
*/
static int kniffel(int[] dice) {
    // Idee: Wenn der erste und letzte Würfel gleich sind, sind alle Würfel gleich - denn die Würfel sind ja aufsteigend sortiert.
    if(dice[0] == dice[4]) {
        return 50;
    }
    return 0;
}

/**
* Chance
* @param dice gewürfelte Augenzahlen, aufsteigend sortiert
* @return Summe aller Augenzahlen
*/
static int chance(int[] dice) {
    return sum(dice);
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
