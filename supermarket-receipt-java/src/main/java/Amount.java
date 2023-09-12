public record Amount(int cents) {
    public static final Amount ZERO = new Amount(0);
    public static final Amount ONE = new Amount(1);
}
