class ListPlayground {

    static void main() {
    
        List<String> stringliste = new List<String>(); // Reihenfolge der Klammern war falsch (Typparameter gehören zum Datentyp)
        
        stringliste.append("Welt");
        stringliste.append("!");
        stringliste.prepend("Hallo");
        
        
        System.out.println("Die Länge der Liste ist: " + stringliste.size());
        String erstesElement = stringliste.first();
        System.out.println("Das erste Element ist: " + erstesElement);
        System.out.println("Das Element mit Index 2 ist: " + stringliste.get(2));
        System.out.println("Das letzte Element ist: " + stringliste.get(stringliste.size() - 1));
        System.out.println("Die gesamte Liste ist: " + stringliste.toString());
        System.out.println("Und nochmal die ganze Liste: " + stringliste.toString());
        
        
        List<Studi> studiliste = new List<>();         // Reihenfolge der Klammern war falsch
        Predicate<Studi> altePo = new IstAltePo();     // <Studi> hat gefehlt (Anmerkung, nicht klausrrelevant: Das kompiliert trotzdem, die Typsicherheit zur Laufzeit geht dann aber verloren, siehe ganz unten.)
        
        studiliste.append(new Studi(45_678, "B"));
        System.out.println("Irgendein Studi in der Liste in der alten PO? " + studiliste.anyMatch(altePo));
        
        studiliste.append(new Studi(123, "A"));
        System.out.println("Irgendein Studi in der Liste in der alten PO? " + studiliste.anyMatch(altePo));
    
        studiliste.append(new Studi(14_874, "B"));
        System.out.println("Irgendein Studi in der Liste in der alten PO? " + studiliste.anyMatch(altePo));
        
        // stringliste.anyMatch(altePo); // Die Zeile crasht, wenn oben <Studi> weggelassen wird.
    }

}
