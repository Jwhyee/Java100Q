package study.factory.payment;

public class KakaoPayment implements Payment {
    private static final KakaoPayment instance = new KakaoPayment();
    public static KakaoPayment getInstance() {
        return instance;
    }
    private KakaoPayment() {}
}
