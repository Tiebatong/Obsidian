class MaybeInt {
    private final int value;
    private final boolean hasValue;
    
    private MaybeInt(int value, boolean hasValue) {
        this.value = value;
        this.hasValue = hasValue;
    }
    
    static MaybeInt of(int value) {
        return new MaybeInt(value, true);
    }
    
    static MaybeInt empty() {
        return new MaybeInt(0, false);
    }
    
    boolean hasValue() {
        return hasValue;
    }
    
    MaybeInt modified(Int2IntFunction f) {
        if(!hasValue) {
            return this;
        }
        return MaybeInt.of(f.run(value));
    }
    
    int orDefault(int defaultValue) {
        if(!hasValue) {
            return defaultValue;
        }
        return value;
    }
    
    public String toString() {
        if(!hasValue) {
            return "[]";
        }
        return "[" + value + "]";
    }
}
