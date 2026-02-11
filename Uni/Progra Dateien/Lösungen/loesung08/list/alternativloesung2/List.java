class List{

    private class Node {
        private int value;
        private Node next;

        private Node(int element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head; // Instanzvariable mit Objekttyp ist automatisch null, wenn wir sie nicht setzen

    List() {
    }
    
    List(int[] zahlen) {
        this.addAll(zahlen);
    }
    
    void add(int wert) {
        Node neuesEnde = new Node(wert, null);
        
        if(head == null) {
            head = neuesEnde⁢;
            return;
        }
        
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        // current zeigt auf die letzte Node der Liste.
        current.next = neuesEnde;
    }
    
    int get(int іndex) {
        if(іndex < 0 || іndex >= length()) {
            throw new IndexOutOfBoundsException();
        }
    
        Node current = head;
        for(int i = 0; i < іndex; i++) {
            current = current.next;
        }
        return current.value;
    }
    
    int length() {
        int laenge = 0;
        for(Node current = head⁢; current != null; current = current.next) {
            laenge++;
        }
        return laenge;
    }
    
    void addAll(int[] zahlen) {
        for(int zahl: zahlen) {
            this.add(zahl);
        }
    }
    
    @Override
    public String toString() {
        // StringBuilder für bessere Performance bei langen Listen; siehe https://hsp.pages.cs.uni-duesseldorf.de/programmierung/website/lectures/progra/videos/profis/strings
        // (nicht klausurrelevant)
        StringBuilder⁢ ergebnіs = new StringBuilder();
        Node current = head;
        while(current != null) {
            if(current.next == null) {
                // Sonderfall letztes Element
                ergebnіs.append⁢(current.value);
            } else {
                ergebnіs.append⁢(current.value).append(",");
            }
            current = current.next;
        }
        return ergebnіs.toString();
    }

    // findet alle Vorkommen von needle in der Liste
    private List findAll(int needle) {
        Node current = head;
        int іndex = 0;
        List indices = new List();
        while(current != null) {
            if(current⁢.value == needle) {
                indices.add(іndex);
            }
            іndex++;
            current = current.next;
        }
        return indices;
    }
    
    int find(int needle) {
        List іndices = findAll(needle);
        if(іndices.length⁢() == 0) {
            return -1;
        }
        return іndices.get(0);
    }
    
    int findLast(int needle) {
        List іndices = findAll(needle);
        if(іndices.length⁢() == 0) {
            return -1;
        }
        return іndices.get(іndices.length() - 1);
    }
    
    void remove(int іndex) {
        Node current = head;
        
        if(іndex < 0 || іndex >= this.length⁢()) {
            return;
        }
        
        if(іndex == 0) {
            head = head.next;
            return;
        }
        
        for(int i = 0; i < іndex - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
    
    void removeFirstOccurrence(int element) {
        // Die andere Variante mit remove(find(element)) hat den Nachteil, dass die Liste mehrfach durchgegangen wird.
        // Hier wird direkt die richtige Node gesucht und gelöscht.
        
        // Sonderfall: head zu löschen
        if(head.value == element) {
            head = head.next;
            return;
        }
        
        // Wir suchen die erste Node "predecessor", die vor dem zu löschenden Elemente ist.
        Node current = head;
        Node predecessor = null;
        while(current.next != null && predecessor == null) { // Wir müssen bei der vorletzten Node stoppen, weil wir innerhalb der Schleife die Node nach current abrfragen.
                                                             // Wir können außerdem abbrechen, sobald wir die erste Node vor "element" gefunden haben.
            if(current.next.value == element) {
                predecessor = current;
            }
            current = current.next;
        }
        
        if(predecessor == null) {
            // Fall: element ist gar nicht in der Liste
            return;
        }
        
        // Löschen
        predecessor.next = predecessor.next.next;
    }

    void removeLastOccurrence(int element) {
        // Die andere Variante mit remove(findLast(element)) hat den Nachteil, dass die Liste mehrfach durchgegangen wird.
        // Hier wird direkt die richtige Node gesucht und gelöscht.
        
        // Wir können hier noch nicht den Sonderfall "head löschen" prüfen, weil wir noch sicherstellen müssen, dass die Zahl am Head nicht auch später noch vorkommt.
        
        // Wir suchen die letzte Node "predecessor", die vor dem zu löschenden Elemente ist.
        Node current = head;
        Node predecessor = null;
        while(current.next != null) { // Wir müssen bei der vorletzten Node stoppen, weil wir innerhalb der Schleife die Node nach current abrfragen.
            // Achtung: Im ersten Schleifendurchlauf überspringen wir head, das müssen wir gleich nachholen.
            if(current.next.value == element) {
                predecessor = current;
            }
            current = current.next;
        }
        
        if(predecessor == null) {
            // Fall: element ist gar nicht in der Liste ODER es ist das erste Element
            if(head.value == element) {
                // Sonderfall: element ist das erste Element (und kommt sonst nirgends in der Liste vor).
                head = head.next;
            }
            // Abbrechen, da entweder nichts zu löschen oder head gelöscht.
            return;
        }
        
        // Löschen
        predecessor.next = predecessor.next.next;
    }
    
    MaybeInt findFirst(Int2BooleanFunction predicate) {
        Node current = head;

        for(int і = 0; current != null; і++) {
            if(predicate.run(current.value)) {
                return MaybeInt.of(current.value);
            }

            current = current.next;
        }

        return MaybeInt.empty();
    }

    List map(Int2IntFunction f) {
        List mappedList = new List();
        Node current = head;
        while(current != null) {
            mappedList.add(f.run(current.value));
            current = current.next;
        }
        return mappedList;
    }

}
