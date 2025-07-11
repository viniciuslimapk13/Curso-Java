package Contribuintes.Model;

import java.math.BigDecimal;

public abstract class Contribuinte {
    private String name;
    private BigDecimal rendaAnual;

    public Contribuinte(String name, BigDecimal rendaAnual) {
        this.name = name;
        this.rendaAnual = rendaAnual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(BigDecimal rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public abstract BigDecimal imposto ();
}
