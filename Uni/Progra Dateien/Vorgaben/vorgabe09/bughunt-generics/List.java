class List {

    private class Node {
        private T element = null;
        private Node next = null;

        private Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        private Node(int element) {
            this.element = element;
        }
    }
    
    private Node head = null;
    
    void prepend(int object) {
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
    
    int get(T index) {
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
        }
        return false;
    }
    
    @Override
    String toString() {
        String string = "";
        while(head != null) {
            string += head.element + " -> ";
            head = head.next;
        }
        return string;
    }
}
