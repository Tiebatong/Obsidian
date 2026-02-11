class Test {
    static void main() {
        Int2IntFunction add5 = new Adder(5);
        
        int[] numbers = {2, 3, 5, 7};
        int[] empty = {};
        
        System.out.println("===== numbers");
        
        System.out.println(ArrayTools.last(numbers));
        
        MaybeInt avg = ArrayTools.average(numbers);
        System.out.println(avg);
        System.out.println(avg.orDefault(-1));
        System.out.println(avg.modified(add5).orDefault(-1));
        
        System.out.println("===== empty");
        
        System.out.println(ArrayTools.last(empty));
        
        MaybeInt avgEmpty = ArrayTools.average(empty);
        System.out.println(avgEmpty);
        System.out.println(avgEmpty.orDefault(-1));
        System.out.println(avgEmpty.modified(add5).orDefault(-1));
        
        // für die 1. Code-Aufgabe
        // System.out.println("===== Square");
        // Int2IntFunction square = new Square();
        // System.out.println(avg.modified(square)); // [16]
        // System.out.println(avgEmpty.modified(square)); // []
        
        // für die 2. Code-Aufgabe
        // System.out.println("===== IsPositive");
        // System.out.println(avg.fulfills(new IsPositive())); // true
        // System.out.println(avgEmpty.fulfills(new IsPositive())); // false
    }
}
