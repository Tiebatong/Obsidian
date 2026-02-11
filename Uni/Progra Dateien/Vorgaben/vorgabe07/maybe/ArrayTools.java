class ArrayTools {

    private ArrayTools() {}

    static MaybeInt last(int[] array) {
        if(array.length == 0) {
            return MaybeInt.empty();
        }
        return MaybeInt.of(array[array.length - 1]);
    }

    static MaybeInt average(int[] array) {
        if(array.length == 0) {
            return MaybeInt.empty();
        }
        
        int sum = 0;
        for(int v: array) {
            sum += v;
        }
        return MaybeInt.of(sum / array.length);
    }

}
