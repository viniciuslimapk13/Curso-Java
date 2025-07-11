package ContratosParcelas.Model;

import java.math.BigDecimal;

public class PaypalService implements OnlinePaymentService{
    public BigDecimal paymentFee (BigDecimal amount){
        BigDecimal result = amount.multiply(new BigDecimal(1.02));
        return result;
    }

    public BigDecimal interest (BigDecimal amount, Integer months){
        BigDecimal result = (amount.multiply(new BigDecimal(1.01))).multiply(new BigDecimal(months));
        return result;
    }

    /*TESTE2*/
}
