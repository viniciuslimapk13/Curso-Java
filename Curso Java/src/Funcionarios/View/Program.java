package Funcionarios.View;

import Funcionarios.Model.Funcionarios;
import Funcionarios.Model.FuncionariosTerceirizados;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         System.out.print("Enter the number of employees: ");
         Integer n = sc.nextInt();
         List<Funcionarios> lista = new ArrayList<>();
         for (int i=1; i<=n; i++){
             System.out.println("\u001B[1mEmployee #" + i + " data:\u001B[0m");
             System.out.print("Terceirizado(y/n)? ");
             String terceirizado = sc.next();
             System.out.print("Nome: ");
             String nome = sc.next();
             System.out.print("Horas: ");
             Integer horas = sc.nextInt();
             System.out.print("Valor por horas: ");
             BigDecimal valorPorHora = sc.nextBigDecimal();

             if (terceirizado.equals("n")){
                 lista.add(new Funcionarios(nome, horas, valorPorHora));
             }else {
                 System.out.print("Valor adicional: ");
                 BigDecimal adicional = sc.nextBigDecimal();
                 lista.add(new FuncionariosTerceirizados(nome, horas, valorPorHora, adicional));
             }
         }

         System.out.println("\nPagamentos:");
         for(Funcionarios funcionario:lista){
             System.out.println(funcionario.getName()+" - $ "+funcionario.pagamento().setScale(2, RoundingMode.HALF_UP));
         }

    }
}
