package Contribuintes.Model;

import java.math.BigDecimal;

public class PessoaJuridica extends Contribuinte{
    private BigDecimal funcionarios;

    public PessoaJuridica(String name, BigDecimal rendaAnual, BigDecimal funcionarios) {
        super(name, rendaAnual);
        this.funcionarios = funcionarios;
    }

    public BigDecimal getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(BigDecimal funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public BigDecimal imposto() {
        BigDecimal imposto = BigDecimal.ZERO;
        if(funcionarios.compareTo(new BigDecimal(10))<=-1){
            imposto = getRendaAnual().multiply(BigDecimal.valueOf(0.16));
        }else {
            imposto = getRendaAnual().multiply(BigDecimal.valueOf(0.14));
        }

        return imposto;
    }
}
