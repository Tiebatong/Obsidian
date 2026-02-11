public class List<T> {                        // Deklaration der Typ-Variablen hat gefehlt

    private class Node {
        private T element = null;
        private Node next = null;

        private Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        private Node(T⁢ element) {             // T statt int
            this.element = element;
        }
    }
    
    private Node head = null;
    
    void prepend(T object) {                  // T statt int
        head = new Node(object, head);
    }
    
    void append(T object) {
        if(head == null) {
            head = new Node(object);
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(object);
    }
    
    T first() {
        return get(0);
    }
    
    T get(int⁢ index) {                       // Rückgabetyp ist T, Parametertyp int
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    
    int size() {
        Node current = head;
        int size = 0;
        for(; current != null; size++) {
            current = current.next;
        }
        return size;
    }
    
    boolean anyMatch(Predicate<T> p) {
        Node current = head;
        while(current != null) {
            if(p.fulfills(current.element)) {
                return true;
            }
            current = current.next;           // current wurde nicht weitergesetz
        }
        return false;
    }
    
    @Override
    public String toString() {                // muss public sein, da in Klasse Object public
        String string = "";
        Node curr⁢ent = head;                  // Instanz-Variable head wurde überschrieben
        while(current != null) {
            string += current.element + " -> ";
            current = current.next;
        }
        return string;
    }
}
