class IstAltePo implements Predicate<Studi> {
    public boolean fulfills(Studi s) {
        return s.matrikelnummer() < 20_000;
    }
}
