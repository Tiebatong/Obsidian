class Zulassung {

    private static final String DATEN = """
        Name,Blatt 1,Blatt 2,Blatt 3,Blatt 4,Blatt 5,Blatt 6,Blatt 7,Blatt 8
        Tai Becker,2,10,13,3,4,5,7,18
        Sascha Maier,0,0,0,20,17,20,18,2
        Kim Müller,20,20,18,20,10,0,0,19
        Kari Nguyen-Kim,1,10,15,4,8,0,9,12
        Katara Schmidt,0,0,0,20,17,20,20,20""";

    static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("genau ein Argument erwartet");
            return;
        }

        int gesamtpunktzahl = Integer.parseInt(args[0]);

        Studi studis[] = csvEinlesen(DATEN);

        zulassungenAusgeben(gesamtpunktzahl, studis);
    }

    private static Studi[] csvEinlesen(String dateiinhalt) {
        String[] zeilen = dateiinhalt.split("\n");
        Studi[] studis = new Studi[zeilen.length - 1];
        for(int i = 0; i < studis.length; i++) {
            studis[i] = studiAusZeile(zeilen[i + 1]); // +1, um Header-Zeile zu überspringen
        }
        return studis;
    }

    private static Studi studiAusZeile(String zeile) {
        String[] parts = zeile.split(",");
        String name = parts[0];
        int[] punkte = new int[parts.length - 1];
        for(int i = 0; i < punkte.length; i++) {
            punkte[i] = Integer.parseInt(parts[i + 1]);
        }
        return new Studi(name, punkte);
    }

    private static void zulassungenAusgeben(int gesamtpunktzahl, Studi[] studis) {
        for(Studi studi: studis) {
            System.out.println(studi.csvZeile(gesamtpunktzahl));
        }
    }
}

