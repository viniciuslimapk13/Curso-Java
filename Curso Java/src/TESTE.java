import Produtos.Model.ProdutoUsado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TESTE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        System.out.print("Birth date (DD/MM/YYYY):");
//        LocalDate birthDate = LocalDate.parse(sc.next(), format);
//        System.out.println(birthDate.format(format));

        System.out.print("Manufacture date (DD/MM/YYYY): ");
        LocalDate date = LocalDate.parse(sc.next(), format);
        System.out.println(date.format(format));
    }
}
