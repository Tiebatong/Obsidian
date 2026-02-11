static boolean intToBoolean(int i) {
    // TODO
    return false;
}

static boolean f(boolean x1, boolean x2, boolean x3) {
    // TODO
    return false;
}

static void wahrheitstabelle() {
    System.out.println(" x1 | x2 | x3 || f(x1,x2,x3)");
    System.out.println("----------------------------");
    
    for(int x1 = 0; x1 <= 1; x1++) {
        for(int x2 = 0; x2 <= 1; x2++) {
            for(int x3 = 0; x3 <= 1; x3++) {
                boolean funktionswert = f(intToBoolean(x1), intToBoolean(x2), intToBoolean(x3));
                int funktionswertInt = funktionswert ? 1 : 0;
                System.out.println("  " + x1 + " |  " + x2 + " |  " + x3 + " || " + funktionswertInt);
            }
        }
    }
}

static void main() {
    wahrheitstabelle();
}
