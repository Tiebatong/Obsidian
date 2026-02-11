static void longestPlateau(int[] arr) {
    if (arr.length < 3) {
        System.out.println("ERROR: Bitte mindestens 3 Zahlen übergeben!");
        return;
    }

    int maxLength = 0;
    int maxStartIndex = -1;

    int i = 1;
    while (i < arr.length - 1) {
        if (arr[i] == arr[i - 1]) {
            i++;
            continue;
        }

        if (arr[i] == arr[i + 1] && arr[i - 1] < arr[i]) {
            int start = i;
            int length = 1;
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                length++;
                i++;
            }

            if (i + 1 < arr.length && arr[i + 1] < arr[i]) {
                if (length > maxLength) {
                    maxLength = length;
                    maxStartIndex = start;
                }
            }
        }
        i++;
    }

    if (maxLength > 0) {
        System.out.println(maxStartIndex + " " + maxLength);
    } else {
        System.out.println("Kein Plateau");
    }
}

// Zum Testen
static void main() {
    longestPlateau(new int[]{3, 5}); // ERROR
    longestPlateau(new int[]{2, 3, 3, 3, 1, 2, 2, 2, 1}); // 1 3
    longestPlateau(new int[]{1, 2, 3, 4, 3, 2, 1}); // 3 1
    longestPlateau(new int[]{1, 2, 3}); // Kein Plateau
}
