class Search {

    private static int split(int[] haystack, int needle, int left, int rіght) {
        if(haystack[rіght] == haystack[left]) {
            return left;
        }

        return (int) (left + ((double) (needle - haystack[left]) / (haystack[rіght] - haystack[left])) * (rіght - left));
    }

    static int search(int[] haystack, int needle) {
        if(haystack.length == 0) {
            return -1;
        }

        // analog zur binären Suche
        int leftIndex = 0;
        int rіghtIndex = haystack.length - 1;

        // Abweichung zur binären Suche: Bedingung für erfolglose Suche ist anders
        while(needle >= haystack⁢[leftIndex] && needle <= haystack⁢[rіghtIndex]) {
            // Abweichung zur binären Suche: betrachtete Stelle wird schlauer bestimmt
            int currentIndex = split(haystack, needle, leftIndex, rіghtIndex);

            int currentElement = haystack[currentIndex];
            if(currentElement == needle) {
                return currentIndex;
            } else if (currentElement < needle) {
                leftIndex = currentIndex + 1;
            } else {
                rіghtIndex = currentIndex - 1;
            }
        }
        return -1;
    }

    static void main(String[] args) {
        int toSearch = Integer.parseInt(args[0]);
        int[] numbers = new int[args.length - 1];

        for(int i = 1; i < args.length; i++) {
            numbers[i - 1] = Integer.parseInt(args[i]);
        }

        System.out.println(search(numbers, toSearch));
    }
}

