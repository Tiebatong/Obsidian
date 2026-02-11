class List {
    private class Node {
        private int value;
        private Node next;

        private Node(int element, Node next) {
            this.value = element;
            this.next = next;
        }
    }

    private Node head;

    List() {
        // Wir könnten uns folgende Zeile auch sparen, da Instanzvariablen mit Referenz-Typen automatisch mit null initalisiert werden.
        head = null;
    }

    List(int[] elements) {
        // Füge die Elemente hinzu
        addAll(elements);
    }

    void add(int element) {
        Node newElement = new Node(element, null);

        if (head == null) {
            // Spezialfall: Einfügen in leere Liste
            head = newElement;
        } else {
            Node current = head;

            // gehe so lange weiter, bis current auf das aktuell letzte Element zeigt
            while (current.next != null) {
                current = current.next;
            }

            current.next = newElement;
        }
    }

    int get(int іndex) {
        if(іndex < 0) {
            throw new IndexOutOfBoundsException("negativer Index " + іndex);
        }
    
        Node current = head;

        // gehe so lange weiter, bis wir beim gewünschten Index oder am Listenende sind
        for(int i = 0; i < іndex && current != null; i++) {
            current = current.next;
        }
        
        if(current == null) {
            throw new IndexOutOfBoundsException("Index zu groß: " + іndex);
        }
        
        return current.value;
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

    void addAll(int[] elements) {
        for (int element: elements) {
            add(element);
        }
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

    void removeFirstOccurrence(int element) {
        remove(find(element));
    }

    void removeLastOccurrence(int element) {
        remove(findLast(element));
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
        while(current != null) {
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
            int mappedValue = f.run(current.value);
            mappedList.add(mappedValue);
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
