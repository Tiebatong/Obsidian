static boolean intToBoolean(int i) {
    if(i == 0) {
        return false;
    }
    return true;
    // Alternativ auch:
    // return i != 0;
}

static boolean f(boolean x1, boolean x2, boolean x3) {
    return (!x1 && x2 && x3) || (x1 && !x2 && x3) || (x1 && x2 && !x3) || (x1 && x2 && x3);
}

static void wahrheitstabelle() {
    System.out.println(" x1 | x2 | x3 || f(x1,x2,x3)");
    System.out.println("----------------------------");
    
    for(int x1 = 0; x1 <= 1; x1++) {
        for(int x2 = 0; x2 <= 1; x2++) {
            for(int x3 = 0; x3 <= 1; x3++) {
                boolean funktionswert = f(intToBoolean(x1), intToBoolean(x2), intToBoolean(x3));
                int funktionswertInt = funktionswert ? 1 : 0; // könnte man besser auch in eine Methode booleanToInt auslagern, wir wollten aber nochmal den ternären Operator zeigen
                System.out.println("  " + x1 + " |  " + x2 + " |  " + x3 + " || " + funktionswertInt);
            }
        }
    }
}

static void main() {
    wahrheitstabelle();
}
