static void main(String[] args) {
    if(args.length < 1) {
        System.out.println("ERROR:⁢ Bitte mindestens eine Zahl als Argument übergeben!");
        return;
    }
    
    // Lagere Teilprobleme in einzelne Methoden aus. Dadurch ist die Lesbarkeit erhöht und in der main-Methode
    // steht nur „high-level“ Code – wir beschäftigen hier uns nicht mit Array-Details (später im Programmierpraktikum:
    // „Single Layer of Abstraction Principle“).
    // Wir haben hier aber Lesbarkeit gegen Performance getradet: Der Code geht jetzt mehrfach über das Eingabearray.
    // Für die erwartbaren Eingabegrößen kann uns das hier aber egal sein. Bei einer echten Datenauswertung von sehr,
    // sehr vielen Messwerten müssten wir aber besser auf die Geschwindigkeit aufpassen. (Wir werden später aber noch eine
    // andere Möglichkeit kennenlernen, mit der wir nicht selbst Statistiken wie Minimum und Maximum ausrechnen müssen.)

    int[] numbers = parseInt(args);
    
    System.out.println(min(numbers));
    System.out.println(max(numbers));
}

static int[] parseInt(String[] stringArray) {
    int[] intArray = new int[stringArray.length];
    for(int i = 0; i < intArray.length; i++) {
        intArray[i] = Integer.parseInt(stringArray[i]);
    }
    return intArray;
}

static int min(int[] numbers) {
    int min = numbers[0];
    for(int number: numbers) {
        if(number < min) {
            min = number;
        }
    }
    return min;
}

static int max(int[] numbers) {
    int max = numbers[0];
    for(int number: numbers) {
        if(number > max) {
            max = number;
        }
    }
    return max;
}
