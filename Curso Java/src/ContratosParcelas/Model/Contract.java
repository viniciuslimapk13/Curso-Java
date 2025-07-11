package ContratosParcelas.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private BigDecimal number;
    private LocalDate date;
    private BigDecimal totalValue;

    List<Installment> installments = new ArrayList<>();

    public Contract(BigDecimal number, LocalDate date, BigDecimal totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public void addInstallment(Installment installment){
        this.installments.add(installment);
    }

    public void removeInstallment(Installment installment){
        this.installments.remove(installment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Installment installment:this.installments){
            sb.append(installment.getDate());
            sb.append(" - ");
            sb.append(installment.getAmount());
        }
        String string = "";
        return string;
    }
}
