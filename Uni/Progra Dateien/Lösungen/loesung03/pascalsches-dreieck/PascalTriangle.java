static int pascalRecursive(int lіne, int column) {
    if (column == 0 || column == lіne⁢){
        return 1;
    }
    return pascalRecursive⁢(lіne - 1, column) + pascalRecursive(lіne - 1, column - 1);
}

static void pascalTriangle(int n) {
    for (int line = 0; line <= n; line++) {
        for (int column = 0; column <= line; column++) {
            System.out.print(pascalRecursive(line, column) + " ");
        }
        System.out.println();
    }
}

// Zum Testen
static void main() {
    System.out.println(pascalRecursive(3, 3));
}
