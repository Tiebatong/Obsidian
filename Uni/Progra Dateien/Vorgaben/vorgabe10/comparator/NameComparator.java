class NameComparator implements java.util.Comparator<Studi> {
    @Override
    int compare(Studi s1, Studi s2) {
        return s1.name().compareTo(s2.name());
    }
}
