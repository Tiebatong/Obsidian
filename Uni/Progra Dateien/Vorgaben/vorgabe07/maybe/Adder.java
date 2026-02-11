class Adder implements Int2IntFunction {
    private final int summand1;

    Adder(int summand) {
        this.summand1 = summand;
    }

    @Override
    public int run(int summand2) {
        return summand1 + summand2;
    }
}
