static void swap1(int number1, int number2) {
    int oldNumber1 = number1;
    number1 = number2;
    number2 = oldNumber1;
}

static void swap2(int[] array) {
    int oldFirstElement = array[0];
    array[0] = array[1];
    array[1] = oldFirstElement;
}

static void swap3(int[] array1, int[] array2) {
    int[] oldArray1 = array1;
    array1 = array2;
    array2 = oldArray1;
}

static void main() {
    int n1 = 5;
    int n2 = 8;

    swap1(n1, n2);

    System.out.println(n1); // Ausgabe:
    System.out.println(n2); // Ausgabe:
    /*
    Begründung:


        */

    int[] v1 = {10, 20};

    swap2(v1);

    System.out.println(v1[0]); // Ausgabe:
    /*
    Begründung:


        */

    int[] v2 = {-1, 2};
    int[] v3 = {6, 4};

    swap3(v2, v3);

    System.out.println(v2[0]); // Ausgabe:
    System.out.println(v3[0]); // Ausgabe:
    /*
    Begründung:


        */
}
