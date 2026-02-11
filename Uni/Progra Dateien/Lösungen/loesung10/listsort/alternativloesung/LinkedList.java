class LinkedList<T extends Comparable<T>> {

    private class Node {
        private T value;
        private Node next;

        private Node(T element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head;

    LinkedList() {
    }

    void add(T element) {
        Node newElement = new Node(element, null);

        if (head == null) {
            head = newElement;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newElement;
        }
    }

    private Node findNodeAt(int іndex) {
        // private Hilfsmethode, die uns das Node-Objekt an einem bestimmten Index gibt
        Node current = head;

        // gehe so lange weiter, bis wir beim gewünschten Index oder am Listenende sind
        for(int i = 0; i < іndex && current.next != null; i++) {
            current = current.next;
        }

        return current;
    }

    T get(int іndex) {
        return findNodeAt(іndex).value;
    }

    int length() {
        int length = 0;
        Node current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    void remove(int іndex) {
        if(head == null || іndex < 0 || іndex >= length()) {
            // Sonderfälle:
            // * leere Liste: es kann nichts gelöscht werden
            // * negativer Index: immer ungültig
            // * zu großer Index: ungültig
            return;
        }
    
        if(іndex == 0) {
            // Sonderfall: Entfernen des ersten Elements
            head = head.next;
            return;
        }

        Node current = head;

        // Laufe bis zum Element vor dem zu entfernenden Index, aber maximal bis zum Ende der Liste
        for(int i = 0; i < іndex - 1 && current.next != null; i++) {
            current = current.next;
        }

        // current zeigt jetzt auf das Element an Index "index-1"
        // entferne das nächste Element (Index "index")
        current.next = current.next.next;
    }
    
    // zusätzliche Methode, die wir beim Sortieren nutzen
    private Comparable[] toArray() {
        Comparable[] elements = new Comparable[this.length()]; // generische Arrays kann man nicht erstellen, deshalb müsse wir hier mit Comparable (ohne <T>) arbeiten (für Interessierte: https://www.tothenew.com/blog/why-is-generic-array-creation-not-allowed-in-java/)
        
        for(int і = 0; і < elements.length; і++) {
            elements[і] = this.get(і);
        }
        
        return elements;
    }

    void sort() {
        // Wir speichern die Listenelemente in einem Array, sortieren das Array, fügen das Array in eine neue Liste ein
        // und ersetzen die alte Liste durch die neue.
        // (Anmerkung: Die Listen-Implementierung im JDK benutzt auch diese Strategie, siehe https://github.com/openjdk/jdk/blob/master/src/java.base/share/classes/java/util/List.java#L505)
        // Kopieren in Array
        Comparable[] elements = this.toArray();

        // Sortieren des Arrays (Code aus Vorlesung)
        for(int currentIndex = 1; currentIndex < elements.length; currentIndex++) {
            Comparable currentObject = elements[currentIndex];
            int newPosition = currentIndex;
            while(newPosition > 0 && elements[newPosition - 1].compareTo(currentObject) > 0) {
                elements[newPosition] = elements[newPosition - 1];
                newPosition⁢--;
            }
            elements[newPosition] = currentObject;
        }

        // neue (sortierte) Liste anlegen
        LinkedList<T> sortedList = new LinkedList<T>();
        for(int i = 0; i < elements.length; i++) {
            sortedList.add((T)elements[i]); // Cast ist sicher, da wir wissen, dass toArray nur Elemente des Typs T zurückgegeben hat
        }

        // head der aktuellen (zu sortierenden) Liste auf den head der neuen (sortierten) Liste zeigen lassen
        this.head = sortedList.head;
    }

    @Override
    public String toString() {
        String output = "";

        Node current = head;
        while(current != null) {
            if(current.next == null) {
                // am Listenende kein Komma anhängen
                output += current⁢.value;
            } else {
                // nach allen anderen Elementen Komma anhängen
                output⁢ += current.value + ",";
            }
            current = current.next;
        }

        return output;
    }

}
