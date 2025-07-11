package Funcionarios.Model;

import java.math.BigDecimal;

public class FuncionariosTerceirizados extends Funcionarios{
    private BigDecimal adicional;

    public FuncionariosTerceirizados(String name, Integer horas, BigDecimal valorPorHora, BigDecimal adicional) {
        super(name, horas, valorPorHora);
        this.adicional = adicional;
    }

    public BigDecimal getAdicional() {
        return adicional;
    }

    public void setAdicional(BigDecimal adicional) {
        this.adicional = adicional;
    }

    @Override
    public BigDecimal pagamento(){
        return super.pagamento().add(adicional.multiply(new BigDecimal(1.1)));
    }
}
