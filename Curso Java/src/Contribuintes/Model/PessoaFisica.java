package Contribuintes.Model;

import java.math.BigDecimal;

public class PessoaFisica extends Contribuinte{
    private BigDecimal saude;

    public PessoaFisica(String name, BigDecimal rendaAnual, BigDecimal saude) {
        super(name, rendaAnual);
        this.saude = saude;
    }

    public BigDecimal getSaude() {
        return saude;
    }

    public void setSaude(BigDecimal saude) {
        this.saude = saude;
    }

    @Override
    public BigDecimal imposto() {
        BigDecimal imposto = BigDecimal.ZERO;
        if(getRendaAnual().compareTo(new BigDecimal(20000))==-1){
            imposto = getRendaAnual().multiply(BigDecimal.valueOf(0.15));
        }else {
            imposto = getRendaAnual().multiply(BigDecimal.valueOf(0.25));
        }
        imposto = imposto.subtract(saude.divide(BigDecimal.valueOf(2)));

        return imposto;
    }

}
