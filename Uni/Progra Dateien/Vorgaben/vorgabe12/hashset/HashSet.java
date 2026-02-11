import java.util.List;
import java.util.LinkedList;

class HashSet {

    private static final int MAX_SIZE = 50;
    @SuppressWarnings("unchecked") // Wir haben unter Kontrolle, dass der raw type auf der rechten Seite passt; das benutzen wir hier nur, weil Arrays nicht mit Generics funktionieren (für Interessierte: https://www.tothenew.com/blog/why-is-generic-array-creation-not-allowed-in-java/)
    // Für die Bearbeitung der Aufgabe können Sie dieses Detail ignorieren.
    private final List<String>[] elements = new LinkedList[MAX_SIZE];
    private int size = 0;
    
    private static int indexFor(String value) {
        return Math.abs(value.hashCode() % MAX_SIZE);
    }
    
    void insert(String newValue) {
        int insertionIndex = indexFor(newValue);
        if(elements[insertionIndex] == null) {
            elements[insertionIndex] = new LinkedList<String>();
        }
        if(!elements[insertionIndex].contains(newValue)) {
            elements[insertionIndex].add(newValue);
            size++;
        }
    }
    
    @Override
    public String toString() {
        String output = "{";
        for(List<String> list: elements) {
            if(list != null) {
                for(String s: list) {
                    output += s + ", ";
                }
            }
        }
        return output + "}, size " + size;
    }
    
    boolean contains(String needle) {
        int index = indexFor(needle);
        if(elements[index] == null) {
            return false;
        }
        return elements[index].contains(needle);
    }
    
    int size() {
        return size;
    }

}
