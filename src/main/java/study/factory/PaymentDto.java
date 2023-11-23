package study.factory;

import study.factory.payment.PaymentType;

public class PaymentDto {
    private final PaymentType type;

    public PaymentDto(PaymentType type) {
        this.type = type;
    }
    public PaymentType getType() {
        return type;
    }
}
