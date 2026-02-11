class Studi {

    private static final double TEILZULASSUNG_PROZENTSATZ = .2;
    private static final double GESAMTZULASSUNG_PROZENTSATZ = .5;

    private final String name;
    private final int[] punkteProBlatt;

    Studi(String name, int[] punkteProBlatt) {
        this.name = name;
        this.punkteProBlatt = punkteProBlatt.clone();
    }

    private int punkteTeilI() {
        int punkte = 0;
        for(int i = 0; i < punkteProBlatt.length / 2; i++) {
            punkte += punkteProBlatt[i];
        }
        return punkte;
    }

    private int punkteTeilII() {
        int punkte = 0;
        for(int i = punkteProBlatt.length / 2; i < punkteProBlatt.length; i++) {
            punkte += punkteProBlatt[i];
        }
        return punkte;
    }

    private int gesamtpunktzahl() {
        int punkte = 0;
        for(int punkteAufBlatt: punkteProBlatt) {
            punkte += punkteAufBlatt;
        }
        return punkte;
    }

    private boolean hatZulassungTeilI(double erreichbareGesamtpunktzahl) {
        return punkteTeilI() >= erreichbareGesamtpunktzahl * TEILZULASSUNG_PROZENTSATZ;
    }

    private boolean hatZulassungTeilII(double erreichbareGesamtpunktzahl) {
        return punkteTeilII() >= erreichbareGesamtpunktzahl * TEILZULASSUNG_PROZENTSATZ;
    }

    private boolean hatGesamtzulassung(double erreichbareGesamtpunktzahl) {
        return gesamtpunktzahl() >= erreichbareGesamtpunktzahl * GESAMTZULASSUNG_PROZENTSATZ
                && hatZulassungTeilI(erreichbareGesamtpunktzahl)
                && hatZulassungTeilII(erreichbareGesamtpunktzahl);
    }

    String csvZeile(double erreichbareGesamtpunktzahl) {
        String zeile = "";
        zeile += name;
        zeile += ",";
        zeile += hatZulassungTeilI(erreichbareGesamtpunktzahl);
        zeile += ",";
        zeile += hatZulassungTeilII(erreichbareGesamtpunktzahl);
        zeile += ",";
        zeile += hatGesamtzulassung(erreichbareGesamtpunktzahl);
        return zeile;
    }

}
