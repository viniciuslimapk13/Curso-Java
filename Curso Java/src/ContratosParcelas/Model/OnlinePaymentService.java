package ContratosParcelas.Model;

import java.math.BigDecimal;

public interface OnlinePaymentService {
    BigDecimal paymentFee(BigDecimal amount);
    BigDecimal interest(BigDecimal amount, Integer months);
}
