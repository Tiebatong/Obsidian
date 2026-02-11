class Demo {

    static void main() {
        HashMap noten = new HashMap(5);
        
        System.out.println(noten); // {}
        
        noten.put("Anna", 2);
        noten.put("Peter", 2);
        noten.put("Abdul", 1);
        noten.put("Sophie", 4);
        noten.put("Sophie", 3); // überschreibt den ersten Wert
        // noten.put("Lian", 4); // HashMap wäre voll - hier dürfte beliebiges passieren (bei einer „echten“ HashMap würde die HashMap irgendwie vergrößert werden, vgl. andere Übungsaufgabe)
        
        System.out.println(noten); // {Sophie:3, Anna:2, Peter:2, Abdul:1, }   (Reihenfolge beliebig)
        
        System.out.println(noten.contains("Sophie")); // true
        System.out.println(noten.get("Sophie")); // 3
        System.out.println(noten.contains("Stephanie")); // false
        System.out.println(noten.get("Stephanie")); // java.util.NoSuchElementException
    }

}
