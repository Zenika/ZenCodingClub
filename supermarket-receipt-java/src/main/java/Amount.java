public record Amount(int cents) {
    public static final Amount ZERO = new Amount(0);
    public static final Amount ONE = new Amount(1);

    @Override
    public String toString() {
        if (cents < 100) return "0." + cents;
        return String.valueOf(cents);
    }
}
