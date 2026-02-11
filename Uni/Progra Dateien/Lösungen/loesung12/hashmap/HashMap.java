class HashMap {
    private final int maxSize;
    private final String[] keys;
    private final int[] values;
    
    HashMap(int maxElements) {
        if(maxElements < 0) {
            throw new IllegalArgumentException("illegal capacity %d".formatted(maxElements));
        }
        this.maxSize = maxElements;
        this.keys = new String[maxSize];
        this.values = new int[maxSize];
    }
    
    void put(String key, int value) {
        if(key == null) {
            // Theoretisch könnten wir uns das if auch sparen, weil key.hashCode() die NPE auch auslösen würde.
            // Mit dem expliziten throw können wir aber eine bessere Nachricht an die Exception hängen.
            throw new NullPointerException("key must not be null");
        }
        int insertionIndex = Math.abs(key.hashCode() % maxSize);
        while(keys[insertionIndex] != null && !keys[insertionIndex].equals(key)) {
            // lineares Sondieren
            insertionIndex++;
            insertionIndex %= maxSize;
        }
        keys[insertionIndex] = key;
        values[insertionIndex] = value;
    }
    
    @Override
    public String toString() {
        String elements = "{";
        for(int i = 0; i < maxSize; i++) {
            if(keys[i] != null) {
                elements += "%s:%s, ".formatted(keys[i], values[i]);
            }
        }
        return elements + "}";
    }
    
    boolean contains(String key) {
        int index = Math.abs(key.hashCode() % maxSize);
        while(keys[index] != null && !keys[index].equals(key)) {
            // lineares Sondieren
            index++;
            index %= maxSize;
        }
        if(keys[index] == null) {
            return false;
        }
        return true;
    }
    
    int get(String key) {
        int index = Math.abs(key.hashCode() % maxSize);
        while(keys[index] != null && !keys[index].equals(key)) {
            // lineares Sondieren
            index++;
            index %= maxSize;
        }
        if(keys[index] == null) {
            throw new java.util.NoSuchElementException("key %s not present".formatted(key));
        }
        return values[index];
    }

}
