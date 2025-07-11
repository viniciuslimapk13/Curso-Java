package Produtos.View;

import Produtos.Model.Produto;
import Produtos.Model.ProdutoImportado;
import Produtos.Model.ProdutoUsado;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        List<Produto> produtos = new ArrayList<>();

        for(int i=1; i<=n; i++){
            System.out.println("\u001B[1mProduct #" + i + " data:\u001B[0m");
            System.out.print("Common, used or imported (c/u/i)? ");
            String cui = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            BigDecimal price = sc.nextBigDecimal();

            if(cui.equals("i")){
                System.out.print("Customs Fee: ");
                BigDecimal customsFee = sc.nextBigDecimal();
                produtos.add(new ProdutoImportado(name, price, customsFee));
            } else if (cui.equals("u")) {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), format);
                produtos.add(new ProdutoUsado(name, price, date));
            } else {
                produtos.add(new Produto(name, price));
            }
        }

        System.out.println("\n PRICE TAGS:");
        for(Produto produto:produtos){
            System.out.println(produto.priceTag());
        }

    }
}
