class WordCounter {
    static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("genau ein Argument erwartet");
            return;
        }
    
        String[] words = args[0].split(" ");
        
        System.out.println(count(words)); // wenn mit Argument "to be or not to be" aufgerufen, sollte hier "{to:2, be:2, or:1, not:1, }" (beliebige Reihenfolge) ausgegeben werden
    }
    
    private static HashMap count(String[] words) {
        HashMap counter = new HashMap(words.length + 1); // +1 garantiert, dass wir in der HashMap mind. 1 Platz mehr haben als Wörter in der Eingabe
    
        for(String word: words) {
            if(counter.contains(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        
        return counter;
    }
}
