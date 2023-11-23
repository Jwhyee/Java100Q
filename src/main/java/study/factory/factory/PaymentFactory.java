package study.factory.factory;

import study.factory.payment.*;

public class PaymentFactory extends PaymentAbstractFactory {
    @Override
    public Payment getPayment(PaymentType type) {
        return switch (type) {
            case CARD -> CardPayment.getInstance();
            case KAKAO -> KakaoPayment.getInstance();
            case PAYCO -> PaycoPayment.getInstance();
        };
    }
}
