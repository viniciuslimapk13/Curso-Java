package Pedido.View;

import Pedido.Model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OrderView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\u001B[1mEnter cliente data:\u001B[0m");
        System.out.print("Name:");
        String name = sc.next();
        System.out.print("Email:");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY):");
        LocalDate birthDate = LocalDate.parse(sc.next(), format);

        System.out.println("\u001B[1mEnter order data:\u001B[0m");
        System.out.print("Status: ");
        String status = sc.next();
        System.out.print("How many items to this order? ");
        Integer x = sc.nextInt();
        Order order = new Order(new Client(name, email, birthDate), OrderStatus.valueOf(status));

        for(int i=1; i<=x; i++){
            System.out.println("\u001B[1mEnter #" + i + " item data:\u001B[0m");
            System.out.print("Product name: ");
            String nameItem = sc.next();
            System.out.print("Product price: ");
            BigDecimal price = sc.nextBigDecimal();
            System.out.print("Quantity: ");
            BigDecimal quantity = sc.nextBigDecimal();
            order.addItem(new OrderItem(quantity,price,new Product(nameItem,price)));
        }

        System.out.println(order.toString());
    }
}
