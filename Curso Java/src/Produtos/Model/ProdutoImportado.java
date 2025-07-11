package Produtos.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoImportado extends Produto{
    private BigDecimal customsFee;

    public ProdutoImportado(String name, BigDecimal price, BigDecimal customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public BigDecimal getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(BigDecimal customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag (){
        return getName()
               + " $ "
               + totalPrice().setScale(2, RoundingMode.HALF_UP)
               + " (Customs Fee: $ "
               + customsFee.setScale(2, RoundingMode.HALF_UP)
               + ")" ;
    }

    public BigDecimal totalPrice() {
        return getPrice().add(customsFee);
    }
}
