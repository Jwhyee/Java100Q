package study.factory.factory;

import study.factory.payment.Payment;
import study.factory.payment.PaymentType;

public abstract class PaymentAbstractFactory {
    public abstract Payment getPayment(PaymentType type);
}
