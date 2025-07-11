package Produtos.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoUsado extends Produto{
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate manufatureDate;

    public ProdutoUsado(String name, BigDecimal price, LocalDate manufatureDate) {
        super(name, price);
        this.manufatureDate = manufatureDate;
    }

    public LocalDate getManufatureDate() {
        return manufatureDate;
    }

    public void setManufatureDate(LocalDate manufatureDate) {
        this.manufatureDate = manufatureDate;
    }

    @Override
    public String priceTag (){
        return getName()
               + " (Used) $ "
               + getPrice().setScale(2, RoundingMode.HALF_UP)
               + " (Manufature date: "
               + manufatureDate.format(format)
               + ")";
    }
}
