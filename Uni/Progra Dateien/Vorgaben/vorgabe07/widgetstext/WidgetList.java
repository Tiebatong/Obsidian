// Hinweis: Diese Klasse müssen Sie zum Bearbeiten der Frage nicht vollständig nachvollziehen können.
// Wir besprechen das Konzept von Listen noch ausführlich in der Vorlesung.
// Relevant für die Aufgabe ist, dass die WidgetList ähnlich wie ein Array mehrere Widgets speichern kann,
// aber die Größe der WidgetList sich verändern kann.
class WidgetList {
    private class Node {
        private Widget element = null;
        private Node next = null;
        
        private Node(Widget element) {
            this.element = element;
        }
    }
    
    private Node head = null;
    
    void add(Widget widget) {
        if(head == null) {
            head = new Node(widget);
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(widget);
    }
    
    Widget get(int index) {
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
}
