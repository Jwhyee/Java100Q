package study.factory;

import study.factory.factory.PaymentFactory;
import study.factory.payment.Payment;
import study.factory.payment.PaymentType;

public class PaymentTest {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new PaymentFactory();

        PaymentDto dto = new PaymentDto(PaymentType.KAKAO);

        Payment p = paymentFactory.getPayment(dto.getType());

        System.out.println(p.getClass().getSimpleName());
    }
}
