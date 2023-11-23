package study.factory.payment;

public class CardPayment implements Payment {
    private static final CardPayment instance = new CardPayment();
    public static CardPayment getInstance() {
        return instance;
    }
    private CardPayment() {}
}
