// Vorschau (siehe fragen.md)
// Hier sind einige Techniken verwendet, die wir noch nicht besprochen haben.
// Sie müssen den Code jetzt noch nicht nachvollziehen können!

import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;
import java.util.function.IntPredicate;

class TestVorschau {

    static OptionalInt last(int[] array) {
        if(array.length == 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(array[array.length - 1]);
    }

    static OptionalInt average(int[] array) {
        if (array.length == 0) {
            return OptionalInt.empty();
        }
        int sum = 0;
        for (int v : array) {
            sum += v;
        }
        return OptionalInt.of(sum / array.length);
    }

    static void main() {
        IntUnaryOperator add5 = x -> x + 5;
        IntUnaryOperator square = x -> x * x;
        IntPredicate isPositive = x -> x > 0;

        int[] numbers = {2, 3, 5, 7};
        int[] empty = {};

        System.out.println("===== numbers");

        System.out.println(last(numbers));
        
        OptionalInt avg = average(numbers);
        System.out.println(avg);
        System.out.println(avg.orElse(-1));
        System.out.println(avg.stream().map(add5).findFirst().orElse(-1));

        System.out.println("===== empty");

        System.out.println(last(empty));
        
        OptionalInt avgEmpty = average(empty);
        System.out.println(avgEmpty);
        System.out.println(avgEmpty.orElse(-1));

        System.out.println(avgEmpty.stream().map(add5).findFirst().orElse(-1));

        System.out.println("===== Square");

        System.out.println(avg.stream().map(square).findFirst());
        System.out.println(avgEmpty.stream().map(square).findFirst());

        System.out.println("===== IsPositive");

        System.out.println(avg.stream().anyMatch(isPositive));
        System.out.println(avgEmpty.stream().anyMatch(isPositive));
    }
}
