package Pedido.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    DateTimeFormatter formatMoment = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment = LocalDateTime.now();

    private Client client;
    private OrderStatus status;
    private List<OrderItem> itens = new ArrayList<>();

    public Order(Client client, OrderStatus status) {
        this.client = client;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        itens.add(item);
    }

    public void removeItem(OrderItem item){
        itens.remove(item);
    }

    public BigDecimal total(){
        BigDecimal total = BigDecimal.ZERO;
        for(OrderItem item:itens){
            total = total.add(item.subTotal());
        }
        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nORDER SUMMARY:");
        sb.append("\nOrder moment: ");
        sb.append(getMoment().format(formatMoment));
        sb.append("\nOrder status: ");
        sb.append(getStatus());
        sb.append("\nClient: ");
        sb.append(getClient().toString());
        sb.append("\nOrder items:\n");
         for(OrderItem item:itens){
            sb.append(item.getProduct().getName());
            sb.append(", $");
            sb.append(item.getPrice().setScale(2, RoundingMode.HALF_UP));
            sb.append(", Quantity: ");
            sb.append(item.getQuantity());
            sb.append(", Subtotal: $");
            sb.append(item.subTotal()+"\n");
        }
        sb.append("Total price: $");
        sb.append(total().setScale(2, RoundingMode.HALF_UP));
        return sb.toString();
    }
}
