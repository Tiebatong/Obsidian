public class FizzBuzz {

    public static void main(String[] args) {
        // idiomatisch ist die klassische for-Schleife, denn:
        // - wir wissen vor Eintritt der Schleife, wie viele Iterationen es gibt (deshalb keine while-Schleife benutzen)
        // - wir benötigen den Index innerhalb der Schleife und haben auch kein Array o. ä., über das wir iterieren (deshalb keine for-each-Schleife)
        for(int zahl = 1; zahl <= 42; zahl++) {
            if(zahl % 15 == 0) {
                System.out.print("FizzBuzz");
            } else if(zahl % 5 == 0) {
                System.out.print("Buzz");
            } else if(zahl % 3 == 0) {
                System.out.print("Fizz");
            } else {
                System.out.print(zahl);
            }
            System.out.print(",");
        }
    }

}
