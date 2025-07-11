package Pedido.Model;

import java.math.BigDecimal;

public class OrderItem {
    private BigDecimal quantity;
    private BigDecimal price;

    private Product product;

    public OrderItem(BigDecimal quantity, BigDecimal price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal subTotal(){
        return quantity.multiply(price);
    }

}
