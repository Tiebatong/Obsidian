class SortObjects {
    // Code aus der Vorlesung
    static <T extends Comparable<T>> void sort(T[] objekte) {
        for(int currentIndex = 0; currentIndex < objekte.length; currentIndex++) {
            T currentObjekt = objekte[currentIndex];
            int insertionPosition = currentIndex;
            while(insertionPosition > 0 && objekte[insertionPosition - 1].compareTo(currentObjekt) > 0) {
                objekte[insertionPosition] = objekte[insertionPosition - 1];
                insertionPosition--;
            }
            objekte[insertionPosition] = currentObjekt; 
        }
    }
}
