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

    private Node findNodeAt(int index) {
        // private Hilfsmethode, die uns das Node-Objekt an einem bestimmten Index gibt
        Node current = head;

        // gehe so lange weiter, bis wir beim gewünschten Index oder am Listenende sind
        for(int i = 0; i < index && current.next != null; i++) {
            current = current.next;
        }

        return current;
    }

    T get(int index) {
        return findNodeAt(index).value;
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

    void remove(int index) {
        if(head == null || index < 0 || index >= length()) {
            // Sonderfälle:
            // * leere Liste: es kann nichts gelöscht werden
            // * negativer Index: immer ungültig
            // * zu großer Index: ungültig
            return;
        }
    
        if(index == 0) {
            // Sonderfall: Entfernen des ersten Elements
            head = head.next;
            return;
        }

        Node current = head;

        // Laufe bis zum Element vor dem zu entfernenden Index, aber maximal bis zum Ende der Liste
        for(int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }

        // current zeigt jetzt auf das Element an Index "index-1"
        // entferne das nächste Element (Index "index")
        current.next = current.next.next;
    }

    @Override
    public String toString() {
        String output = "";

        Node current = head;
        while(current != null) {
            if(current.next == null) {
                // am Listenende kein Komma anhängen
                output += current.value;
            } else {
                // nach allen anderen Elementen Komma anhängen
                output += current.value + ",";
            }
            current = current.next;
        }

        return output;
    }

}
