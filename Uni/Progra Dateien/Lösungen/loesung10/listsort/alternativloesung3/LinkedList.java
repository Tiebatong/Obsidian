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

    void sort() {
        // Mergesort
        // Code wie in Vorlesung, mit folgenden Änderungen:
        // - Statt statischer Methoden haben wir Objektmethoden, sodass wir die zu sortierende Liste (this) nicht explizt als Parameter herumreichen müssen.
        // - Alle lesenden Zugriffe (array[i]) werden durch Aufrufe der get-Methode ersetzt (this.get(i)).
        // - Alle schreibenden Zugriffe (array[i] = x) werden durch Aufrufe einer set-Methode (siehe unten) ersetzt (this.set(i, x)).
        this.mergesort(0, this.length());
    }
    
    private void mergesort(int startIndex, int endIndex) {
        int size = endIndex - startIndex;
        if(size <= 1) {
            return;
        }
        
        int middleIndex = startIndex + size / 2;
        mergesort(startIndex, middleIndex);
        mergesort(middleIndex, endIndex);
        
        merge(startIndex, middleIndex, endIndex);
    }
    
    private void merge(int start, int middle, int end) {
        int indexA = start;
        int indexB = middle;
        LinkedList<T> merged = new LinkedList<T>(); // hier könnten wir auch ein Array verwenden, mit der Liste sparen wir uns aber mergeIndex mitzuzählen (dafür ist die for-Schleife am Ende aber langsamer, so wie sie jetzt programmiert ist)
        
        while(indexA < middle || indexB < end) {
            if(indexA == middle) {
                merged.add(this.get(indexB));
                indexB++;
            } else if(indexB == end) {
                merged.add(this.get(indexA));
                indexA++;
            } else if(this.get(indexB).compareTo(this.get(indexA)) <= 0) {
                merged.add(this.get(indexB));
                indexB++;
            } else if(this.get(indexA).compareTo(this.get(indexB)) <= 0) {
                merged.add(this.get(indexA));
                indexA++;
            }
        }
        
        for(int i = 0; i < merged.length(); i++) {
            this.set(start + i, merged.get(i));
        }
    }
    
    // setzt den Wert am gegeben Index auf den gegebenen Wert
    private void set(int index, T newValue) {
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = newValue;
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
