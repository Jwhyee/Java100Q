package study.factory.payment;

public class PaycoPayment implements Payment {
    private static final PaycoPayment instance = new PaycoPayment();
    public static PaycoPayment getInstance() {
        return instance;
    }
    private PaycoPayment() {}
}
