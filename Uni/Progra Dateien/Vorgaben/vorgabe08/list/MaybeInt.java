class MaybeInt {
    private final int value;
    private final boolean hasValue;
    
    private static final MaybeInt EMPTY = new MaybeInt(0, false);
    
    private MaybeInt(int value, boolean hasValue) {
        this.value = value;
        this.hasValue = hasValue;
    }
    
    static MaybeInt of(int value) {
        return new MaybeInt(value, true);
    }
    
    static MaybeInt empty() {
        return EMPTY;
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

    @Override
    public String toString() {
        if(!hasValue) {
            return "[]";
        }
        return "[" + value + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MaybeInt maybeInt)) {
            return false;
        }
        return value == maybeInt.value && hasValue == maybeInt.hasValue;
    }
}
