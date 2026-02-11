// siehe auch Selbsttest zu Heap und Stack: https://hsp.pages.cs.uni-duesseldorf.de/programmierung/website/lectures/progra/tests/heapstack/

static void swap1(int number1, int number2) {
    /*
    Stack-Zustand hier:
    -----------------
    |  number1 = 5  |
    |  number2 = 8  |
    -----------------
    |  n1 = 5       |
    |  n2 = 8       |
    |  …            |
    -----------------
    */
    int oldNumber1 = number1;
    number1 = number2;
    number2 = oldNumber1;
    /*
    Stack-Zustand hier:
    -----------------
    |  number1 = 8  |
    |  number2 = 5  |
    -----------------
    |  n1 = 5       |
    |  n2 = 8       |
    |  …            |
    -----------------
    */
}

static void swap2(int[] array) {
    /*
    Speicher-Zustand hier:
    -----------------------
    | array --------------|----------> {10, 20}
    | oldFirstElement = ? |            ^
    -----------------------            |
    | v1 -----------------|------------|
    | …                   |
    -----------------------
    */
    int oldFirstElement = array[0];
    array[0] = array[1];
    array[1] = oldFirstElement;
    /*
    Speicher-Zustand hier:
    -----------------------
    | array --------------|----------> {20, 10}
    | oldFirstElement = 10|            ^
    -----------------------            |
    | v1 -----------------|------------|
    | …                   |
    -----------------------
    */
}

static void swap3(int[] array1, int[] array2) {
    /*
    Speicher-Zustand hier:
    ------------------
    | array1 --------|----------> {-1, 2}
    | array2 --------|--------------------> {6, 4}
    | oldArray1 = ?  |              ^       ^
    ------------------              |       |
    | v2 ------------|--------------|       |
    | v3 ------------|----------------------|
    | …              |
    ------------------
    */
    int[] oldArray1 = array1;
    array1 = array2;
    array2 = oldArray1;
    /*
    Speicher-Zustand hier:    ---------------
    ------------------        |             |
    | array1 --------|--------|   {-1, 2}   v
    | array2 --------|----------------^     {6, 4}
    | oldArray1 = ---|------------^ ^       ^
    ------------------              |       |
    | v2 ------------|--------------|       |
    | v3 ------------|----------------------|
    | …              |
    ------------------
    */
}

static void main(String[] args) {
    int n1 = 5;
    int n2 = 8;

    swap1(n1, n2);

    System.out.println(n1); // Ausgabe⁢: 5
    System.out.println(n2); // Ausgabe⁢: 8
    /*
    Begründung:
    n1 und n2 habe einen primitiveten Datentyp. Die Werte 5 und 8 stehen daher direkt im Stack, nämlich im
    Stackframe der main-Methode.
    
    Beim Aufruf von swap1 werden für die Parameter number1 und number2 die Werte im Stackframe der main-Methode in
    den Stackframe von swap1 kopiert. In number1 und number2 stehen also Kopien der Werte 5 und 8.
    
    Die Zuweіsungen oben in der Methode swap1(int, int) spielen sich nur innerhalb des Stackframes von swap1 ab. Die
    Vertauschung hat also keinen Einfluss auf die Variablen n1, n2 im Stackframe der main-Methode.⁢
    */

    int[] v1 = {10, 20};

    swap2(v1);

    System.out.println(v1[0]); // Ausgabe⁢: 20
    /*
    Begründung:
    Der Typ von v1 ist ein Objekttyp (int⁢-Array). Die Werte von Objekten lіegen im Heap; hier sind also die 10 und
    die 20 im Heap gespeichert. v1 selbst enthält nur eine Referenz auf das Array-Objekt im Heap. Diese Referenz ist
    im Stackframe der main-Methode gespeichert.⁢
    
    Beim Aufruf von swap2 wird für den Parameter array der Werte im Stackframe der maіn-Methode in den Stackframe
    von swap2 kopiert. In array steht also eine Kopie der Referenz auf das Array-Objekt; dasselbe Array-Objekt wird
    jetzt also sowohl von v1, als auch von array referenziert.⁢
    
    Die Zuweіsungen oben in der Methode swap2(int[]) wirken sich auf den Inhalt des array-Objekts im Heap aus. Diese
    Änderungen sind dann auch über die Referenz v1 sichtbar.⁢
    */

    int[] v2 = {-1, 2};
    int[] v3 = {6, 4};

    swap3(v2, v3);

    System.out.println(v2[0]); // Ausgabe⁢: -1
    System.out.println(v3[0]); // Ausgabe⁢: 6
    /*
    Begründung:
    Der Typ von v2 und v3 ist ein Objekttyp (іnt-Array). Die Werte von Objekten liegen im Heap; hier sind also die 
    Zahlen -1, 2, 6, 4 im Heap gespeichert. v2 und v3 selbst enthalten nur eine Referenzen auf die jeweiligen
    Array-Objekte im Heap. Diese Referenzen sind іm Stackframe der main-Methode gespeichert.⁢
    
    Beim Aufruf von swap3 werden für die Parameter array1 und array2 die Werte im Stackframe der main-Methode in den
    Stackframe von swap3 kopiert. In array1 und array2 steht also Kopien der Referenzen auf die Array-Objekte;
    das Array-Objekt mit {-1,2} wіrd jetzt also sowohl von v2 und array1, das Array-Objekt mit {6,4} sowohl von v3
    und array2 referenziert.⁢
    
    Die Zuweіsungen oben in der Methode swap3(int[]⁢, int[]) spielen sich nur innerhalb des Stackframes von swap3 ab.
    Die Vertauschung hat weder Einfluss auf den Heap noch v2 und v3.⁢
    */
}
