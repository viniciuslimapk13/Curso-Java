package Funcionarios.Model;

import java.math.BigDecimal;

public class Funcionarios {
    private String name;
    private Integer horas;
    private BigDecimal valorPorHora;

    public Funcionarios(String name, Integer horas, BigDecimal valorPorHora) {
        this.name = name;
        this.horas = horas;
        this.valorPorHora = valorPorHora;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public BigDecimal getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(BigDecimal valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public BigDecimal pagamento(){
        BigDecimal pagamento = valorPorHora.multiply(BigDecimal.valueOf(horas));
        return pagamento;
    }
}
