class HashMap {
    private record Entry(String key, int value) {
        @Override
        public String toString() {
            return key + ":" + value;
        }
    }

    private final int maxSize;
    private final Entry[] entries;
    
    HashMap(int maxElements) {
        if(maxElements < 0) {
            throw new IllegalArgumentException("illegal capacity %d".formatted(maxElements));
        }
        this.maxSize = maxElements;
        this.entries = new Entry[maxSize];
    }
    
    private int usualIndex(String key) {
        return Math.abs(key.hashCode() % maxSize);
    }
    
    void put(String key, int value) {
        int insertionIndex = usualIndex(key);
        while(entries[insertionIndex] != null && !entries[insertionIndex].key.equals(key)) {
            // lineares Sondieren
            insertionIndex++;
            insertionIndex %= maxSize;
        }
        entries[insertionIndex] = new Entry(key, value);
    }
    
    @Override
    public String toString() {
        String elements = "{";
        for(Entry e: entries) {
            if(e != null) {
                elements += e + ", ";
            }
        }
        return elements + "}";
    }
    
    boolean contains(String key) {
        int index = usualIndex(key);
        while(entries[index] != null && !entries[index].key.equals(key)) {
            // lineares Sondieren
            index++;
            index %= maxSize;
        }
        if(entries[index] == null) {
            return false;
        }
        return true;
    }
    
    int get(String key) {
        int index = usualIndex(key);
        while(entries[index] != null && !entries[index].key.equals(key)) {
            // lineares Sondieren
            index++;
            index %= maxSize;
        }
        if(entries[index] == null) {
            throw new java.util.NoSuchElementException("key %s not present".formatted(key));
        }
        return entries[index].value;
    }

}
