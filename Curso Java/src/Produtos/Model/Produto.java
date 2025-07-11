package Produtos.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {
    private String name;
    private BigDecimal price;

    public Produto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String priceTag (){
        return name
               + " $ "
               + price.setScale(2, RoundingMode.HALF_UP);
    }
}
