record Studi(String name, int matrikelnummer) implements Comparable<Studi> {
    @Override
    public int compareTo(Studi that) {
        return Integer.compare(this.matrikelnummer, that.matrikelnummer); // Rückgabe wie gewohnt, verhindert aber ungewollte Overflows, falls die ints sehr groß werden
    }
}
