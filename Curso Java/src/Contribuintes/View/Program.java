package Contribuintes.View;

import Contribuintes.Model.Contribuinte;
import Contribuintes.Model.PessoaFisica;
import Contribuintes.Model.PessoaJuridica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        List<Contribuinte> list = new ArrayList<>();

        for(int i=1; i<=n; i++){
            System.out.println("\u001B[1mTax payer #" + i + " data:\u001B[0m");
            System.out.print("Individual or company (f/j)? ");
            String tipo = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Renda anual: ");
            BigDecimal rendaAnual = sc.nextBigDecimal();

            if(tipo.equals("f")){
                System.out.print("Gastos com saude: ");
                BigDecimal gastosSaude = sc.nextBigDecimal();
                list.add(new PessoaFisica(name, rendaAnual, gastosSaude));
            }else {
                System.out.print("Quantidade de funcionarios: ");
                BigDecimal qtdFuncionarios = sc.nextBigDecimal();
                list.add(new PessoaJuridica(name, rendaAnual, qtdFuncionarios));
            }

        }

        System.out.println("\nTAXAS A PAGAR");
        BigDecimal total = BigDecimal.ZERO;
        for(Contribuinte contribuinte:list){
            System.out.println(contribuinte.getName()+": $ "+contribuinte.imposto().setScale(2, RoundingMode.HALF_UP));
            total = total.add(contribuinte.imposto());
        }
        System.out.println("\nTAXAS TOTAIS: $ "+total.setScale(2, RoundingMode.HALF_UP));

        sc.close();
    }
}
