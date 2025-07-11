package ContratosParcelas.Controller;

import ContratosParcelas.Model.Contract;
import ContratosParcelas.Model.Installment;
import ContratosParcelas.Model.OnlinePaymentService;
import ContratosParcelas.Model.PaypalService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractService {
    public void processContract(Contract contract, Integer months){
        OnlinePaymentService ops = new PaypalService();
        for(int i=1; i<=months; i=+1){
            BigDecimal result = ops.interest(contract.getTotalValue(), i);
            result = ops.paymentFee(result);

            if(i==1){
                Installment installment = new Installment(contract.getDate(), result);
                contract.addInstallment(installment);
            }else{
                LocalDate newDate = contract.getDate().plusMonths(i);
                Installment installment = new Installment(newDate, result);
                contract.addInstallment(installment);
            }
        }
    }
}

