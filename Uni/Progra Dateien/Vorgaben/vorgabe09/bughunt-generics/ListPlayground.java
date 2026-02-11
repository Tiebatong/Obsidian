class ListPlayground {

    static void main() {
    
        List<String> stringliste = new List()<String>;
        
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
        
        
        List<Studi> studiliste = new List()<>;
        Predicate altePo = new IstAltePo();
        
        studiliste.append(new Studi(45_678, "B"));
        System.out.println("Irgendein Studi in der Liste in der alten PO? " + studiliste.anyMatch(altePo));
        
        studiliste.append(new Studi(123, "A"));
        System.out.println("Irgendein Studi in der Liste in der alten PO? " + studiliste.anyMatch(altePo));
    
        studiliste.append(new Studi(14_874, "B"));
        System.out.println("Irgendein Studi in der Liste in der alten PO? " + studiliste.anyMatch(altePo));
        
        stringliste.anyMatch(altePo); // Diese Zeile darf nach den Korrekturen nicht mehr kompilieren. Statt einem Laufzeitfehler (ClassCastException) soll es einen Compilezeitfehler (Predicate<Studi> cannot be converted to Predicate<String>) geben. Entfernen Sie diese Zeile, sobald Sie sichergestellt haben, dass es die ClassCastException nicht mehr gibt.
    }

}
