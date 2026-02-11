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
        // Idee ähnlich Insertion Sort: Wir gehen von links nach rechts durch die Liste.
        // Wir fügen jedes Element in eine neue Liste an der richtigen Stelle ein.
        // Am Ende ersetzen wir den Head der Liste, auf der sort() aufgerufen wurde (this),
        // durch den head der neu konstruierten, sortierten Liste.

        LinkedList<T> sorted = new LinkedList<T>();

        Node current = head;
        while(current != null) {
            // current an der richtigen Stelle wieder einfügen
            sorted.sortiertEinfuegen⁢(current.value);
            current = current.next;
        }

        this.head⁢ = sorted.head⁢;
    }
    
    private void sortiertEinfuegen⁢(T wert) {
        if(head == null) {
            head = new Node(wert, null);
            return;
        }
        
        if(wert.compareTo(head.value) < 0) {
            head = new Node(wert, head);
            return;
        }
    
        Node current = this.head;
        while(current.next != null && wert.compareTo(current.next.value) > 0) {
            current = current.next;
        }

        // jetzt gilt: current.next.value > wert und current.value <= wert
        // wir wollen also zwischen current und current.next einfügen

        Node neueNode⁢ = new Node(wert, current.next);
        current.next = neueNode⁢;
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
