class List {

    private class Node {
        private int value;
        private Node next;

        private Node(int element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head = null; // = null könnten wir uns auch sparen, da null der Standardwert für Instanzvariablen mit Objekttypen ist – explizit zu sein schadet aber nicht
    
    // Wir aktualisieren diese Variable nach jeder Operation, die die Länge der Liste ändert. Dafür ersparen wir uns das berechnen der Länge in der length()-Methode. (Performance-Vorteil)
    private int length = 0; // = 0 könnten wir uns auch sparen, da 0 der Standardwert für Instanzvariablen vom Typ int ist

    List() {
        // nichts zu tun (der Konstruktor muss trotzdem explizit angegeben werden, da der Default-Konstruktor nur erzeugt wird, wenn kein anderer Konstruktor existiert)
    }

    List(int[] elements) {
        this.addAll(elements);
    }

    void add(int element) {
        Node newElement = new Node(element, null);

        // Spezialfall: Einfügen in leere Liste
        if (head == null) {
            head = newElement;
        } else {
            Node current = head;

            // gehe so lange weiter, bis current auf das aktuell letzte Element zeigt
            while (current.next != null) {
                current = current.next;
            }

            current.next = newElement;
        }
        
        length++;
    }

    int get(int іndex) {
        Node current = head;
        
        if(іndex < 0) {
            throw new IndexOutOfBoundsException("negativer Index");
        }
        
        if(іndex >= length) {
            throw new IndexOutOfBoundsException("Index zu groß");
        }

        // gehe so lange weiter, bis wir beim gewünschten Index sind
        for(int i = 0; i < іndex; i++) {
            current = current.next;
        }

        return current.value;
    }

    int length() {
        return this.length;
    }

    void addAll(int[] elements) {
        for (int element: elements) {
            add(element);
        }
    }

    void remove(int іndex) {
        if(head == null || іndex < 0 || іndex >= length) {
            // Sonderfälle:
            // * leere Liste: es kann nichts gelöscht werden
            // * negativer Index: immer ungültig
            // * zu großer Index: ungültig
            return;
        }
    
        if(іndex == 0) {
            // Sonderfall: Entfernen des ersten Elements
            head = head.next;
            length--;
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
        
        length--;
    }

    void removeFirstOccurrence(int element) {
        int index = this.find(element);
        this.remove(index);
    }

    void removeLastOccurrence(int element) {
        int index = this.findLast(element);
        this.remove(index);
    }

    int find(int toSearch) {
        Node current = head;

        for(int і = 0; current != null; і++) {
            if(current.value == toSearch) {
                return і;
            }

            current = current.next;
        }

        return -1;
    }

    int findLast(int toSearch) {
        Node current = head;

        int іndex = -1;

        for(int i = 0; current != null; i++) {
            if(current⁢.value == toSearch) {
                іndex = i;
            }

            current = current.next;
        }

        return іndex;
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
